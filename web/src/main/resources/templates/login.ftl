<!DOCTYPE html>
<html lang="zh-CN" class="login-content">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>后台管理登录</title>
    <link href="static/lib/css/lib.min.css" rel="stylesheet">
    <link href="static/lib/css/app.min.1.css" rel="stylesheet">
    <link href="static/lib/css/app.min.2.css" rel="stylesheet">
</head>
<body class="login-content">
<div class="lc-block toggled" id="l-login">
    <form action="login" method="post">
    <div class="input-group m-b-20">
        <span class="input-group-addon"><i class="zmdi zmdi-account"></i></span>

        <div class="fg-line">
            <input id="username" type="text" name="username" class="form-control" placeholder="用户名">
        </div>
    </div>
    <div class="input-group m-b-20">
        <span class="input-group-addon"><i class="zmdi zmdi-male"></i></span>

        <div class="fg-line">
           <#-- <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">-->
            <input id="pwd" type="password" name="password" class="form-control" placeholder="密码">
        </div>
    </div>
    <div class="clearfix"></div>
    <div class="checkbox">
        <label>
            <input id="keep" type="checkbox" name="remember-me" >
            <i class="input-helper"></i>
            记住用户名
        </label>
    </div>
        <#--<button class="btn btn-login btn-danger btn-float" type="submit"><i class="zmdi zmdi-arrow-forward"></i></button>-->
    <a id="login" href="#" class="btn btn-login btn-danger btn-float"></a>
    </form>
</div>

<script src="static/lib/js/lib.base.min.js"></script>
<script>
    $(function () {
        (function () {
            var keep = localStorage.getItem('login.keep');
            var username = localStorage.getItem('login.username');
            keep && $('#keep').prop('checked', true);
            username && $('#username').val('username');
        })();

        $('#login').click(function (e) {
            e.preventDefault();
            var keep = $('#keep:checked').val();
            var username = $('#username').val();
            var pwd = $('#pwd').val();
            if (keep) {
                localStorage.setItem('login.keep', keep);
                localStorage.setItem('login.username', username);
            }
            if (username && pwd) {
                $.post("doLogin", {
                    username:username,
                    password:pwd
                }, function (data){
                    if(data.flag) {
                        window.location.href = 'index';
                    }else {
                        alert(data.msg);
                    }
                }, 'json');
            } else {
                alert('请输入用户名和密码！');
            }
        });
    });
</script>
</body>
</html>