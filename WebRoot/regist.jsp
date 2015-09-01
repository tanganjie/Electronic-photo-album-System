<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
	<title>用户注册_窗内网</title>
	<link href="style/reg.css" type="text/css" rel="stylesheet" />
 <script type="text/javascript" src="jquery/js/jquery-1.3.2.min.js"></script>
 <script type="text/javascript" src="jquery/js/jquery-ui-1.7.2.custom.min.js"></script>
	<script type="text/javascript">
	var flag=0;
	function check() {
		var username=document.getElementById("user.userName").value;
		var password=document.getElementById("user.passWord").value;
		var ipassword=document.getElementById("iuser.passWord").value;
		var answer=document.getElementById("user.answer").value;
		if (username == "") {
			alert("用户名不能为空");
			return;
		}
		if (password == "") {
			alert("密码不能为空");
			return;
		}
		if (password != ipassword) {
			alert("2次密码不一样");
			return;
		}
		if(answer==""){
			alert("答案不能为空");
			return;
		}
		if(flag==0){
		alert("用户名已存在");
			return;
		}
		document.getElementById("regForm").action="User_regist.action";
		document.getElementById("regForm").submit();
		//document.getElementById("regForm").action="";
	}
	
	function checkName(){
		var username=document.getElementById("user.userName").value;
		if(username==""){
			jQuery("#check").html("<font color='#FF0000'>用户名不能为空</font>");
			flag=0;
		}
		else{
			var params="user.userName="+username;
			
			jQuery.ajax({
		   url: "check.action",
		   type: "post",
		   data: params,
		   dataType: "json",
		   success:function(data)
		   { 		     
		        var check ="<font color='#FF0000'>";
		        
		        if(data.num!=0){
		        	check+="用户名已存在";
		        	flag=0;
		        }
		        else{
		        	check+="有效";
		        	flag=1;
		        }
		        check+="</font>";
			   
			    jQuery("#check").html(check);
		   } ,
		   error:function(data){
		   	alert("出错");
		   }
	  }); 
		}
	}
</script>

</head>
<body>
	<div id="header">
		<div class="h_lt"><img src="images/logo.gif" />
		</div>
	</div>
	<div align="center">
		<div class="c_lt">
			<div class="tt">
				只填四项就可立即注册
				<font color="#FF0000">（必填）</font>
			</div>
			
			<form action="" method="post" name="regForm" id="regForm">
				<div class="content">
					<p>
						<label for="email">
							<s:property value="%{getText('username')}" />：
						</label>
						<INPUT class="input" type="text" id="user.userName" maxLength=16 name="user.userName" onblur="checkName()"><br/><div id="check"><font color="#FF0000"></font></div>
					</p>
					<p>
						<label for="email">
							<s:property value="%{getText('password')}" />：
						</label>
						<INPUT class="input"  type=password maxLength=16 id="user.passWord" name="user.passWord">
							</p>
					<p>
						<label for="email">
							<s:property value="%{getText('ipassword')}" />：
						</label>
						<INPUT class="input" type=password maxLength=16 id="iuser.passWord" name="iuser.passWord">
					</p>
					<br>
					<p>
						<label for="email">
							<s:property value="%{getText('question')}" />：
							</label>
						<select class="select" style="width: 165px;" id="user.question" name="user.question">
				<s:iterator value="%{questionList}" id="item">
					<option value="<s:property value="%{#item.qusId}"/>"><s:property value="%{#item.remark}"/></option>
				</s:iterator>
						</select>
					</p>
					<br>
					<p>
						<label for="email">
							<s:property value="%{getText('answer')}" />：
						</label>
						<INPUT class="input"  type=text maxLength=16 id="user.answer" name="user.answer">
					</p>
					<p>
						<label for="email">
							<s:property value="%{getText('head')}" />：
						</label>
						<img width="70" height="70" src="Logoimage/head/1.gif" />
						<input type="radio" name="user.head" value="1.gif" checked="checked">
						<img width="70" height="70" src="Logoimage/head/2.gif" />
						<input type="radio" name="user.head" value="2.gif">
						<img width="70" height="70"src="Logoimage/head/3.gif" />
						<input type="radio" name="user.head" value="3.gif">
						<BR />
						<label for="email"></label>
						<img width="70" height="70" src="Logoimage/head/4.gif" />
						<input type="radio" name="user.head" value="4.gif">
						<img width="70" height="70" src="Logoimage/head/5.gif" />
						<input type="radio" name="user.head" value="5.gif">
						<img width="70" height="70" src="Logoimage/head/6.gif" />
						<input type="radio" name="user.head" value="6.gif">
					</p>
					<p>
						<INPUT type="button"  value="" class="tj" onClick="check()">
					</p>
				</div>
			</form>
			<div class="ft"></div>
		</div>
		</div>
	<div>
<jsp:include page="bottom.jsp"></jsp:include>
	</div>
</body>
</html>