<%--
Created by IntelliJ IDEA.
User: LXPENG
Date: 2016/4/22
Time: 15:27
To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
    out.print(basePath);
%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8" />
    <title>登录界面</title>
    <meta name="keywords" content="Bootstrap,登录界面,管理系统" />
    <meta name="description" content="登录界面" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />

    <!-- basic styles -->

    <link rel="stylesheet" href="/assets/css/bootstrap.min.css"/>
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
                        <div id="login-box" class="login-box visible widget-box no-border">
                            <div class="widget-body">
                                <div class="widget-main">
                                    <h4 class="header blue lighter bigger">
                                        <i class="icon-coffee green"></i>
                                        请输入你的账号密码
                                    </h4>

                                    <div class="space-6"></div>

                                    <form id="login" method="post">
                                        <fieldset>
                                            <label class="block clearfix">
														<span class="block input-icon input-icon-right">
															<input id="account" name="account" type="text" class="form-control" placeholder="账号" />
															<i class="icon-user"></i>
														</span>
                                            </label>

                                            <label class="block clearfix">
														<span class="block input-icon input-icon-right">
															<input id="password" name="password" type="password" class="form-control" placeholder="密码" />
															<i class="icon-lock"></i>
														</span>
                                            </label>

                                            <label id="msg"></label>

                                            <div class="space"></div>

                                            <div class="clearfix">
                                                <label class="inline">
                                                    <input id="remember" name="remember" type="checkbox" class="ace" />
                                                    <span class="lbl"> 记住</span>
                                                </label>

                                                <button type="submit" class="width-35 pull-right btn btn-sm btn-primary">
                                                    <i class="icon-key"></i>
                                                    登录
                                                </button>
                                            </div>

                                            <div class="space-4"></div>
                                        </fieldset>
                                    </form>

                                    <div class="social-or-login center">
                                        <span class="bigger-110">Or Login Using</span>
                                    </div>

                                    <div class="social-login center">
                                        <a class="btn btn-primary">
                                            <i class="icon-facebook"></i>
                                        </a>

                                        <a class="btn btn-info">
                                            <i class="icon-twitter"></i>
                                        </a>

                                        <a class="btn btn-danger">
                                            <i class="icon-google-plus"></i>
                                        </a>
                                    </div>
                                </div><!-- /widget-main -->

                                <div class="toolbar clearfix">
                                    <div>
                                        <a href="#" onclick="show_box('forgot-box'); return false;" class="forgot-password-link">
                                            <i class="icon-arrow-left"></i>
                                            忘记密码
                                        </a>
                                    </div>

                                    <div>
                                        <a href="#" onclick="show_box('signup-box'); return false;" class="user-signup-link">
                                            我要注册
                                            <i class="icon-arrow-right"></i>
                                        </a>
                                    </div>
                                </div>
                            </div><!-- /widget-body -->
                        </div><!-- /login-box -->

                        <div id="forgot-box" class="forgot-box widget-box no-border">
                            <div class="widget-body">
                                <div class="widget-main">
                                    <h4 class="header red lighter bigger">
                                        <i class="icon-key"></i>
                                        找回密码
                                    </h4>

                                    <div class="space-6"></div>
                                    <p>
                                        输入邮箱找回密码
                                    </p>

                                    <form id="forgot" method="post">
                                        <fieldset>
                                            <label class="block clearfix">
														<span class="block input-icon input-icon-right">
															<input type="forgot_email" name="forgot_email" class="form-control" placeholder="邮箱" />
															<i class="icon-envelope"></i>
														</span>
                                            </label>

                                            <label id="msg"></label>

                                            <div class="clearfix">
                                                <button type="submit" class="width-35 pull-right btn btn-sm btn-danger">
                                                    <i class="icon-lightbulb"></i>
                                                    发送！
                                                </button>
                                            </div>
                                        </fieldset>
                                    </form>
                                </div><!-- /widget-main -->

                                <div class="toolbar center">
                                    <a href="#" onclick="show_box('login-box'); return false;" class="back-to-login-link">
                                        返回注册界面
                                        <i class="icon-arrow-right"></i>
                                    </a>
                                </div>
                            </div><!-- /widget-body -->
                        </div><!-- /forgot-box -->

                        <div id="signup-box" class="signup-box widget-box no-border">
                            <div class="widget-body">
                                <div class="widget-main">
                                    <h4 class="header green lighter bigger">
                                        <i class="icon-group blue"></i>
                                        新用户注册
                                    </h4>

                                    <div class="space-6"></div>
                                    <p> 请输入您的信息: </p>

                                    <form id="register">
                                        <fieldset>
                                            <label class="block clearfix">
														<span class="block input-icon input-icon-right">
															<input id="email" name="email" type="email" class="form-control" placeholder="邮箱" />
															<i class="icon-envelope"></i>
														</span>
                                            </label>

                                            <label class="block clearfix">
														<span class="block input-icon input-icon-right">
															<input id="nickname" name="nickname" type="text" class="form-control" placeholder="用户" />
															<i class="icon-user"></i>
														</span>
                                            </label>

                                            <label class="block clearfix">
														<span class="block input-icon input-icon-right">
															<input id="register_password" name="register_password" type="password" class="form-control" placeholder="密码" />
															<i class="icon-lock"></i>
														</span>
                                            </label>

                                            <label class="block clearfix">
														<span class="block input-icon input-icon-right">
															<input id="passwoed_again" name="passwoed_again" type="password" class="form-control" placeholder="再次输入密码" />
															<i class="icon-retweet"></i>
														</span>
                                            </label>

                                            <label id="msg"></label>

                                            <div class="clearfix">
                                                <button type="button" class="width-30 pull-left btn btn-sm">
                                                    <i class="icon-refresh"></i>
                                                    重置
                                                </button>

                                                <button type="submit" class="width-65 pull-right btn btn-sm btn-success">
                                                    注册
                                                    <i class="icon-arrow-right icon-on-right"></i>
                                                </button>
                                            </div>
                                        </fieldset>
                                    </form>
                                </div>

                                <div class="toolbar center">
                                    <a href="#" onclick="show_box('login-box'); return false;" class="back-to-login-link">
                                        <i class="icon-arrow-left"></i>
                                        返回注册界面
                                    </a>
                                </div>
                            </div><!-- /widget-body -->
                        </div><!-- /signup-box -->
                    </div><!-- /position-relative -->
                </div>
            </div><!-- /.col -->
        </div><!-- /.row -->
    </div>
</div><!-- /.main-container -->

<!-- basic scripts -->

<script src="/assets/js/jquery-2.0.3.min.js"></script>
<%--<script src="/assets/js/jquery.mobile.custom.min.js"></script>--%>

<!--[start 验证表单插件]-->
<script src="/assets/js/jquery.validate.min.js"></script>
<script src="/assets/js/localization/messages_zh.min.js"></script>
<!--[end 验证表单插件]-->

<script type="text/javascript">
    function show_box(id) {
        jQuery('.widget-box.visible').removeClass('visible');
        jQuery('#'+id).addClass('visible');
    };

//    $.validator.setDefaults({
//        submitHandler: function() {
//            alert("提交事件!");
//        }
//    });

    $().ready(function() {

        //登录
        $("#login").validate({
            submitHandler:function(){
                $('#login-box #msg').html('');
                alert("提交事件!");
                var data = $('#login').serializeArray();
                var url = "home/login";
                $.ajax({
                    type : "POST",
                    url : url,
                    data : data,
                    success : function(data) {
                        var successful = data.successful;
                        var msg = data.msg;
                        if (successful) {
                            alert("登录成功");
                            setTimeout("window.location.href='" + "<%=basePath %>" + "home/test" + "'", 2000);
//                            $('#signup-box').removeClass('visible');
//                            $('#login-box').addClass('visible');
                        } else {
                            alert("登录失败");
                            $('#login-box #msg').html(msg);
                            $('#login-box #password').val('');

                        }
                    },
                    error : function() {
                        alert("网络异常");
                    }
                });
            },
            debug: false,
            rules: {
                account: {
                    required: true,
                    email: true
                },
                password: {
                    required: true,
                    minlength: 5
                }
            }
        });

        //注册
        $("#register").validate({
            submitHandler:function(){
                alert("提交事件!");
                var data = $('#register').serializeArray();
                var url = "home/register";
                $.ajax({
                    type : "POST",
                    url : url,
                    data : data,
                    success : function(data) {
                        var successful = data.successful;
                        var msg = data.msg;
                        if (successful) {
                            alert("注册成功");
//                            $('#signup-box').removeClass('visible');
//                            $('#login-box').addClass('visible');
                        } else {
                            alert("用户已存在");
                            $('#signup-box #msg').html(msg);

                        }
                    },
                    error : function() {
                        alert("网络异常");
                    }
                });
            },
            debug: false,
            rules: {
                email: {
                    required: true,
                    email: true
                },
                nickname: {
                    required: true,
                    minlength: 2
                },
                register_password: {
                    required: true,
                    minlength: 5
                },
                passwoed_again: {
                    required: true,
                    minlength: 5,
                    equalTo: "#register_password"
                }
            }
        });

        //忘记密码
      $("#forgot").validate({
            submitHandler:function(){
                alert("提交事件!");
                var data = $('#forgot').serializeArray();
                var url = "home/forgot";
                $.ajax({
                    type : "POST",
                    url : url,
                    data : data,
                    success : function(data) {
                        var successful = data.successful;
                        var msg = data.msg;
                        if (successful) {
                            alert("提交成功");
//                            $('#signup-box').removeClass('visible');
//                            $('#login-box').addClass('visible');
                        } else {
                            alert("失败");
                            $('#forgot-box #msg').html(msg);

                        }
                    },
                    error : function() {
                        alert("网络异常");
                    }
                });
            },
            debug: false,
            rules: {
                forgot_email: {
                    required: true,
                    email: true
                }
            }
        });
    });
</script>
</body>
</html>
