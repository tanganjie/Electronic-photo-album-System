<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<html>
	<head>
		<title>添加相册种类</title>
		<Link rel="stylesheet" type="text/css" href="style/style2.css" />
		<style type="text/css">
@import url(style/style.css);
</style>
<script type="text/javascript">
	function check2() {
		var name=document.getElementById("kind.kindName").value;
		var desc=document.getElementById("kind.kindDesc").value;
		if (name == "") {
			alert("种类名称不能为空");
			return;
		}
		if (desc == "") {
			alert("种类说明不能为空");
			return;
		}
		
		document.getElementById("addForm").action="Album_addKind.action";
		document.getElementById("addForm").submit();
	}
</script>
	</head>
	<body>
		<DIV>
			<IMG src="Logoimage/logo.gif">
		</DIV>
			<jsp:include page="head2.jsp"></jsp:include>
		<DIV>
			<FORM id="addForm" action="" method="POST">
				<DIV class="t">
					<TABLE cellSpacing="0" cellPadding="0" align="center" width="100%">
						<TR>
							<TD class="h" colSpan="3">
								<B>添加相册种类</B>
							</TD>
						</TR>
						<TR class="tr3">
							<TD width="20%">
								<B>种类名称</B>
							</TD>
							<TD>
								<INPUT class="input" style="PADDING-LEFT: 2px; FONT: 14px Tahoma" tabIndex="1" size="60" id="kind.kindName" name="kind.kindName">
							</TD>
						</TR>
						<TR class="tr3">
							<TD width="20%">
								<B>种类说明</B>
							</TD>
							<TD>
								<INPUT class="input" style="PADDING-LEFT: 2px; FONT: 14px Tahoma" tabIndex="1" size="60" id="kind.kindDesc" name="kind.kindDesc">
							</TD>
						</TR>
					</TABLE>
				</DIV>

				<DIV style="MARGIN: 15px 0px; TEXT-ALIGN: center">
					<INPUT class="btn" tabIndex="3" type="button" value="提 交" onClick="check2()">
					<INPUT class="btn" tabIndex="4" type="reset" value="重 置">
				</DIV>
			</FORM>
		</DIV>
		<div>
			<jsp:include page="bottom.jsp"></jsp:include>
		</div>
	</body>
<html>