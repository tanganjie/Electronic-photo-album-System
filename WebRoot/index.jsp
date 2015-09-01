<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>欢迎进入电子相册系统</title>
	<script type="text/javascript" src="core/flowplayer-3.2.6.min.js"></script>
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
  </head>
  
  <body style="text-align: center;" >
		<DIV>
			<IMG src="Logoimage/logo.gif">
		</DIV><a  
			 href="a.flv"
			 style="display:block;width:500px;height:300px"  
			 id="player"> 
		</a> 
	
		<!-- this will install flowplayer inside previous A- tag. -->
		<script>
			flowplayer("player", "core/flowplayer-3.2.7.swf");
		</script>
    <a href="login.jsp">点击</a>登录
  </body>
</html>
