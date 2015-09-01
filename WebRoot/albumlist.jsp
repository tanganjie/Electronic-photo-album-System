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
			<jsp:include page="head.jsp"></jsp:include>
		<div class="album_list">
			<table cellspacing="6" cellpadding="0">
				<tr>
					<s:iterator value="allAlbum" status="vs">
						<td width="50%" class="album">
							<table cellspacing="0" cellpadding="0">
								<tr>
									<td class="image">
										<a
											href="Photo_findAllPhoto.action?photo.albumId=<s:property value="albumId"/>">
											<s:if test="%{cover==null}">
												<img width="140" height="105" src="Logoimage/none.gif" />
											</s:if> <s:else>
												<img width="140" height="105"
													src="<s:property value='cover'/>" />
											</s:else> </a>
									</td>
									<td>
										<p>
											名称：
											<s:property value="albumName" />
										</p>
										<p>
											创建人：
											<s:property value="user.userName" />
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
			共<s:property value="pageBean.allRow"/> 条记录
   					共<s:property value="pageBean.totalPage"/> 页
   					当前第<s:property value="pageBean.currentPage"/>页<br/>
   						<s:if test="%{pageBean.currentPage == 1}">第一页 上一页</s:if>
　　　　			<s:else><a href="Album_findAll.action?page=1" >第一页</a>
			  			<a href="Album_findAll.action?page=${pageBean.currentPage-1 }">上一页</a>
　　　　			</s:else>
						<s:if test="%{pageBean.currentPage != pageBean.totalPage}">
　　　　　　<a href="Album_findAll.action?page=${pageBean.currentPage+1 }" >下一页</a>
　　　　　　<a href="Album_findAll.action?page=${pageBean.totalPage }" >最后一页</a>
　　　　		 </s:if>
　　　　       <s:else>下一页 最后一页</s:else> 
		</div>
		<div>
			<jsp:include page="bottom.jsp"></jsp:include>
		</div>
	</body>
</html>
