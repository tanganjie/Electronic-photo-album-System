<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
	<head>
		<title>My JSP 'bottom.jsp' starting page</title>
	</head>
	<body>
		<div class="tabs_header" align="center">
			<ul class="tabs">
				<li>
					<a href="Album_findAllAlbum.action"><span><s:property value="%{getText('myalbum')}" /></span> </a>
				</li>
				<li>
					<a href="Album_findAll.action"><span><s:property value="%{getText('ouralbum')}" /></span> </a>
				</li>
				<li>
					<a href="User_logOut.action"><span><s:property value="%{getText('exit')}" /></span> </a>
				</li>
				<li class="null">
					<a href="Album_findAllKindForAdd.action"><s:property value="%{getText('create')}" /></a>
				</li>
				<li class="null">
					<a href="Album_findAllAlbumForAdd.action"><s:property value="%{getText('upload')}" /></a>
				</li>
			</ul>
		</div>
	</body>
</html>
