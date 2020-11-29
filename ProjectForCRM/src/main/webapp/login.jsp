<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + request.getContextPath() + "/";
%>
<!DOCTYPE html>
<html>
<head>
	<base href="<%=basePath%>">
<meta charset="UTF-8">
<link href="jquery/bootstrap_3.3.0/css/bootstrap.min.css" type="text/css" rel="stylesheet" />
<script type="text/javascript" src="jquery/jquery-1.11.1-min.js"></script>
<script type="text/javascript" src="jquery/bootstrap_3.3.0/js/bootstrap.min.js"></script>
	<script type="text/javascript">
		$(function () {
			//当页面加载完成后，用户名自动获得焦点
			$("#username").focus();

			//给登录按钮绑定单击事件
			$("#loginBtn").click(function () {
				//登录成功
				login()
			})

			//按下回车键进行登录
			$(window).KEYDOWN(function (event) {
				if (event.keyCode==13){
					//登陆成功
					login()
				}
			})

			//当页面加载完成后，用户名必须为空
			$("#username").val("");




		})
		function login() {
			var loginName=$.trim($("#username").val());
			var loginPwd=$.trim($("#password").val());
			if (loginName =="" || loginPwd==""){
				$("#msg").html("用户名或密码不能为空")
				return false;
			}

			$.ajax({
				url:"settings/user/login.do",
				data:{
					"username":loginName,
					"password":loginPwd
				},
				type:"post",
				dataType:"json",
				success:function (data) {
					if (data.success){
						window.location.href="workbench/index.jsp";
					}else{
						$("#msg").html(data.msg);
					}
				}
			})
		}


	</script>



</head>
<body>
	<div style="position: absolute; top: 0px; left: 0px; width: 60%;">
		<img src="image/IMG_7114.JPG" style="width: 100%; height: 90%; position: relative; top: 50px;">
	</div>
	<div id="top" style="height: 50px; background-color: #3C3C3C; width: 100%;">
		<div style="position: absolute; top: 5px; left: 0px; font-size: 30px; font-weight: 400; color: white; font-family: 'times new roman'">CRM &nbsp;<span style="font-size: 12px;">&copy;2017&nbsp;动力节点</span></div>
	</div>
	
	<div style="position: absolute; top: 120px; right: 100px;width:450px;height:400px;border:1px solid #D5D5D5">
		<div style="position: absolute; top: 0px; right: 60px;">
			<div class="page-header">
				<h1>登录</h1>
			</div>
			<form action="workbench/index.jsp" class="form-horizontal" role="form">
				<div class="form-group form-group-lg">
					<div style="width: 350px;">
						<input class="form-control" type="text" placeholder="用户名" id="username">
					</div>
					<div style="width: 350px; position: relative;top: 20px;">
						<input class="form-control" type="password" placeholder="密码" id="password">
					</div>
					<div class="checkbox"  style="position: relative;top: 30px; left: 10px;">
						
							<span id="msg" style="color: red"></span>
						
					</div>
					<button id="loginBtn" type="button" class="btn btn-primary btn-lg btn-block"  style="width: 350px; position: relative;top: 45px;">登录</button>
				</div>
			</form>
		</div>
	</div>
</body>
</html>