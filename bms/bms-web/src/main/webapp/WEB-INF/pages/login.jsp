<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<!--[if IE 8]> <html lang="en" class="ie8"> <![endif]-->
<!--[if !IE]><!-->
<html lang="zh">
<!--<![endif]-->
<head>
	<meta charset="utf-8" />
	<title>登录页面</title>
	<jsp:include page="common/header.jsp"/>
    <%@include file="common/taglib.jsp"%>
</head>
<body>

                    医方科技
                   BMS管理系统
            <!-- end brand -->
                <form:form action="dologin" method="POST" class="margin-bottom-0" data-parsley-validate="true">
                        <input type="text" class="form-control input-lg" placeholder="用户名" name="username" data-parsley-required="true"
                        data-parsley-required-message="用户名不能为空" value="${user.username}"/><br/>
                        <input type="password" class="form-control input-lg" placeholder="密码" name="password"
                        data-parsley-required-message="密码不能为空" data-parsley-required="true" value="${user.password}"/><br/>

               <input type="text" style="width: 220px;"  class="form-control input-lg" placeholder="验证码" name="captcha" data-parsley-required="true" data-parsley-required-message="验证码不能为空"/><br/>
               <img style="position: relative;top:-48px;left: 233px;"  src="./Kaptcha.jpg" class="form-group" alt="点击更换" id="kaptchaImage"/>
           <span style="position: relative;top: -36px;left: 131px;color: #E5603B;">${loginMessage.msg}</span><br/>
                    <%--<div class="checkbox m-b-20">--%>
                        <%--<label>--%>
                            <%--<input type="checkbox" /> 记住我--%>
                        <%--</label>--%>
                    <%--</div>--%>
                        <button type="submit"  style="position: relative;top:-30px" class="btn btn-success btn-block btn-lg">点击登录</button>
                </form:form>
        <!-- end login -->
	<!-- end page container -->
	


	<script>
		$(document).ready(function() {
			App.init();
            $('#kaptchaImage').click(function() {$(this).attr('src','Kaptcha.jpg?' + Math.floor(Math.random() * 100));});
		});		
    </script>
</body>
</html>
