<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
	<title>用户注册_窗内网</title>
	<link href="style/ans.css" type="text/css" rel="stylesheet" />
	<script language="javascript">
	function check() {
		var username=document.getElementById("user.userName").value;
		var password=document.getElementById("user.passWord").value;
		var ipassword=document.getElementById("iuser.passWord").value;
		if (username == "") {
			alert("用户名不能为空");
			return;
		}
		if (password == "") {
			alert("密码不能为空");
			return;
		}
		if (password != ipassword) {
			alert("2次密码不一样");
			return;
		}
		document.getElementById("regForm").action="User_changePassword.action";
		document.getElementById("regForm").submit();
	}
</script>

</head>
<body>
	<div id="header">
		<div class="h_lt"><img src="images/logo.gif" />
		</div>
	</div>
	<div align="center">
		<div class="c_lt">
			<div class="tt">
			</div>
			<form action="" method="post" name="regForm" id="regForm">
				<div class="content">
					<p>
						<label for="email">
							<s:property value="%{getText('username')}" />：
						</label>
						<INPUT class="input" type="text" id="user.userName" maxLength=16 name="user.userName" readonly value=<s:property value="user.userName"/>>
					</p>
					<p>
						<label for="email">
							<s:property value="%{getText('password')}" />：
							</label>
							<INPUT class="input"  type=password maxLength=16 id="user.passWord" name="user.passWord" >
					</p>
					<br>
					<p>
						<label for="email">
							<s:property value="%{getText('ipassword')}" />：
						</label>
						<INPUT class="input"  type=password maxLength=16 id="iuser.passWord" name="iuser.passWord">
					</p>
					<p>
						<INPUT type="button"  value="" class="tj" onClick="check()">
					</p>
				</div>
			</form>
			<div class="ft"></div>
		</div>
		</div>
	<div>
<jsp:include page="bottom.jsp"></jsp:include>
	</div>
</body>
</html>