<%--
  Created by IntelliJ IDEA.
  User: LXPENG
  Date: 2016/4/25
  Time: 21:50
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8"/>
    <title>登录界面</title>
    <meta name="keywords" content="Bootstrap,登录界面,管理系统"/>
    <meta name="description" content="登录界面"/>
    <meta name="viewport" content="width=device-width, initial-scale=1.0"/>


    <!-- basic styles -->

    <link rel="stylesheet" href="/assets/css/bootstrap.css"/>
    <link rel="stylesheet" href="/assets/css/font-awesome.min.css" />

    <!-- fonts -->

    <link rel="stylesheet" href="/assets/font/useso.css" />

    <!-- ace styles -->

    <link rel="stylesheet" href="/assets/css/ace.min.css" />
    <link rel="stylesheet" href="/assets/css/ace-rtl.min.css" />
</head>

<body class="login-layout">
<div class="main-container">
    <div class="main-content">
        <div class="row">
            <div class="col-sm-10 col-sm-offset-1">
                <div class="login-container">
                    <div class="center">
                        <h1>
                            <!--<i class="icon-leaf green"></i>-->
                            <!--<span class="red">Ace</span>-->
                            <span class="white">个人租房信息管理</span>
                        </h1>
                        <h4 class="blue">&copy; </h4>
                    </div>

                    <div class="space-6"></div>

                    <div class="position-relative">
                        <div id="resetPassword-box" class="widget-box visible no-border">
                            <div class="widget-body">
                                <div class="widget-main">
                                    <h4 class="header blue lighter bigger">
                                        <i class="icon-keyboard green"></i>
                                        重置密码
                                    </h4>

                                    <div class="space-6"></div>

                                    <form id="resetPassword">
                                        <fieldset>
                                            <label class="block clearfix">
														<span class="block input-icon input-icon-right">
															<input id="password" name="password" type="text"
                                                                   class="form-control"/>
														</span>
                                            </label>

                                            <label class="block clearfix">
														<span class="block input-icon input-icon-right">
															<input id="password_again" name="password_again"
                                                                   type="password" class="form-control"/>
														</span>
                                            </label>

                                            <div class="space"></div>

                                            <div class="clearfix">

                                                <button type="submit" class="width-35 btn btn-sm btn-primary">
                                                    登录
                                                </button>
                                            </div>

                                            <div class="space-4"></div>
                                        </fieldset>
                                    </form>
                                </div>
                            </div>
                        </div>
                    </div>
                    <!-- /position-relative -->
                </div>
            </div>
            <!-- /.col -->
        </div>
        <!-- /.row -->
    </div>
</div>
<!-- /.main-container -->

<!-- basic scripts -->

<script src="/assets/js/jquery-2.0.3.min.js"></script>
<%--<script src="/assets/js/jquery.mobile.custom.min.js"></script>--%>

<!--[start 验证表单插件]-->
<script src="/assets/js/jquery.validate.min.js"></script>
<script src="/assets/js/localization/messages_zh.min.js"></script>
<!--[end 验证表单插件]-->

<script type="text/javascript">
    $().ready(function () {
        alert(" \n  111");
        $("#resetPassword").validate({
            submitHandler: function () {
                alert("提交事件!");
                var data = $('#resetPassword').serializeArray(),
                        url = "<%=basePath%>password/change",
                param = window.location.search.substr(1);
                var keyName = param.split('=')[0];
                var keyValue = param.split('=')[1];
                var keyObject = {name : keyName, value : keyValue};
                data.push(keyObject);

                $.ajax({
                    type: "POST",
                    url: url,
                    data: data,
                    success: function (data) {
                        var successful = data.successful,
                        msg = data.msg;

                        if (successful) {
                            alert(msg + "\n请登录");
                            setTimeout("window.location.href='" + "<%=basePath%>home/page/login'", 2000)
                        } else {
                            alert(msg);
                        }
                    },
                    error: function () {
                        alert("网络异常");
                    }
                });
            },
            debug: false,
            rules: {
                password: {
                    required: true,
                    minlength: 5
                },
                password_again: {
                    required: true,
                    minlength: 5,
                    equalTo: "#password"
                }
            }
        });

    });
</script>
</body>
</html>

