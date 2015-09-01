<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<HTML>
	<HEAD>
		<base href="<%=basePath%>">
		<TITLE>新建相册</TITLE>
		<Link rel="stylesheet" type="text/css" href="style/style2.css" />
		<style type="text/css">
@import url(style/style.css);
</style>
	<script type="text/javascript">
	function check2() {
		var name=document.getElementById("album.albumName").value;
		var desc=document.getElementById("album.albumDesc").value;
		if (name == "") {
			alert("相册名称不能为空");
			return;
		}
		document.getElementById("addAlbum").action="Album_addAlbum.action";
		document.getElementById("addAlbum").submit();
	}
</script>
	</HEAD>
	<BODY>
		<DIV>
			<IMG src="Logoimage/logo.gif">
		</DIV>
			<jsp:include page="head.jsp"></jsp:include>
		<DIV>
			<FORM id="addAlbum" action="" method="POST">
				<DIV class="t">
					<TABLE cellSpacing="0" cellPadding="0" align="center">
						<TR>
							<TD class="h" colSpan="3">
								<B>添加相册</B>
							</TD>
						</TR>
					</TABLE>
					<table width="80%" border="1" bordercolor="#e0f0f9">
						<tr>
							<td width="92">
								相册名称
							</td>
							<td width="277">
								<INPUT class="input" size="60" name="album.albumName" id="album.albumName">
							</td>
						</tr>
						<tr>
							<td>
								<s:select name="album.kindId" label="相册种类" list="allKind" listKey="kindId" listValue="kindName"></s:select>
							</td>
						</tr>
						<tr>
							<td>
								<s:textarea id="album.albumDesc" name="album.albumDesc" label="相册说明" rows="10" cols="50"></s:textarea>
							</td>
						</tr>
					</table>
				</DIV>
				<DIV style="MARGIN: 15px 0px; TEXT-ALIGN: center">
					<input class="btn" tabIndex="3" type="button" value="提 交" onclick="check2()">
					<input class="btn" tabIndex="4" type="reset" value="重 置">
				</DIV>
			</FORM>
		</DIV>
		<div>
			<jsp:include page="bottom.jsp"></jsp:include>
		</div>
	</BODY>
</HTML>