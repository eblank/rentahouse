<%--
  Created by IntelliJ IDEA.
  User: LXPENG
  Date: 2016/5/7
  Time: 2:50
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
    <title></title>

    <link rel="stylesheet" type="text/css" href="/assets/css/bootstrap.css">
    <script src="/assets/js/jquery-1.10.2.min.js"></script>
    <script src="/assets/js/bootstrap.js"></script>
    <style>
        div#main {
            -moz-border-radius: 8px;
            -webkit-border-radius: 8px;
            border-radius: 8px;
            width: 80%;
            margin: 20px auto;
            height: 410px;
            padding-left: 30px;
            position: relative;
        }

        table#user {
            width: 60%;
            margin: 0px auto;
        }

        button#save {
            position: absolute;
            left: 22%;
            top: 82%;
        }

        table {
            font-size: 12px;
        }
    </style>
</head>
<body>
<div id="main">
    <fieldset>
        <legend>个人信息</legend>
        <table id="user" class="table table-bordered table-striped">
            <tbody>
            <input id="id" type="hidden" value="${user.id}"/>
            <tr class="info">
                <td width="40%">用户账号</td>
                <td id="account">${user.email}</td>


            </tr>
            <tr class="info">
                <td>昵称</td>
                <td>
                    <input id="nickname" type="text" value="${user.nickName}"/>
                </td>
            </tr>
            <tr class="info">
                <td>真实姓名</td>
                <td><input id="realname" type="text" value="${user.realName}"/></td>
            </tr>
            <tr class="info">
                <td>性别</td>
                <td>
                    <input id="sex" type="text" value="${user.sex}"/>
                </td>
            </tr>
            <tr class="info">
                <td>市</td>
                <td>
                    <input id="province" type="text" value="${user.province}"/>
                </td>
            </tr>
            <tr class="info">
                <td>市</td>
                <td>
                    <input id="city" type="text" value="${user.city}"/>
                </td>
            </tr>
            <tr class="info">
                <td>区</td>
                <td>
                    <input id="county" type="text" value="${user.county}"/>
                </td>
            </tr>
            <tr class="info">
                <td>镇</td>
                <td>
                    <input id="town" type="text" value="${user.town}"/>
                </td>
            </tr>
            <tr class="info">
                <td>电话</td>
                <td>
                    <input id="mobile" type="text" value="${user.mobile}"/>
                </td>
            </tr>
            </tbody>
        </table>

    </fieldset>
    <div>
        <button id="save" class="btn btn-primary">保存我的资料</button>
        <script>
            $(document).ready(function () {
                $("button#save").click(function () {
                    var param = {};
                    param.id = $('#id').val();
                    param.nickName = $('#nickname').val();
                    param.realName = $('#realname').val();
                    param.sex = $('#sex').val();
                    param.province = $('#province').val();
                    param.city = $('#city').val();
                    param.county = $('#county').val();
                    param.town = $('#town').val();
                    param.mobile = $('#mobile').val();
                    var url = "<%=basePath%>user/saveInfo";
                    $.ajax({
                        type: "POST",
                        url: url,
                        data: param,
                        success: function (result) {
                            var successful = result.successful;
                            var msg = result.msg;
                            alert(msg);

                        },
                        error: function () {
                            alert("网络异常");
                        }
                    });
                });
            });
        </script>
    </div>
</div>
</body>
</html>