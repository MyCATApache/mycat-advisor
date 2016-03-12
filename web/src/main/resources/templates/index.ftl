<!DOCTYPE html>
<html lang="zh-CN">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Mycat-ui Template</title>

    <link href="static/lib/media/light-gallery/css/lightGallery.css" rel="stylesheet"/>
    <link href="static/lib/media/mediaelement/mediaelementplayer.css" rel="stylesheet"/>

    <link href="static/lib/css/lib.min.css" rel="stylesheet"/>
    <link href="static/lib/css/app.min.1.css" rel="stylesheet"/>
    <link href="static/lib/css/app.min.2.css" rel="stylesheet"/>
    <link href="static/css/common.css" rel="stylesheet"/>
</head>
<body>

<header id="header">&nbsp;</header>
<section id="main">
    <aside id="sidebar">&nbsp;</aside>
    <aside id="chat">&nbsp;</aside>
    <section id="content">&nbsp;</section>
</section>
<footer id="footer">
    Copyright &copy; 2015 mycat All Rights Reserved 
</footer>

<div class="modal fade" id="divModal" tabindex="-1" role="dialog" aria-hidden="true">
    <div class="modal-dialog">
        <div class="modal-content">
        </div>
    </div>
</div>

<!-- Javascript Libraries -->
<script src="static/lib/js/lib.base.min.js"></script>
<script src="static/lib/js/lib.ex.min.js"></script>
<script src="static/js/template.js"></script>
<script src="static/js/mycatui.min.js"></script>
<script src="static/js/lang/jquery.validationEngine-zh_CN.js"></script>
<script src="static/js/lang/mycatui.zh_CN.js"></script>

<script src="static/lib/media/light-gallery/js/lightGallery.min.js"></script>
<script src="static/lib/echarts/echarts.js"></script>
<script>
    $(function(){
        require.config({
            paths: {
                echarts: 'static/lib/echarts'
            }
        });
    });
</script>
<script>
    $(function () {
        mycatui.init({
            topHash: '#static/_data/layout/top/index.json?tpl=layout/top/index',
            menuHash: '#static/_data/layout/sidebar/index.json?tpl=layout/sidebar/index',
            defaultHash: '#static/_data/home/index.json?tpl=home/index',
            logoutUrl: 'login'
        });
    });
</script>
</body>
</html>