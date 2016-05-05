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
</head>
<frameset rows="51,*" cols="*">
  <frame src="top.jsp" name="topFrame" frameborder="0" scrolling="No" noresize="noresize" id="topFrame" style="height: 80px"/>
  <frameset cols="200,*">
    <frame src="left.jsp" name="leftFrame" frameborder="0" scrolling="yes" noresize="noresize" id="leftFrame"/>
    <frame src="" name="mainFrame" frameborder="0" id="mainFrame"/>
    </frameset>
  </frameset>
</html>
