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
    <title>�������</title>
  <meta http-equiv="Content-Type" content="text/html; charset=gb2312">
  <style type="text/css">
  body {
	background-image: url(img/back.jpg);
}
  </style>
  </head>
  <body><font size="6"><strong><font face="Adobe ���� Std R"><strong>��ӭʹ��</strong></font></strong></font>
  
    <p><br></p><p>�û������ڣ�</p>
    <span id="tiao">3</span>���<a href="login.jsp">����</a><script language=javascript>countDown(3,'login.jsp');</script>
  </body>
</html>