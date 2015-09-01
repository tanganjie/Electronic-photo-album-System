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
		<title>相册列表</title>
		<style type="text/css">
@import url(style/style.css);
</style>
	</head>
	<body>
		<DIV>
			<IMG src="Logoimage/logo.gif">
		</DIV>
		<div align="center">
			<jsp:include page="head.jsp"></jsp:include>
			</div>
		<div class="album_list">
			<table cellspacing="6" cellpadding="0" >
				<tr>
					<s:iterator value="allAlbum" status="vs">
						<td width="50%" class="album">
							<table cellspacing="0" cellpadding="0">
								<tr>
									<td class="image">
										<a href="Photo_findUserAllPhoto.action?photo.albumId=<s:property value="albumId"/>">
											<s:if test="%{cover==null}">
												<img width="140" height="105" src="Logoimage/none.gif" />
											</s:if> <s:else>
												<img width="140" height="105"
													src="<s:property value='cover'/>" />
											</s:else> 
											</a>
									</td>
									<td>
										<p>
											名称：
											<s:property value="albumName" />
										</p>
										<p>
											类别：
											<s:property value="kind.kindName" />
										</p>
										<p>
											描述：
											<s:property value="albumDesc" />
										</p>
										<p>
											创建时间：
											<s:property value="createDate" />
										</p>
										<p>
											<a
												href="Album_findAlbumById.action?album.albumId=<s:property value='albumId'/>"><img
													alt="修改相册" src="Logoimage/edit.gif" /> </a>
											<a
												href="Album_deleteAlbum.action?album.albumId=<s:property value='albumId'/>"><img
													alt="删除相册" src="Logoimage/delete.gif" /> </a>
										</p>
									</td>
								</tr>
							</table>
						</td>
						<s:if test="#vs.count % 2 == 0">
				</tr>
				<tr>
					</s:if>
			</s:iterator>
				</tr>
			</table>
		</div>
		<div>
			<jsp:include page="bottom.jsp"></jsp:include>
		</div>
	</body>
</html>
