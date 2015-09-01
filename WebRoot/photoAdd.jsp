<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<html>
	<head>
		<title>上传相片</title>
		<Link rel="stylesheet" type="text/css" href="style/style2.css" />
		<style type="text/css">
@import url(style/style.css);
</style>
		<script type="text/javascript">
	function check2() {
		var title=document.getElementById("photo.title").value;
		var file=document.getElementById("file").value;
		if (title == "") {
			alert("相片名称不能为空");
			return;
		}
		if(file==""){
			alert("不能没有相片");
			return;
		}
		document.getElementById("addPhoto").action="Photo_addPhoto.action";
		document.getElementById("addPhoto").submit();
	}
</script>
	</head>
	<body>
		<DIV>
			<IMG src="Logoimage/logo.gif">
		</DIV>
			<jsp:include page="head.jsp"></jsp:include>
		<div>
			<form id="addPhoto"  method="POST" enctype="multipart/form-data">
				<DIV class="t">
					<TABLE cellSpacing="0" cellPadding="0" align="center">
						<TR>
							<TD class="h" colSpan="3">
								<B>添加相片</B>
							</TD>
						</TR>
					</TABLE>
					<table width="934" border="1" bordercolor="#e0f0f9">
						<tr>
							<td width="200">
								相片名称
							</td>
							<td width="734">
								<INPUT class="input" size="60" name="photo.title">
							</td>
						</tr>
						<tr>
							<td>
								<s:file id="file" name="file" label="选择相片"></s:file>
							</td>
						</tr>
						<tr>
							<td>
								<s:select label="选择相册" name="photo.albumId" list="allAlbum" listKey="albumId" listValue="albumName"></s:select>
							</td>
						</tr>
						<tr>
							<s:textarea label="相片说明" name="photo.photoDesc" rows="10" cols="50"></s:textarea>
						</tr>
					</table>
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
