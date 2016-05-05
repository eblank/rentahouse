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

    <link href="assets/css/bootstrap.css" rel="stylesheet">

    <link href="assets/css/dashboard.css" rel="stylesheet">
</head>
<body style="padding-top: 0px">
<a id="test" href="#">aaaaaaaaaa</a>
    <ul class="nav nav-pills nav-stacked">
        <li class="active"><a href="#">Overview <span class="sr-only">(current)</span></a></li>
        <li><a href="http://www.baidu.com" target="mainFrame">Reports</a></li>
        <li><a href="/home/page/login" target="mainFrame">Analytics</a></li>
        <li><a href="/crawl/house/info">Export</a></li>
    </ul>
    <ul class="nav nav-pills nav-stacked">
        <li><a href="#">Nav item</a></li>
        <li><a href="#">Nav item again</a></li>
        <li><a href="#">One more nav</a></li>
        <li><a href="#">Another nav item</a></li>
        <li><a href="#">More navigation</a></li>
    </ul>
    <ul class="nav nav-pills nav-stacked">
        <li><a href="#">Nav item again</a></li>
        <li><a href="#">One more nav</a></li>
        <li><a href="#">Another nav item</a></li>
    </ul>
    <ul class="nav nav-pills nav-stacked">
        <li><a href="#">Nav item</a></li>
        <li><a href="#">Nav item again</a></li>
        <li><a href="#">One more nav</a></li>
        <li><a href="#">Another nav item</a></li>
        <li><a href="#">More navigation</a></li>
    </ul>
    <ul class="nav nav-pills nav-stacked">
        <li><a href="#">Nav item again</a></li>
        <li><a href="#">One more nav</a></li>
        <li><a href="#">Another nav item</a></li>
    </ul>
    <ul class="nav nav-pills nav-stacked">
        <li><a href="#">Nav item</a></li>
        <li><a href="#">Nav item again</a></li>
        <li><a href="#">One more nav</a></li>
        <li><a href="#">Another nav item</a></li>
        <li><a href="#">More navigation</a></li>
    </ul>
    <ul class="nav nav-pills nav-stacked">
        <li><a href="#">Nav item again</a></li>
        <li><a href="#">One more nav</a></li>
        <li><a href="#">Another nav item</a></li>
    </ul>
<script src="assets/js/jquery-1.10.2.min.js"></script>
<script type="text/javascript">
    $(function () {
        $('ul.nav.nav-pills.nav-stacked li').each(function() {
            $(this).click(function(){
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
