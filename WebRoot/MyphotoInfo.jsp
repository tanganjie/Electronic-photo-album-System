<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<HTML>
	<HEAD>
		<base href="<%=basePath%>">
		<TITLE>添加相片评论</TITLE>
		<Link rel="stylesheet" type="text/css" href="style/style2.css" />
		<style type="text/css">
@import url(style/style.css);
</style>
	</HEAD>
	<BODY>
		<DIV>
			<IMG src="Logoimage/logo.gif">
		</DIV>
			<jsp:include page="head.jsp"></jsp:include>
		<!-- 相片信息 -->
		<div class="photobox" align="center">
			<img width="500" height="400"
				src="<s:property value='photo.picUrl'/>" />
			<br>
			相片:
			<s:property value="photo.title" />
			<br>
			描述:
			<s:property value="photo.photoDesc" />
			<br>
			上传于
			<s:property value="photo.uploadDate" />
			<a
				href="Photo_findPhotoById.action?photo.photoId=<s:property value='photo.photoId'/>"><img
					src="Logoimage/edit.gif" />修改相片</a>
			<a
				href="Photo_deletePhoto.action?photo.photoId=<s:property value='photo.photoId'/>"><img
					src="Logoimage/delete.gif" />删除相片</a>
		</div>
		<!-- 相片评论信息 -->
		<s:iterator value="allPhotoword">
			<DIV class="t">
				<TABLE style="BORDER-TOP-WIDTH: 0px; TABLE-LAYOUT: fixed"
					cellSpacing="0" cellPadding="0" width="100%">
					<TR class="tr1">
						<TH style="WIDTH: 20%">
							<B>评论人:<s:property value="user.userName" /> </B>
							<BR />
							<BR />
							<img src="Logoimage/head/<s:property value='user.head'/>" />
							<BR />
							注册:
							<s:property value="user.regDate" />
							<BR />
						</TH>
						<TH>
							<H4>
								<s:property value="title" />
							</H4>
							<DIV>
									<s:property value="content" />
							</DIV>
							<DIV class="tipad gray">
								发表：[
								<s:property value="wordDate" />
								]
							</DIV>
						</TH>
					</TR>
				</TABLE>
			</DIV>
		</s:iterator>
		<div>
			<jsp:include page="bottom.jsp"></jsp:include>
		</div>
	</BODY>
</HTML>
