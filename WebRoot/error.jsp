<%@ page language="java" contentType="text/html; charset=gb2312"%>
<%@ page import="java.sql.*"%>
<script language=javascript>
function countDown(secs,surl){
 //alert(surl);

 tiao.innerText=secs;
 if(--secs>0){
     setTimeout("countDown("+secs+",'"+surl+"')",1000);
     }
 else{
  
     location.href=surl;
     } 
 }
</script>
<html>
  <head>
    <title>电子相册</title>
  <meta http-equiv="Content-Type" content="text/html; charset=gb2312">
  <style type="text/css">
  body {
	background-image: url(img/back.jpg);
}
  </style>
  </head>
  <body><font size="6"><strong><font face="Adobe 黑体 Std R"><strong>欢迎使用</strong></font></strong></font>
  
    <p><br></p><p>出错！</p>
    <span id="tiao">3</span>秒后<a href="login.jsp">进入</a><script language=javascript>countDown(3,'login.jsp');</script>
  </body>
</html>