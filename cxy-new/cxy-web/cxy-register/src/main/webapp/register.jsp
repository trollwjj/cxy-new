<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2018/4/18 0018
  Time: 下午 5:45
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml" xml:lang="en">
<head>
    <meta http-equiv="Content-Type" content="text/html;charset=UTF-8" />
    <title>用户注册</title>
    <link rel="stylesheet" href="css/base.css" />
    <link rel="stylesheet" href="css/global.css" />
    <link rel="stylesheet" href="css/login-register.css" />

</head>
<body>
<div class="header wrap1000">
    <a href=""><img src="images/logo.png" alt="" /></a>
</div>

<div class="main">
    <div class="login-form fr">
        <div class="form-hd">
            <h3>用户注册</h3>
        </div>
        <div class="form-bd">
            <form action="register/register" onsubmit="return register()" method="POST">
                <dl>
                    <dt>用户名</dt>
                    <dd><input type="text" name="username" class="text" /></dd>
                </dl>
                <dl>
                    <dt>密码</dt>
                    <dd><input type="password" name="password" class="text"/></dd>
                </dl>
                <dl>
                    <dt>确认密码</dt>
                    <dd><input type="password" name="repwd" class="text"/></dd>
                </dl>
                <dl>
                    <dt>邮箱</dt>
                    <dd><input type="text" name="email" class="text"/></dd>
                </dl>
                <dl>
                    <dt>手机</dt>
                    <dd><input type="text" name="phone" class="text" style="width: 150px" id="phone"/>&nbsp;&nbsp;<a id="a-sendSMSCode">获取验证码</a></dd>
                </dl>
                <dl>
                    <dt>短信验证码</dt>
                    <dd><input type="text" name="code" class="text" size="10" style="width:100px;" id="sms-code"></dd>
                </dl>
                <%--
                <dl>
                    <dt>短信验证码</dt>
                    <dd><input type="text" name="code" class="text" size="10" style="width:58px;"> <img src="images/code.png" alt="" align="absmiddle" style="position:relative;top:-2px;"/> <a href="" style="color:#999;">看不清，换一张</a></dd>
                </dl>
                --%>
                <dl>
                    <dt>&nbsp;</dt>
                    <dd><input type="submit" value="立即注册" class="submit"/> <input type= "checkbox" checked="checked"/>阅读并同意<a href="" class="forget">服务协议</a></dd>
                </dl>
            </form>

        </div>
        <div class="form-ft">

        </div>
    </div>

    <div class="login-form-left fl">
        <dl class="func clearfix">
            <dt>注册之后您可以</dt>
            <dd class="ico05"><i></i>购买商品支付订单</dd>
            <dd class="ico01"><i></i>申请开店销售商品</dd>
            <dd class="ico03"><i></i>空间好友推送分享</dd>
            <dd class="ico02"><i></i>收藏商品关注店铺</dd>
            <dd class="ico06"><i></i>商品资讯服务评价</dd>
            <dd class="ico04"><i></i>安全交易诚信无忧</dd>
        </dl>

        <div class="if">
            <h2>如果您是本站用户</h2>
            <p>我已经注册过账号，立即 <a href="" class="register">登录</a> 或是 <a href="" class="findpwd">找回密码？</a></p>
        </div>
    </div>
</div>

<div class="footer clear wrap1000">
    <p> <a href="">首页</a> | <a href="">招聘英才</a> | <a href="">广告合作</a> | <a href="">关于ShopCZ</a> | <a href="">联系我们</a></p>
    <p>Copyright 2004-2013 itcast Inc.,All rights reserved.</p>
</div>


<script type="text/javascript" src="js/jquery.min.js"></script>

<script type="text/javascript">
    $(function () {
        $("#a-sendSMSCode").click(function () {
            var phone = $.trim($("#phone").val());

            if (phone == ""){
                alert("请输入手机");
                return;
            }

            $.ajax({
                url:"/register/sendSMSCode/"+phone,
                type:"post",
                success:function (data) {
                    if (data == "success"){
                        alert("验证码发送成功");
                    }else{
                        alert("请勿频繁获取验证码");
                    }
                }
            });
        })
    })
    
    function register () {
        var smsCode = $("#sms-code").val();
        if ($.trim(smsCode) == ""){
            return false;
        }

        return true;
    }
</script>

</body>
</html>

