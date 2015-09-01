<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<HTML>
	<HEAD>
		<base href="<%=basePath%>">
		<TITLE>修改相册</TITLE>
		<Link rel="stylesheet" type="text/css" href="style/style2.css" />
		<style type="text/css">
@import url(style/style.css);
</style>
<script type="text/javascript">
function check(){
	var name=document.getElementById("album.albumName").value;

	if(name==""){
		alert("相册名不能为空");
		return;
	}
	document.getElementById("updateForm").action="Album_updateAlbum.action";
	document.getElementById("updateForm").submit();
	}
</script>
	</HEAD>
	<BODY>
		<DIV>
			<IMG src="Logoimage/logo.gif">
		</DIV>
			<jsp:include page="head.jsp"></jsp:include>
		<form id="updateForm" action="" method="post">
			<s:hidden name="album.albumId" value="%{album.albumId}"></s:hidden>
			<DIV class="t">
				<div>

				</div>
				<table width="976" border="1" bordercolor="#e0f0f9">
					<tr>
						<td>
							<s:textfield id="album.albumName" name="album.albumName" label="相册名称"
								value="%{album.albumName}"></s:textfield>
						</td>
					</tr>
					<tr>
						<td>
							<s:textarea id="album.albumDesc" name="album.albumDesc" label="相册说明"
								value="%{album.albumDesc}" rows="10" cols="50"></s:textarea>
						</td>
					</tr>
				</table>
			</DIV>
			<DIV style="MARGIN: 15px 0px; TEXT-ALIGN: center">
				<INPUT class="btn" tabIndex="3" type="button" value="提 交" onclick="check()">
				<INPUT class="btn" tabIndex="4" type="reset" value="重 置">
			</DIV>
		</form>
		<div>
			<jsp:include page="bottom.jsp"></jsp:include>
		</div>
		</table>
	</BODY>
</HTML>