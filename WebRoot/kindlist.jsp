<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
	<head>
		<title>相册种类列表</title>
		<Link rel="stylesheet" type="text/css" href="style/style2.css" />
		<style type="text/css">
@import url(style/style.css);
</style>
	</head>
	<body>
		<DIV>
			<IMG src="Logoimage/logo.gif">
		</DIV>
			<jsp:include page="head2.jsp"></jsp:include>
		<DIV class="t">
			<TABLE cellSpacing="0" cellPadding="0" width="80%">
				<TR>
					<TH class="h" style="WIDTH: 80%" colSpan="4">
						<SPAN>&nbsp;</SPAN>
					</TH>
				</TR>
				<!--       表 头           -->
				<TR class="tr2">
					<TD style="WIDTH: 20%" align="center">
						种类名称
					</TD>
					<TD style="WIDTH: 50%" align="center">
						种类说明
					</TD>
					<TD style="WIDTH: 30%" align="center">
						操作
					</TD>
				</TR>
				<!--         主 题 列 表        -->
				<s:iterator value="allKind">
					<TR class="tr3">
						<TD align="center">
							<s:property value="kindName" />
						</TD>
						<TD align="center">
							<s:property value="kindDesc" />
						</TD>
						<TD align="center">
							<a href="Album_findKindById.action?kind.kindId=<s:property value="kindId"/>">修改|</a>
							<a href="Album_deleteKind.action?kind.kindId=<s:property value="kindId"/>">删除</a>
					</TR>
				</s:iterator>
			</TABLE>
		</DIV>
		<div>
			<jsp:include page="bottom.jsp"></jsp:include>
		</div>
	</body>
</html>