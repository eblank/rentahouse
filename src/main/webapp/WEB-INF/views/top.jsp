<%--suppress HtmlDeprecatedTag --%>
<%--
Created by IntelliJ IDEA.
User: LXPENG
Date: 2016/5/4
Time: 15:57
To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="UTF-8">
    <title>Title</title>
    <link href="/assets/css/bootstrap.css" rel="stylesheet">

    <link href="/assets/css/dashboard.css" rel="stylesheet">
</head>

<nav class="navbar navbar-inverse navbar-fixed-top">
    <div class="container-fluid">
        <div class="navbar-header">
            <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#navbar"
                    aria-expanded="false" aria-controls="navbar">
                <span class="sr-only">Toggle navigation</span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
            </button>
            <a class="navbar-brand" href="#">个人租房信息管理</a>
        </div>
        <div id="navbar" class="navbar-collapse collapse">
            </ul>
            <ul class="nav navbar-nav navbar-right">
                <li class="dropdown">
                    <a href="#" class="dropdown-toggle" data-toggle="dropdown">
                        ${sessionScope.currentUser.nickName}
                    </a>
                    <ul class="dropdown-menu">
                        <li><a href="#">个人信息</a></li>
                    </ul>
                </li>
                <li><a href="#">退出</a></li>
                <li><a href="#"></a></li>
            </ul>
        </div>
    </div>
</nav>

</html>