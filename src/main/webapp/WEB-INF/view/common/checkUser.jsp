<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt_rt" %>
<%@ page import="com.zxh.ssm.module.whole.pojo.User" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>

    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">

    <title>审核页面</title>

    <link rel="shortcut icon" href="${webRoot}/images/malaria.ico">
    <link href="${webRoot}/css/bootstrap.min.css?v=3.3.6" rel="stylesheet">
    <link href="${webRoot}/css/font-awesome.min.css?v=4.4.0" rel="stylesheet">
    <link href="${webRoot}/css/plugins/footable/footable.core.css" rel="stylesheet">
    <link href="${webRoot}/css/animate.css" rel="stylesheet">
    <link href="${webRoot}/css/style.css?v=4.1.0" rel="stylesheet">
</head>

<body class="gray-bg">
<div class="wrapper wrapper-content animated fadeInRight">
    <div class="row">
        <div class="col-sm-12">
            <div class="ibox float-e-margins">
                <div class="ibox-title">
                    <h5>审核</h5>
                </div>
                <div class="ibox-content">
                    <%--<form action="/user/showCheckUser">--%>
                        <table class="footable table table-stripped toggle-arrow-tiny" data-page-size="8">
                            <thead>
                            <tr>

                                <th>用户名</th>
                                <th>真实姓名</th>
                                <th>邮箱</th>
                                <th>电话</th>
                                <th>用户单位</th>
                                <th>注册时间</th>
                                <th>操作</th>
                            </tr>
                            </thead>
                            <tbody>
                            <c:forEach items="${checkUser}" var="checkUser">
                                <tr>
                                    <td>${checkUser.username}</td>
                                    <td>${checkUser.userrealname}</td>
                                    <td>${checkUser.useremail}</td>
                                    <td>${checkUser.userphone}</td>
                                    <td>${checkUser.userunit}</td>
                                    <td><fmt:formatDate value="${checkUser.joindate}" pattern="yyyy-MM-dd HH:mm:ss"/> </td>
                                    <td><a href="#"><i class="fa fa-check text-navy"></i> 通过</a></td>
                                    <td><a href="#"><i class="fa fa-close text-navy"></i> 拒绝</a></td>
                                </tr>
                            </c:forEach>
                            </tbody>
                            <tfoot>
                            <tr>
                                <td colspan="5">
                                    <ul class="pagination pull-right"></ul>
                                </td>
                            </tr>
                            </tfoot>
                        </table>
                    <%--</form>--%>
                </div>
            </div>
        </div>
    </div>
</div>
<!-- 全局js -->
<script src="${webRoot}/js/jquery.min.js?v=2.1.4"></script>
<script src="${webRoot}/js/bootstrap.min.js?v=3.3.6"></script>
<script src="${webRoot}/js/plugins/footable/footable.all.min.js"></script>

<script>
    $(document).ready(function () {

        $('.footable').footable();
        $('.footable2').footable();

    });

</script>
</body>

</html>
