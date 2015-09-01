<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'index.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

  </head>
  
  <body>
    注册<br>
    
    <form action="User_regist.action" method="get">
			NAME:
			<input type="text" name="user.userName" />
			<br />
			PASS:
			<input type="password" name="user.passWord">
			<br />
			PASS AGAIN:
			<input type="password" name="iuser.passWord">
			<br />
			QUESTION:<select name="user.question">
				<s:iterator value="%{questionList}" id="item">
					<option value="<s:property value="%{#item.qusId}"/>"><s:property value="%{#item.remark}"/></option>
				</s:iterator>
			</select>
			<br />
			ANSWER:
			<input type="text" name="user.answer" />
			<br />
			<input type="submit" value="submit" />
		</form>
  </body>
</html>
