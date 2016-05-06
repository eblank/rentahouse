<%--
  Created by IntelliJ IDEA.
  User: LXPENG
  Date: 2016/5/6
  Time: 21:01
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
%>
<html>
<head>
    <meta charset="UTF-8">
    <title></title>
    <link href="/assets/css/bootstrap.css" rel="stylesheet">
    <link rel="stylesheet" href="/assets/css/bootstrap-table.css"/>
    <style type="text/css">
        .com-table-main {
            border: 1px solid #cc1522;
        }

        .comments-item {

        }

        .com-item-main {
            border: 1px solid #ccc;
            margin: 4px 4px 4px 4px;
            padding: 4px;
        }

        .com-content {
            margin: auto 0px;
            font-size: 14px;
            line-height: 1.8;
        }

        .com-opinion {
            margin: auto 0px;
            font-size: 16px;
            line-height: 1.8;
        }

        .com-footer {
            border-top: 1px solid #ccc;
            margin: auto 0px;
            font-size: 12px;
            line-height: 1.8;
        }
    </style>
</head>
<body>
<div class="com-table-main">
    <div class="page-header row">
        <div class="col-md-12" style="text-align: center">
            评论列表
        </div>
    </div>

    <!--评论框列表-->
    <div class="comments-item">
        <c:forEach items="${commentList.data}" var="comment" varStatus="status">
            //评论框
            <div class="com-item-main">
                <div class="row" style="color: #235; font-size: 20px; line-height: 1.8; margin: auto 0px;">
                    #${status.count}
                </div>
                <div class="row com-content">
                        ${comment.content}
                </div>
                <div class="row com-opinion">
                    <div class="col-md-1 col-md-offset-10">
                        支持
                    </div>
                    <div class="col-md-1">
                        反对
                    </div>
                </div>
                <div class="row com-footer">
                    <div class="col-md-2" style="font-family: Verdana,Arial,Helvetica,sans-serif; color: #aaa;">
                            ${comment.createTime}
                    </div>
                    <div class="col-md-2 col-md-offset-1"
                         style="border-left: 2px solid #555555; color: #235; font-family: Verdana,Arial,Helvetica,sans-serif;">
                            ${comment.from.fromNickname}
                    </div>
                    <label hidden="hidden">
                            ${comment.from.id}
                    </label>
                </div>
                <div class="clear"></div>
            </div>
        </c:forEach>
    </div>

    <div class="panel-footer">
        这是尾部
    </div>
</div>

<script src="/assets/js/jquery-1.10.2.min.js"></script>
<script src="/assets/js/bootstrap.js"></script>
<script type="text/javascript">

</script>
</body>
</html>
