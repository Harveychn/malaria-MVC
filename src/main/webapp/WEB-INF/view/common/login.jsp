<%--
  Created by IntelliJ IDEA.
  User: 郑晓辉
  Date: 2016/11/9
  Time: 22:14
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html lang="en">

<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0">

    <title>登录</title>
    <meta name="keywords" content="后台">
    <meta name="description" content="后台">
    <link rel="shortcut icon" href="${webRoot}/images/malaria.ico"/>
    <link href="${webRoot}/css/bootstrap.min.css" rel="stylesheet">
    <link href="${webRoot}/css/font-awesome.min.css" rel="stylesheet">
    <link href="${webRoot}/css/animate.css" rel="stylesheet">
    <link href="${webRoot}/css/style.css" rel="stylesheet">
    <link href="${webRoot}/css/plugins/login/login.css" rel="stylesheet">
    <!--[if lt IE 9]>
    <meta http-equiv="refresh" content="0;ie.html"/>
    <![endif]-->
    <style type="text/css">
        .btn-success {
            background-color: #39A7DA;
            border-color: #39A7DA;
        }
    </style>
    <script>
        if (window.top !== window.self) {
            window.top.location = window.location;
        }
    </script>

</head>

<body class="signin">
<div class="signinpanel">
    <div class="row">
        <div class="col-sm-7">
            <div class="signin-info">
                <div class="logopanel m-b">
                    <h1>基于时空的疟疾数据监控系统</h1>
                </div>
                <div class="m-b"></div>
                <h2>欢迎使用</h2>
            </div>
        </div>
        <div class="col-sm-5">
            <form method="post" action="/user/login">
                <h4 class="no-margins">登录：</h4>
                <%
                    if (null == request.getParameter("userCount")) {
                %>
                <input name="useremail" type="text" class="form-control uname" placeholder="用户名"/>
                <%
                    } else {
                %>
                <input name="useremail" type="text" class="form-control uname"
                       value="<%=request.getParameter("userCount")%>"/>
                <%
                    }
                %>

                <input name="userpassword" type="password" class="form-control pword m-b" placeholder="密码"/>
                <%
                    if (null != request.getParameter("errorMessage")) {
                %>
                <div style="font-size: 12px;color: #a82929;" align="right">
                    <%=new String(request.getParameter("errorMessage").getBytes("iso-8859-1"), "utf-8")%>
                </div>
                <%
                    }
                %>
                <strong><a href="">忘记密码&nbsp;&nbsp;&nbsp;</a></strong>
                &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<strong>还没有账号？ <a href="/user/registerView">立即注册&raquo;</a></strong>
                <button type="submit" class="btn btn-success btn-block">登录</button>
            </form>
        </div>
    </div>
    <div class="signup-footer">
        <div class="pull-left">
            &copy; 2016 开发
        </div>
    </div>
</div>
</body>

</html>
