<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script src="${ctx}/js/jquery-3.2.1.min.js"></script>
<title>Signup</title>
<script>
	function register(){
		var username = $("#username").val();
	 	var password = $("#password").val();
		
	 	var msg = "";
		   
	   if(!/^\w{2,20}$/.test(username)){
		     msg = "登录名长度必须是6~20之间";
	   }else if(!/^\w{4,20}$/.test(password)){
		     msg = "密码长度必须是6~20之间";
	   }
	   if(msg !=""){
		   alert(msg);
		   return false;
	   }else{
		   return true;
	   }
	}
</script>
</head>
<body>

<form action="signup" method="post" onsubmit="return register()">
	<input type="hidden" name="show" value="0">
	<c:choose>
		<c:when test="${requestScope.message != null}">
			<span><font color="red">${requestScope.message}</font></span><br>
		</c:when>
	</c:choose>
	User name: <input id="username" type="text" name="username"><br>
	Password: <input id="password" type="password" name="password"><br>
	email: <input id="email" type="text" name="email"><br>
	<button id="signup-submit-btn" type="submit">Signup</button>
</form>

</body>
</html>