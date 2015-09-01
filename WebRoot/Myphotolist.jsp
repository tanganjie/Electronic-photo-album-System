<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
	<head>
		<base href="<%=basePath%>">
		<title>相片列表</title>
		<Link rel="stylesheet" type="text/css" href="style/style2.css" />
		<style type="text/css">
@import url(style/style.css);
</style>
	</head>
	<body>
		<DIV>
			<IMG src="Logoimage/logo.gif">
		</DIV>
			<jsp:include page="head.jsp"></jsp:include>
		<table cellspacing="6" cellpadding="0" width="100%" class="photo_list">
			<tr>
				<s:iterator value="allPhoto" status="vs">
					<td>
						<a
							href="Photo_findUserPhotowords.action?photo.photoId=<s:property value="photoId"/>"><img
								width="130" height="98" src="<s:property value='smallPicUrl'/>" />
						</a><br>
						<s:property value="title" />
					</td>
					<s:if test="#vs.count % 4 == 0">
			</tr>
			<tr>
				</s:if>
				</s:iterator>
		</table>
		<div>
			<jsp:include page="bottom.jsp"></jsp:include>
		</div>
	</body>
</html>