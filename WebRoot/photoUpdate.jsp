<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<html>
	<head>
		<title>修改相片说明</title>
		<Link rel="stylesheet" type="text/css" href="style/style2.css" />
		<style type="text/css">
@import url(style/style.css);
</style>
<script type="text/javascript">
function check(){
	var name=document.getElementById("photo.title").value;

	if(name==""){
		alert("图片名不能为空");
		return;
	}
	document.getElementById("updateForm").action="Photo_updatePhoto.action";
	document.getElementById("updateForm").submit();
	}
</script>
	</head>
	<body>
		<DIV>
			<IMG src="Logoimage/logo.gif">
		</DIV>
			<jsp:include page="head.jsp"></jsp:include>
			<div class="photobox" align="center">
			<img width="500" height="400"
				src="<s:property value='photo.picUrl'/>" />
				</div>
		<form id="updateForm" action="" method="post">
			<s:hidden name="photo.photoId" value="%{photo.photoId}"></s:hidden>
			<DIV class="t">
				<div>
				</div>
				<table width="976" border="1" bordercolor="#e0f0f9">
					<tr>
						<td>
							<s:textfield id="photo.title" name="photo.title" label="图片名称" value="%{photo.title}"></s:textfield>
						</td>
					</tr>
					<tr>
						<td>
							<s:textarea id="photo.photoDesc" name="photo.photoDesc" label="图片说明"
								value="%{photo.photoDesc}" rows="10" cols="50"></s:textarea>
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
	</body>
</html>