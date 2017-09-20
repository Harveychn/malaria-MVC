<%--
  Created by IntelliJ IDEA.
  User: 郑晓辉
  Date: 2016/11/9
  Time: 22:01
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="UTF-8">
    <title>首页</title>
    <link rel="shortcut icon" href="${webRoot}/images/malaria.ico"/>
    <link rel="stylesheet" type="text/css" href="${webRoot}/css/bootstrap.min.css"/>
    <link rel="stylesheet" type="text/css" href="${webRoot}/css/font-awesome.min.css"/>
    <link rel="stylesheet" type="text/css" href="${webRoot}/css/animate.css"/>
    <link rel="stylesheet" type="text/css" href="${webRoot}/css/style.css"/>

</head>
<body class="gray-bg">
<div class="row border-bottom white-bg dashboard-header">
    <!--<div class="col-sm-1"></div>-->
    <div class="col-sm-8">
        <div class="jumbotron">
            <h1>欢迎访问</h1>
            <h2>--基于时空的疟疾数据监控系统</h2>
            <p>该系统为您提供更全面的数据，更直观的监控。</p>
            <!--<p><a class="btn btn-primary btn-lg" href="#" role="button">Learn more</a></p>-->
            <h2>功能简介：</h2>
            <ol class="font-noraml float-e-margins">
                <li>数据导入</li>
                <li>数据下载</li>
                <li>执行计算</li>
                <li>爆发与分析</li>
                <li>数据分析</li>
                <li>统计预测</li>
                <li>相关数据</li>
            </ol>
        </div>
    </div>
    <div class="col-sm-4">
        <div class="ibox float-e-margins">
            <div class="ibox-title">
                <h5>我的定位</h5>
            </div>
            <div class="ibox-content">
                <div style="height:400px; ">
                    <iframe width="100%" height="100%" src="locatedUserMap.jsp" frameborder="0"
                            data-id="locatedUserMap.jsp" seamless>
                    </iframe>
                </div>
            </div>
        </div>
    </div>
    <div class="col-sm-6">
        <div class="ibox float-e-margins">
            <div class="ibox-title">
                <h5>更新日志</h5>
            </div>
            <div class="ibox-content no-padding">
                <div class="panel-body">
                    <div class="panel-group" id="version">
                        <div class="panel panel-default">
                            <div class="panel-heading">
                                <h5 class="panel-title">
                                    <a data-toggle="collapse" data-parent="#version" href="#v41">v1.0</a><code
                                        class="pull-right">2016.11.10</code>
                                </h5>
                            </div>
                            <div id="v41" class="panel-collapse collapse in">
                                <div class="panel-body">
                                    <div class="alert alert-warning">此版本是一个测试版本，主要是实现各种功能，让我们期待2.0的到来。</div>
                                    <ol>
                                        <li>首页修改地图大小，增加简介功能，让用户更直观了解该系统。</li>
                                        <li>用户和管理员功能修改。</li>
                                    </ol>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>

    <div class="col-sm-6">
        <div class="ibox float-e-margins">
            <div class="ibox-title">
                <h5>联系信息</h5>

            </div>
            <div class="ibox-content">
                <p><i class="fa fa-send-o"></i> 邮箱：<br>benyunshi@outlook.com, hongjunqiu@outlook.com</p>
                <p><i class="fa fa-institution"></i> 单位：<br>杭州电子科技大学复杂数据与公共安全实验室</p>
                <p><i class="fa fa-building"></i> 地址：<br>浙江省下沙高教园区2号大街1号 310018</p>
            </div>
        </div>
    </div>
</div>

<script src="${webRoot}/js/jquery.min.js"></script>
<script src="${webRoot}/js/bootstrap.min.js"></script>
<script src="${webRoot}/js/plugins/layer/layer.js"></script>
</body>
</html>
