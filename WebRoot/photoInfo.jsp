<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
request.setCharacterEncoding("UTF-8");
%>
<HTML>
	<HEAD>
		<base href="<%=basePath%>">
		<TITLE>添加相片评论</TITLE>
  <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<Link rel="stylesheet" type="text/css" href="style/style2.css" />
		<style type="text/css">
@import url(style/style.css);
</style>
<script>
	function check(){
		var title=document.getElementById("photoword.title").value;
		var content=document.getElementById("photoword.content").value;
		if(title==""){
			alert("标题不能为空");
			return;
		}
		if(content==""){
			alert("内容不能为空");
			return;
		}
		document.getElementById("addwordForm").action="Photo_addPhotoword.action";
		document.getElementById("addwordForm").submit();
	}

</script>
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
			上传于
			<s:property value="photo.uploadDate" />
		</div>
		<!-- 相片评论信息 -->
		<s:iterator value="allPhotoword">
			<DIV class="t">
				<TABLE style="BORDER-TOP-WIDTH: 0px; TABLE-LAYOUT: fixed" cellSpacing="0" cellPadding="0" width="100%">
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
								<s:property value="content" escape="false" />
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
		<!-- 添加相片评论 -->
		<DIV>
			<FORM id="addwordForm"  action="" method="post">
				<s:hidden name="photo.photoId" value="%{photo.photoId}"></s:hidden>
				<DIV class="t">
					<TABLE cellSpacing="0" cellPadding="0" align="center">
						<TR>
							<TD class="h" colSpan="3">
								<B>发表评论</B>
							</TD>
						</TR>

						<TR class="tr3">
							<th width="20%">
								<B>标题</B>
							</th>
							<th>
								<input class="input" style="PADDING-LEFT: 2px; FONT: 14px Tahoma" tabIndex="1" size="45" id="photoword.title" name="photoword.title">
							</th>
						</tr>

						<tr class="tr3">
							<th>
								<div>
									<b>内容</b>
								</div>
							</th>
							<td><textarea  id="photoword.content" name="photoword.content" rows="10" cols="50"></textarea>
							</td>
						</TR>
					</TABLE>
				</DIV>
				<DIV style="MARGIN: 15px 0px; TEXT-ALIGN: center">
					<INPUT class="btn" tabIndex="3" type="button" value="提 交" onclick="check()">
					<INPUT class="btn" tabIndex="4" type="reset" value="重 置">
				</DIV>
			</form>
		</DIV>
		<div>
			<jsp:include page="bottom.jsp"></jsp:include>
		</div>
	</BODY>
</HTML>
