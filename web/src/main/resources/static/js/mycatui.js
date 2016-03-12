(function ($) {
    var $win = $(window);
    var $doc = $(document);
    var $html = $('html');
    var $body = $('body');
    // 默认配置参数
    var defaultOption = {
        // 顶部页面路径
        topHash: '',
        // 左侧菜单路径
        menuHash: '',
        // 默认页面路径
        defaultHash: '',
        // 退出路径
        logoutUrl: '',
        // 当前语言
        lang: 'zh-cn',
        json: {
            // 成功标识
            flag: 'flag',
            // 提示信息
            msg: 'msg',
            // 业务数据
            data: 'data',
            // 面包屑导航
            breadcrumbs: 'breadcrumbs',
            // 分页
            pagination: 'pageInfo',
            pageInfo: {
                totalCount: 'totalCount',
                pageIndex: 'pageIndex',
                pageCount: 'pageCount',
                showCount: 3
            },
            // 临时数据交换
            tempData: 'tempData',
            // 查询参数(前端提供)
            query: 'query',
            // 国际化(前端提供)
            lang: 'lang'
        },
        // 短日期格式
        dateFormat: 'YYYY-MM-DD',
        // 通知插件配置
        notifyOption: {
            placement: {
                from: 'bottom',
                align: 'right'
            },
            delay: 3000,
            animate: {
                enter: 'animated fadeInRight',
                exit: 'animated fadeOutRight'
            }
        },
        hash: {
            // 模板id
            tpl: 'tpl',
            // 目标菜单
            target: 'target'
        },
        // loading bar所在区域
        NProgressParent: '#main',
        // 顶部区域
        $header: $('#header'),
        // 左侧滑块
        $leftSidebar: $('#sidebar'),
        // 右侧滑块
        $rightSidebar: $('#chat'),
        // 内容区域
        $content: $('#content'),
        // 模式弹出div
        $modal: $('#divModal')
    };
    // 配置参数
    var option;
    // 本地化
    var lang;
    // 工具库(不公开)
    var tools = {
        findAttr: function (id, name) {
            var $tag = this.findSelector(id);
            return $tag.attr(name) || $tag.data(name);
        },
        findEvent: function (fn) {
            if (typeof fn === 'string') {
                return window[fn];
            } else {
                return fn;
            }
        },
        findSelector: function (id) {
            if (typeof id === 'string') {
                return $('#' + id);
            }
            return id;
        },
        scrollbar: function ($s, color, cursorWidth) {
            $s.niceScroll({
                cursorcolor: color,
                cursorborder: 0,
                cursorborderradius: 0,
                cursorwidth: cursorWidth,
                bouncescroll: true,
                mousescrollstep: 100,
                //autohidemode: false
            });
        },
        json2excel: function (json) {
            var worksheet = json.sheet || 'Sheet1';
            var i, j;
            var excel = "<table>";
            // 表头部分
            if (json.title) {
                excel += "<tr>";
                for (i = 0; i < json.title.length; i++) {
                    excel += "<td>" + json.title[i] + "</td>";
                }
                excel += '</tr>';
            }
            // 数据部分
            if (json.list) {
                for (i = 0; i < json.list.length; i++) {
                    excel += "<tr>";
                    for (j = 0; j < json.list[i].length; j++) {
                        excel += "<td>" + json.list[i][j] + "</td>";
                    }
                    excel += '</tr>';
                }
            }
            excel += '</table>';

            var excelFile = "<html xmlns:o='urn:schemas-microsoft-com:office:office' xmlns:x='urn:schemas-microsoft-com:office:excel' xmlns='http://www.w3.org/TR/REC-html40'>";
            excelFile += "<head>";
            excelFile += "<!--[if gte mso 9]>";
            excelFile += "<xml>";
            excelFile += "<x:ExcelWorkbook>";
            excelFile += "<x:ExcelWorksheets>";
            excelFile += "<x:ExcelWorksheet>";
            excelFile += "<x:Name>";
            excelFile += worksheet;
            excelFile += "</x:Name>";
            excelFile += "<x:WorksheetOptions>";
            excelFile += "<x:DisplayGridlines/>";
            excelFile += "</x:WorksheetOptions>";
            excelFile += "</x:ExcelWorksheet>";
            excelFile += "</x:ExcelWorksheets>";
            excelFile += "</x:ExcelWorkbook>";
            excelFile += "</xml>";
            excelFile += "<![endif]-->";
            excelFile += "</head>";
            excelFile += "<body>";
            excelFile += excel;
            excelFile += "</body>";
            excelFile += "</html>";

            var base64data = "base64," + $.base64.encode(excelFile);
            window.open('data:application/vnd.ms-excel;filename=exportData.doc;' + base64data);
        }
    };
    // 模式对话框
    var msg = {
        info: function (title, text) {
            swal({
                title: title,
                text: text,
                type: 'info',
                confirmButtonText: lang.btn.close
            });
        },
        success: function (title, text) {
            swal({
                title: title,
                text: text,
                type: 'success',
                confirmButtonText: lang.btn.close
            });
        },
        error: function (title, text) {
            swal({
                title: title,
                text: text,
                type: 'error',
                confirmButtonText: lang.btn.close
            });
        },
        confirm: function (title, fn) {
            swal({
                title: title,
                type: 'warning',
                showCancelButton: true,
                cancelButtonText: lang.btn.cancel,
                confirmButtonText: lang.btn.ok
            }, function () {
                if (fn) {
                    tools.findEvent(fn)();
                }
            });
        }
    };
    // 通知消息框
    var notify = {
        info: function (msg) {
            _notify(msg, 'info');
        },
        success: function (msg) {
            _notify(msg, 'success');
        },
        warning: function (msg) {
            _notify(msg, 'warning');
        },
        error: function (msg) {
            _notify(msg, 'danger');
        }
    };

    function _notify(message, type) {
        var op = $.extend(true, {type: type}, option.notifyOption);
        $.growl({
            message: message
        }, op);
    }

    // 异步提交数据
    var ajax = {
        getJSON: function (url, data, fn, global) {
            _ajax('get', url, data, fn, global);
        },
        postJSON: function (url, data, fn, global) {
            _ajax('post', url, data, fn, global);
        }
    };

    function _ajax(type, url, data, fn, global, fnError) {
        global = global !== false;
        $.ajax({
            type: type,
            url: url,
            cache: false,
            data: data,
            success: function (data) {
                if (data[option.json.flag]) {
                    if (fn) {
                        tools.findEvent(fn)(data[option.json.data]);
                    } else if (type === 'post') {
                        notify.success(lang.msg.success);
                        // 刷新页面
                        page.reload();
                        // 隐藏模式框
                        modal.hide();
                    }
                } else {
                    notify.error(data.msg);
                    if (fnError) {
                        fnError();
                    }
                }
            },
            dataType: 'json',
            global: global
        });
    }

    // 页面加载
    var page = {
        loadStatic: function (id, tpl, data) {
            _render(id, tpl, data);
        },
        load: function (hash) {
            _loadPage(option.$content, hash);
            _initMenu(hash);
        },
        reload: function () {
            this.load(window.location.hash);
        },
        loadPart: function (id, hash) {
            _loadPage(id, hash, false);
        }
    };
    // 初始化菜单
    function _initMenu(hash) {
        option.$leftSidebar.find('a.active').removeClass('active');
        option.$leftSidebar.find('div.toggled,li.toggled').removeClass('active toggled');
        option.$leftSidebar.find('div.profile-menu>ul.main-menu').hide();
        option.$leftSidebar.find('li.sub-menu>ul').hide();

        hash = _parseHash(hash);
        var target = hash.target;
        if (target) {
            option.$leftSidebar.find('a[data-target="' + target + '"]').each(function () {
                var $a = $(this);
                var $subMenu = $a.parents('li.sub-menu');
                if ($subMenu.length) {
                    $subMenu.addClass('active toggled');
                    $subMenu.find('>ul').show();
                    $a.addClass('active');
                } else {
                    $a.parent().addClass('active');
                    var $profileMenu = $a.parents('div.profile-menu');
                    if ($profileMenu.length) {
                        $profileMenu.addClass('toggled');
                        $profileMenu.find('ul.main-menu').show();
                    }
                }
            });
        } else {
            option.$leftSidebar.find('div.sidebar-inner>ul.main-menu>li:first').addClass('active');
        }
    }

    function _loadPage(id, hash, global, fn) {
        if (!hash || hash === '#') {
            hash = option.defaultHash;
        }
        hash = _parseHash(hash);
        ajax.getJSON(hash.url, hash.data, function (data) {
            // get请求参数回填
            data[option.json.query] = hash.data;
            // 本地化数据
            data[option.json.lang] = lang;
            // 面包屑
            var breadcrumbs = data[option.json.breadcrumbs];
            if (typeof breadcrumbs === 'string') {
                data[option.json.breadcrumbs] = [{title: breadcrumbs}];
            }
            // 分页
            var pagination = data[option.json.pagination];
            if (pagination) {
                data.pagination = _pagination(pagination);
            }
            // 临时数据
            var tempData = data[option.json.tempData];
            if (tempData) {
                window[option.json.tempData] = tempData;
                delete data[option.json.tempData];
            }
            _render(id, hash.tpl, data);
            _nice(id);
            _initCtrl(id);
            fn && fn();
        }, global);
    }

    // 分页(模板不同需要对应修改)
    function _pagination(data) {
        var totalCount = data[option.json.pageInfo.totalCount];
        if (!totalCount) {
            return '';
        }
        // 显示个数
        var showCount = option.json.pageInfo.showCount || 3;
        // 每页显示个数
        var pageCount = data[option.json.pageInfo.pageCount] || 8;
        // 当前页索引
        var pageIndex = data[option.json.pageInfo.pageIndex] || 0;
        // 总页数
        var totalPage = Math.ceil(totalCount / pageCount);
        // 当前页
        var page = pageIndex + 1;
        if (page < 1) {
            page = 1;
        }
        if (page > totalPage) {
            page = totalPage;
        }
        // 开始
        var pageStart = page - showCount;
        if (pageStart < 1) {
            pageStart = 1;
        }
        // 结束
        var pageEnd = page + showCount;
        if (pageEnd > totalPage) {
            pageEnd = totalPage;
        }
        // HTML
        var interval = '<li><a><i class="zmdi zmdi-more-horiz"></i></a></li>';
        var html = '<div class="bootgrid-footer container-fluid"><div class="row"><div class="col-sm-12 m-b-25"><ul class="pagination">';
        // 上一页
        html += '<li';
        if (page === 1) {
            html += ' class="disabled"';
        }
        html += '><a';
        if (page !== 1) {
            html += ' href="' + pageHref(page - 2, pageCount) + '"';
        }
        html += ' aria-label="' + lang.btn.prev + '"><i class="zmdi zmdi-chevron-left"></i></a></li>';
        // 间隔段
        if (pageStart > 1) {
            html += interval;
        }
        // 页码区
        for (var i = pageStart; i <= pageEnd; i++) {
            html += '<li';
            if (i === page) {
                html += ' class="active"';
            }
            html += '><a href="' + pageHref(i - 1, pageCount) + '">' + i;
            if (i === page) {
                html += ' <span class="sr-only">(current)</span>';
            }
            html += '</a></li>';
        }
        // 间隔段
        if (pageEnd < totalPage) {
            html += interval;
        }
        // 下一页
        html += '<li';
        if (page === totalPage) {
            html += ' class="disabled"';
        }
        html += '><a';
        if (page !== totalPage) {
            html += ' href="' + pageHref(page, pageCount) + '"';
        }
        html += ' aria-label="' + lang.btn.next + '"><i class="zmdi zmdi-chevron-right"></i></a></li>';
        html += '</ul></div></div></div>';
        return html;

        function pageHref(pageIndex, pageCount) {
            var pageIndexName = option.json.pageInfo.pageIndex;
            var pageCountName = option.json.pageInfo.pageCount;
            return '#' + URI(window.location.hash.substring(1)).setSearch(pageIndexName, pageIndex).setSearch(pageCountName, pageCount);
        }
    }

    // 美化控件
    function _nice(id) {
        var $selector = tools.findSelector(id);
        // Waves Animation
        Waves.attach('.btn:not(.btn-icon):not(.btn-float)');
        Waves.attach('.btn-icon, .btn-float', ['waves-circle', 'waves-float']);
        Waves.init();
        // Lightbox
        $selector.find('.lightbox').lightGallery({
            enableTouch: true
        });
        // HTML Editor
        $selector.find('.html-editor').summernote({
            height: 200,
            lang: option.lang
        });
        // 美化文本框
        $selector.find('.fg-float .form-control').each(function () {
            var i = $(this).val();
            if (!i.length == 0) {
                $(this).closest('.fg-line').addClass('fg-toggled');
            }
        });
        // 美化滚动条
        if (!$html.hasClass('ismobile')) {
            //Scrollbar Tables
            var $t = $selector.find('.table-responsive');
            $t[0] && tools.scrollbar($t, 'rgba(0,0,0,0.5)', '5px');

            //Scrill bar for Chosen
            $t = $selector.find('.chosen-results');
            $t[0] && tools.scrollbar($t, 'rgba(0,0,0,0.5)', '5px');


            //Scroll bar for tabs
            $t = $selector.find('.tab-nav');
            $t[0] && tools.scrollbar($t, 'rgba(0,0,0,0)', '1px');

            // TODO Scroll bar for dropdowm-menu
            //$t = $selector.find('.dropdown-menu .c-overflow');
            //$t[0] && tools.scrollbar($t, 'rgba(0,0,0,0.5)', '0px');

            //Scrollbar for rest
            $t = $selector.find('.c-overflow');
            $t[0] && tools.scrollbar($t, 'rgba(0,0,0,0.5)', '5px');
        }
    }

    // 初始化控件
    function _initCtrl(id) {
        var $selector = tools.findSelector(id);
        // 表单验证
        $selector.find('.form-validate').validationEngine({scroll: true});
        // 树
        $selector.find('.tbl-tree').each(function () {
            var $tree = $(this);
            var lvl = parseInt($tree.data('lvl'));
            table.tree($tree, lvl);
        });
        $selector.find('.tbl-dyna-tree').each(function () {
            var $tree = $(this);
            var url = $tree.data('url');
            var tpl = $tree.data('tpl');
            table.dynaTree($tree, url, tpl);
        });
        // Select
        $selector.find('.select-picker').each(function () {
            var $sel = $(this);
            var value = $sel.data('value');
            $sel.selectpicker();
            value && $sel.selectpicker('val', value);
        });
        // Date
        $selector.find('.date-picker').datetimepicker({
            format: option.dateFormat
        });
        $selector.find('.date-time-picker').datetimepicker();
        $selector.find('.daterange-picker').daterangepicker({
            autoApply: true,
            locale: {
                format: option.dateFormat
            }
        });
        // 自动完成
        $selector.find('.auto-complete,.auto-select').each(function () {
            var $text = $(this);
            var url = $text.data('url');
            if (!url) {
                return;
            }
            var option = {
                ajax: {
                    url: url,
                    triggerLength: 1,
                    scrollBar: true
                }
            };
            if ($text.hasClass('auto-select')) {
                var name = $text.attr('name');
                $text.removeAttr('name');
                var text = $text.data('text') || '';
                $text.after($('<input type="hidden" class="selected-text" value="' + text + '" name="' + name + 'Text">'));
                $text.after($('<input type="hidden" class="selected-value" value="' + $text.val() + '" name="' + name + '">'));
                $text.val(text);

                option.onSelect = function (item) {
                    $text.nextAll('.selected-text').val(item.text);
                    $text.nextAll('.selected-value').val(item.value);
                    var fn = $text.data('fn');
                    if (fn) {
                        window[fn](item);
                    }
                };
                $text.blur(function () {
                    var value = $text.val();
                    var oldText = $text.nextAll('.selected-text').val();
                    if (!value) {
                        $text.nextAll('.selected-text').val('');
                        $text.nextAll('.selected-value').val('');
                    } else if (value !== oldText) {
                        $text.val(oldText);
                    }
                });
            }
            $text.typeahead(option);
        });
        // 上传excel
        $selector.find('.upload-xsl input').each(function () {
            $(this).fileupload({
                url: $(this).data('url'),
                dataType: 'json',
                acceptFileTypes: /(\.|\/)(xls|xlsx)$/i,
                maxFileSize: 2 * 1024 * 1024,
                messages: {
                    acceptFileTypes: '只能上传EXCEL文件',
                    maxFileSize: '文件大小不能超过2M'
                }
            }).on('fileuploadprocessalways', function (e, data) {
                var file = data.files[data.index];
                if (file.error) {
                    var msg = file.name + ' : ' + file.error;
                    notify.error(msg);
                }
            }).on('fileuploaddone', function (e, data) {
                if (data.result.flag) {
                    notify.success('上传成功');
                    page.reload();
                } else {
                    notify.error(data.result.msg);
                }
            }).on('fileuploadfail', function (e, data) {
                notify.error('文件无法上传到服务器');
            }).prop('disabled', !$.support.fileInput)
                .parent().addClass($.support.fileInput ? undefined : 'disabled');
        });
    }

    // 解析Hash
    function _parseHash(hash) {
        if (hash.substr(0, 1) === '#') {
            hash = hash.substring(1);
        }
        var uri = URI(hash);
        var url = uri.path();
        var data = uri.query(true);
        var tpl = data[option.hash.tpl] || url;
        var target = data[option.hash.target] || tpl;
        delete data[option.hash.tpl];
        delete data[option.hash.target];
        return {
            url: url,
            tpl: tpl,
            data: data,
            target: target
        };
    }

    // 模板组装
    function _render(id, tpl, data) {
        var $selector = tools.findSelector(id);
        var html = template(tpl, data);
        $selector.html(html);
    }

    // 表格
    var table = {
        tree: function (id, lvl) {
            _treeTable(id, lvl);
        },
        dynaTree: function (id, url, tpl) {
            _treeTable(id, false, url, tpl);
        },
        hasChild: function (treeId, nodeId) {
            return !!$('.' + nodeId, tools.findSelector(treeId)).length;
        },
        getCheckedValue: function (id) {
            return tools.findSelector(id).find('.chk-line:checked').serialize();
        }
    };
    // 树形表格
    function _treeTable(id, lvl, url, tpl) {
        var $tree = tools.findSelector(id);
        var expandLevel = lvl || 1;
        var option = {
            //theme: 'vsStyle',
            expandLevel: expandLevel
        };
        if (url && tpl) {
            option.beforeExpand = function ($treeTable, id) {
                if (table.hasChild($treeTable, id)) {
                    return;
                }
                _ajax('get', url.replace('#id#', id), null, function (data) {
                    if (data.list) {
                        data.pid = id;
                        var html = template(tpl, data);
                        $treeTable.addChilds(html);
                    } else {
                        $('#' + id + ' span[arrow="true"]').attr('class', 'vsStyle_node vsStyle_last_leaf');
                    }
                }, true, function () {
                    $('#' + id + ' span[arrow="true"]').attr('class', 'vsStyle_active_node vsStyle_last_shut');
                });
            }
        }
        $tree.treeTable(option);
    }

    // 模式框
    var modal = {
        show: function (hash, size) {
            _loadPage(option.$modal.find('.modal-content'), hash, true, function () {
                var $dialog = option.$modal.children();
                $dialog.removeClass('modal-lg modal-sm');
                if (size === 'modal-lg' || size === 'modal-sm') {
                    $dialog.addClass(size);
                }
                option.$modal.modal('show');
            });
        },
        hide: function () {
            option.$modal.modal('hide');
        }
    };

    // 图表
    var chart = {
        sparklineBar: function (id, values, height, barWidth, barColor, barSpacing) {
            tools.findSelector(id).sparkline(values, {
                type: 'bar',
                height: height,
                barWidth: barWidth,
                barColor: barColor,
                barSpacing: barSpacing
            })
        },
        sparklineLine: function (id, values, width, height, lineColor, fillColor, lineWidth, maxSpotColor, minSpotColor, spotColor, spotRadius, hSpotColor, hLineColor) {
            tools.findSelector(id).sparkline(values, {
                type: 'line',
                width: width,
                height: height,
                lineColor: lineColor,
                fillColor: fillColor,
                lineWidth: lineWidth,
                maxSpotColor: maxSpotColor,
                minSpotColor: minSpotColor,
                spotColor: spotColor,
                spotRadius: spotRadius,
                highlightSpotColor: hSpotColor,
                highlightLineColor: hLineColor
            });
        },
        sparklinePie: function (id, values, width, height, sliceColors) {
            tools.findSelector(id).sparkline(values, {
                type: 'pie',
                width: width,
                height: height,
                sliceColors: sliceColors,
                offset: 0,
                borderWidth: 0
            });
        },
        easyPieChart: function (id, trackColor, scaleColor, barColor, lineWidth, lineCap, size) {
            tools.findSelector(id).easyPieChart({
                trackColor: trackColor,
                scaleColor: scaleColor,
                barColor: barColor,
                lineWidth: lineWidth,
                lineCap: lineCap,
                size: size
            });
        }
    };
    var echart = {
        createByOp: function (type, id, option) {
            type = 'echarts/chart/' + type;
            require(['echarts', type], function (ec) {
                var chart = ec.init(document.getElementById(id));
                chart.setOption(option);

            });
        },
        createByOpName: function (type, id, optName) {
            var op = window[option.json.tempData][optName];
            delete window[option.json.tempData][optName];
            this.createByOp(type, id, op);
        }
    };

    // 导出接口
    window.mycatui = {
        langs: [],
        init: function (op) {
            option = $.extend(true, {}, defaultOption, op);
            // 本地化 TODO 动态加载相关文件
            lang = this.langs[option.lang];
            moment.locale('zh_cn');
            NProgress.configure({parent: option.NProgressParent});
            // 移动端浏览器适配
            if (/Android|webOS|iPhone|iPad|iPod|BlackBerry|IEMobile|Opera Mini/i.test(navigator.userAgent)) {
                $html.addClass('ismobile');
            } else {
                tools.scrollbar($html, 'rgba(0,0,0,0.3)', '5px');
            }
            // 加载页面
            page.loadPart(option.$header, option.topHash);
            _loadPage(option.$leftSidebar, option.menuHash, false, function () {
                _init();
            });
        },
        msg: msg,
        notify: notify,
        ajax: ajax,
        page: page,
        table: table,
        chart: chart,
        echart: echart
    };

    function _init() {
        // 加载页面
        page.load(window.location.hash);
        // 框架事件绑定
        (function () {
            $win.on('hashchange', function () {
                page.load(window.location.hash);
            });
            $doc.ajaxSend(function () {
                NProgress.start();
            }).ajaxComplete(function () {
                NProgress.done();
            }).ajaxError(function (e, request, settings) {
                var view = {};
                view.status = request.status;
                view.url = settings.url;
                switch (view.status) {
                    case 401:
                        msg.confirm(lang.msg.e401, function () {
                            window.location.href = option.logoutUrl;
                        });
                        break;
                    case 403:
                        notify.error(lang.msg.e403);
                        break;
                    case 404:
                        view.msg = lang.msg.e404;
                        page.loadStatic(option.$content, 'public/error', view);
                        break;
                    case 408:
                        notify.error(lang.msg.e408);
                        break;
                    case 500:
                        view.msg = lang.msg.e500;
                        page.loadStatic(option.$content, 'public/error', view);
                        break;
                    default :
                        console.log(view);
                }
            });
        })();
        // 顶部区域事件绑定
        (function () {
            $body.on('click', '#top-search > a', function (e) {
                e.preventDefault();
                $('#header').addClass('search-toggled');
                $('#top-search-wrap').find('input').focus();
            });
            $body.on('click', '#top-search-close', function (e) {
                e.preventDefault();
                $('#header').removeClass('search-toggled');
            });

            var layoutStatus = localStorage.getItem('ma-layout-status');
            if (layoutStatus == 1) {
                $body.addClass('sw-toggled');
                $('#tw-switch').prop('checked', true);
            }
            $body.on('change', '#toggle-width input:checkbox', function () {
                if ($(this).is(':checked')) {
                    setTimeout(function () {
                        $body.addClass('toggled sw-toggled');
                        localStorage.setItem('ma-layout-status', 1);
                    }, 250);
                } else {
                    setTimeout(function () {
                        $body.removeClass('toggled sw-toggled');
                        localStorage.setItem('ma-layout-status', 0);
                        $('.main-menu > li').removeClass('animated');
                    }, 250);
                }
            });
            /* 全屏显示 */
            $body.on('click', 'a[data-action="fullscreen"]', function (e) {
                e.preventDefault();
                launchIntoFullscreen(document.documentElement);
                $(this).closest('.dropdown').removeClass('open');

                function launchIntoFullscreen(element) {
                    if (element.requestFullscreen) {
                        element.requestFullscreen();
                    } else if (element.mozRequestFullScreen) {
                        element.mozRequestFullScreen();
                    } else if (element.webkitRequestFullscreen) {
                        element.webkitRequestFullscreen();
                    } else if (element.msRequestFullscreen) {
                        element.msRequestFullscreen();
                    }
                }

                function exitFullscreen() {
                    if (document.exitFullscreen) {
                        document.exitFullscreen();
                    } else if (document.mozCancelFullScreen) {
                        document.mozCancelFullScreen();
                    } else if (document.webkitExitFullscreen) {
                        document.webkitExitFullscreen();
                    }
                }
            });
            /* 清空本地数据 */
            $body.on('click', 'a[data-action="clear-localstorage"]', function (e) {
                e.preventDefault();
                mycatui.msg.confirm(lang.msg.clearLocalstorageConfirm, function () {
                    localStorage.clear();
                    mycatui.notify.success(lang.msg.clearLocalstorageSuccess);
                });
            });
            // TODO 滑块切换
            $body.on('click', '#menu-trigger, #chat-trigger', function (e) {
                e.preventDefault();
                var x = $(this).data('trigger');
                $(x).toggleClass('toggled');
                $(this).toggleClass('open');
                $body.toggleClass('modal-open');

                // 关闭打开的子菜单
                $('.sub-menu.toggled').not('.active').each(function () {
                    $(this).removeClass('toggled');
                    $(this).find('ul').hide();
                });
                $('.profile-menu .main-menu').hide();

                var $elem;
                var $elem2;
                if (x == '#sidebar') {
                    $elem = '#sidebar';
                    $elem2 = '#menu-trigger';
                    $('#chat-trigger').removeClass('open');
                    if (!option.$rightSidebar.hasClass('toggled')) {
                        option.$header.toggleClass('sidebar-toggled');
                    } else {
                        option.$rightSidebar.removeClass('toggled');
                    }
                } else if (x == '#chat') {
                    $elem = '#chat';
                    $elem2 = '#chat-trigger';
                    $('#menu-trigger').removeClass('open');
                    if (!option.$leftSidebar.hasClass('toggled')) {
                        option.$header.toggleClass('sidebar-toggled');
                    } else {
                        option.$leftSidebar.removeClass('toggled');
                    }
                }

                // 点击滑块以外区域则关闭滑块
                if (option.$header.hasClass('sidebar-toggled')) {
                    $doc.on('click', function (e) {
                        if (($(e.target).closest($elem).length === 0) && ($(e.target).closest($elem2).length === 0)) {
                            setTimeout(function () {
                                $body.removeClass('modal-open');
                                $($elem).removeClass('toggled');
                                option.$header.removeClass('sidebar-toggled');
                                $($elem2).removeClass('open');
                            });
                        }
                    });
                }
            })
        })();
        // 左侧菜单区域事件绑定
        (function () {
            $body.on('click', 'div.profile-menu>a,li.sub-menu>a', function (e) {
                e.preventDefault();
                var $this = $(this);
                $this.next().slideToggle(200);
                $this.parent().toggleClass('toggled');
            });
            /* 退出 */
            $body.on('click', 'a[data-action="logout"]', function (e) {
                e.preventDefault();
                mycatui.msg.confirm(lang.msg.logoutConfirm, function () {
                    window.location.href = option.logoutUrl;
                });
            });
        })();
        // 控件事件绑定
        (function () {
            // 常规按钮
            $body.on('click', '.btn-nav', function () {
                var href = $(this).attr('href');
                if (href === window.location.hash) {
                    page.load(href);
                }
            });
            $body.on('click', '.btn-search', function (e) {
                e.preventDefault();
                var $form = $(this).parents('form');
                var hash = $form.attr('action');
                hash += (hash.indexOf('?') === -1 ? '?' : '&');
                hash += $form.serialize();
                window.location.hash = hash;
            });
            $body.on('click', '.btn-del', function (e) {
                e.preventDefault();
                var $btn = $(this);
                var id = $btn.data('id');
                var $tbody = $btn.parents('tbody');
                if ($tbody.hasClass('tree_table') && table.hasChild($tbody, id)) {
                    notify.error(lang.msg.notDeleteTreeHasChild);
                    return;
                }
                msg.confirm(lang.msg.deleteConfirm, function () {
                    var url = $btn.data('url');
                    var data = {id: id};
                    ajax.postJSON(url, data);
                });
            });
            $body.on('click', '.btn-save', function (e) {
                e.preventDefault();
                var $this = $(this);
                var fnPre = $this.data('fnPre');
                if (fnPre) {
                    if (window[fnPre]() === false) {
                        return;
                    }
                }
                var $form = $this.parents('form');
                if ($form.validationEngine('validate')) {
                    ajax.postJSON($form.prop('action'), $form.serialize(), $this.data('fn'));
                }
            });
            $body.on('click', '.btn-modal', function (e) {
                e.preventDefault();
                var $this = $(this);
                var hash = tools.findAttr($this, 'href');
                var size = $this.data('size');
                modal.show(hash, size);
            });
            // 表格复选框
            $body.on('click', 'table input.chk-all', function () {
                $(this).parents('table').find('tbody input.chk-line').prop('checked', this.checked);
            });
            $body.on('click', 'table input.chk-line', function () {
                var $chk = $(this);
                var $tbody = $chk.parents('tbody');
                if ($tbody.hasClass('tree_table')) {
                    // 树形表格
                    var id = this.value;
                    if (this.checked && $tbody.hasClass('tree-single')) {
                        // 平级排他
                        chkBrother(id);
                    } else {
                        // 向下
                        chkChildren(id, this.checked);
                    }
                    // 向上
                    if (this.checked) {
                        chkParent(id);
                    }
                    // 将父节点选中
                    function chkParent(id) {
                        var pid = $('#' + id).attr('pid');
                        if (pid) {
                            $('#' + pid).find('.chk-line').prop('checked', true);
                            if ($tbody.hasClass('tree-single')) {
                                chkBrother(pid);
                            }
                            chkParent(pid);
                        }
                    }

                    // 将兄弟节点及其子节点取消选中
                    function chkBrother(id) {
                        var $tr = $('#' + id);
                        var pid = $tr.attr('pid');
                        $tr.siblings('[pid="' + pid + '"]').find('.chk-line').each(function () {
                            this.checked = false;
                            chkChildren(this.value, false);
                        });
                    }

                    // 改变子节点选中状态
                    function chkChildren(id, checked) {
                        $tbody.find('.' + id).each(function () {
                            $(this).find('.chk-line').prop('checked', checked);
                            chkChildren(this.id, checked);
                        });
                    }
                } else {
                    // 常规表格
                    var allChecked = true;
                    $tbody.find('.chk-line').each(function () {
                        if (!this.checked) {
                            allChecked = false;
                            return false;
                        }
                    });
                    $tbody.parent().find('.chk-all').prop('checked', allChecked);
                }
            });
            // 导出EXCEL
            $body.on('click', '.btn-export', function (e) {
                e.preventDefault();
                var $this = $(this);
                var url = $this.data('url');
                var formId = $this.data('formId');
                var data = {};
                if (formId) {
                    data = $('#' + formId).serialize();
                }
                ajax.getJSON(url, data, function (data) {
                    tools.json2excel(data);
                });
            });
            // 上传Excel
            $body.on('click', '.upload-xsl', function (e) {
                e.preventDefault();
                $(this).find('input').click();
            }).on('click', '.upload-xsl input', function (e) {
                e.stopPropagation();
            });
            // 列表搜索框
            $body.on('click', '.lvh-search-trigger', function (e) {
                e.preventDefault();
                x = $(this).closest('.lv-header-alt').find('.lvh-search');

                x.fadeIn(300);
                x.find('.lvhs-input').focus();
            });
            $body.on('click', '.lvh-search-close', function () {
                x.fadeOut(300);
                setTimeout(function () {
                    x.find('.lvhs-input').val('');
                }, 350);
            });
            // 控件动画
            $body.on('focus', '.form-control', function () {
                $(this).closest('.fg-line').addClass('fg-toggled');
            });
            $body.on('blur', '.form-control', function () {
                var p = $(this).closest('.form-group');
                var i = p.find('.form-control').val();

                if (p.hasClass('fg-float')) {
                    if (i.length == 0) {
                        $(this).closest('.fg-line').removeClass('fg-toggled');
                    }
                }
                else {
                    $(this).closest('.fg-line').removeClass('fg-toggled');
                }
            });
        })();
    }
})(window.jQuery);
