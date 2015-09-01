<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
	<title>用户注册_窗内网</title>
	<link href="style/ans.css" type="text/css" rel="stylesheet" />
	<script language="javascript">
	function check() {
		var answer=document.getElementById("user.answer").value;
		if(answer==""){
			alert("答案不能为空");
			return;
		}
		document.getElementById("regForm").action="User_forChangePassword.action";
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
							<s:property value="%{getText('question')}" />：
							</label>
							<INPUT class="input"  type=text maxLength=16 id="user.question" name="user.question" readonly value=<s:property value="user.dquestion.remark"/>>
					</p>
					<br>
					<p>
						<label for="email">
							<s:property value="%{getText('answer')}" />：
						</label>
						<INPUT class="input"  type=text maxLength=16 id="user.answer" name="user.answer">
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