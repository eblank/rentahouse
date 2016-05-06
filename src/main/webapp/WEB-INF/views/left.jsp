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
    <meta charset="utf-8">
    <title>Dashboard Template for Bootstrap</title>

    <link href="/assets/css/bootstrap.css" rel="stylesheet">

    <link href="/assets/css/dashboard.css" rel="stylesheet">
</head>
<body style="padding-top: 0px;background-color: #222">
<a id="test" href="#">菜单</a>
<ul class="nav nav-pills nav-stacked">
    <li><a href="/crawl/page/crawlhouseInfo" target="mainFrame">导入信息</a></li>
    <li><a href="/view/myCollection" target="mainFrame">我的收藏</a></li>
    <li><a href="/user/view/info" target="mainFrame">个人信息</a></li>
</ul>
<script src="/assets/js/jquery-1.10.2.min.js"></script>
<script type="text/javascript">
    $(function () {
        $('ul.nav.nav-pills.nav-stacked li').each(function () {
            $(this).click(function () {
                $('.nav.nav-pills.nav-stacked li.active').removeClass('active');
                $(this).addClass('active');
                var a = $(this).children('a');
                a.attr({'target': 'mainFrame'});
            });
        });

    });
</script>
</body>
</html>
