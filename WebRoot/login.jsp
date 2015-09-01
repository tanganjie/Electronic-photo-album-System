<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<%
request.setCharacterEncoding("UTF-8");
 %>
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
	<title>用户登录</title>
	<link href="style/login.css" type="text/css" rel="stylesheet" />
	<script type="text/javascript" charset="UTF-8">
	function check() {
		if (document.getElementById("user.userName").value == "") {
			alert("用户名不能为空");
			return;
		}
		if (document.getElementById("user.passWord").value == "") {
			alert("密码不能为空");
			return;
		}
		document.getElementById("loginForm").action="User_login.action";
		document.getElementById("loginForm").submit();
	}
	
	function cover(){
		var name=document.getElementById("user.userName").value;
		if (document.getElementById("user.userName").value == "") {
			alert("用户名不能为空");
			return;
		}
		document.getElementById("loginForm").action="User_forCover.action";
		document.getElementById("loginForm").submit();
	}
</script>
</head>
<body>
	<div id="header">
		<div class="h_lt">
			<img src="images/logo.gif" />
		</div>
		<center>
		</div>
		<div id="lad_center">
			<div class="lad_rt">
				<div class="top"><img border="0"
							src="images/user_dlx.gif" alt="下一个会是谁？" />
				</div>
				<div class="top2"><img border="0" src="images/user_dl.gif" />
				</div>
				<form action="" method="post" name="loginForm" id="loginForm" >
					<p style="margin-top: 20px;">
						<s:property value="%{getText('username')}" />
						<input class="sr" type="text" name="user.userName" id="user.userName" maxlength="15" />
					</p>
					<p>
						<s:property value="%{getText('password')}" />
						<input class="sr" type="password" name="user.passWord" id="user.passWord" maxlength="25" />
					</p>
					<p style="margin: 0px 0px 10px 50px; color: red"></p>
					<p style="text-indent: 40px;">
						<input type="hidden" name="loginsubmit" value="true" />
						<input type="button" class="Login1" name="mysubmit" value="" onclick="check()"/>
						<a href="javascript:cover()"><s:property value="%{getText('forget')}" /></a>
					</p>
					<div class="clear"></div>
				</form>
				<div class="bottom">
				<div class="tt">
					欢迎光临电子相册系统!
					<a href="User_forRegist.action"><img style="margin-left: 5px;" src="images/land_t.gif" border="0" />
					</a>
				</div>
				<div class="cont">
					<div class="pep"></div>
				</div>
				</div>
			</div>
			<div class="clear"></div>
		</div>
		</center>
		<div>
		<jsp:include page="bottom.jsp"></jsp:include>
		</div>
</body>
</html>

