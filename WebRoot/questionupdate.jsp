<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<head>
	<title>修改相册种类</title>
	<Link rel="stylesheet" type="text/css" href="style/style2.css" />
	<style type="text/css">
@import url(style/style.css);
</style>
<script type="text/javascript">
	function check2() {
		var desc=document.getElementById("question.remark").value;
		if (desc == "") {
			alert("用户注册问题不能为空");
			return;
		}
		
		document.getElementById("updateForm").action="User_updateQuestion.action";
		document.getElementById("updateForm").submit();
	}
</script>
</head>
<html>
	<body>
		<DIV>
			<IMG src="Logoimage/logo.gif">
		</DIV>
			<jsp:include page="head2.jsp"></jsp:include>
		<DIV>
			<FORM id="updateForm" action="" method="POST">
				<s:hidden name="question.qusId" value="%{question.qusId}"></s:hidden>
				<DIV class="t">
					<TABLE cellSpacing="0" cellPadding="0" align="center">
						<TR>
							<TD class="h" colSpan="3">
								<B>修改用户注册问题种类</B>
							</TD>
						</TR>
						<TR class="tr3">
							<TD width="20%">
								<B>用户注册问题</B>
							</TD>
							<TD>
								<INPUT class="input" style="PADDING-LEFT: 2px; FONT: 14px Tahoma" tabIndex="1" size="60" id="question.remark" name="question.remark" value=<s:property value="question.remark"/>>
							</TD>
						</TR>
					</TABLE>
				</DIV>
				<DIV style="MARGIN: 15px 0px; TEXT-ALIGN: center">
					<INPUT class="btn" tabIndex="3" type="button" value="提 交" onclick="check2()">
					<INPUT class="btn" tabIndex="4" type="reset" value="重 置">
				</DIV>
			</FORM>
		</DIV>
		<div>
			<jsp:include page="bottom.jsp"></jsp:include>
		</div>
	</body>
</html>
