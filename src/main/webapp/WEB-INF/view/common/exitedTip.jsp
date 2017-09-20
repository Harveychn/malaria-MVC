<%--
  Created by IntelliJ IDEA.
  User: 郑晓辉
  Date: 2016/12/7
  Time: 9:03
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>退出系统</title>
    <link href="${webRoot}/images/malaria.ico" rel="shortcut icon"/>
    <link href="${webRoot}/css/bootstrap.min.css" rel="stylesheet" type="text/css"/>
    <link href="${webRoot}/css/animate.css" rel="stylesheet">
    <style>
        body.gray-bg {
            background: #18c8f6;
            height: auto;
            background: url(${webRoot}/css/plugins/iCheck/register/register-img.png) no-repeat center fixed;
            -webkit-background-size: cover;
            -moz-background-size: cover;
            -o-background-size: cover;
            ackground-size: cover;
            color: rgba(255, 255, 255, .95);
        }
        .logo-name{
            font-size:40px !important;
            font-weight: 300;
            letter-spacing: 10px;
            margin-bottom: 0px;
        }
        .backHome{
            font-size:20px !important;
            font-weight: 300;
            letter-spacing: 10px;
            margin-bottom: 0px;
            color: rgba(243, 219, 239, 0.98);
        }
        .backHome:hover{
            font-size:25px !important;
            font-weight: 300;
            letter-spacing: 10px;
            margin-bottom: 0px;
            color: rgba(243, 231, 229, 0.98);
        }
    </style>
</head>
<body class="gray-bg">
<div class="middle-box text-center loginscreen  animated fadeInDown">
    <div class="row" style="height: 40%;top: 230px;">
        <%--<h1 align="center" style="color: darkslategrey;">基于时空的疟疾数据监控系统</h1>--%>
        <h1 class="logo-name">退出成功</h1>
    </div>
    <div class="">
        <div class="row">
        </div>
        <div class="row">
            <div class="col-sm-8">
                <%--<h4>您还可以</h4>--%>
            </div>
            <div class="col-sm-4">
                <div class="btn btn-link btn-large"><a href="http://localhost:8080/" class="backHome">返回游客页面</a>
                </div>
            </div>
        </div>
    </div>
</div>
</body>
</html>
