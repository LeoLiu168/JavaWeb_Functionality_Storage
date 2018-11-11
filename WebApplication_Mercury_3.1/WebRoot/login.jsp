<%@ page contentType="text/html; charset=UTF-8" language="java" errorPage=""
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN"
	"http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<title>Please login</title>
</head>
<body>
<span style="color:red;font-weight:bold">
<%
	if(request.getAttribute("err") != null){
		out.print(request.getAttribute("err") + "<br/>");
	}
%>
</span>
请输入用户名和密码:
<form id="login" method="post" action="login">
用户名:<input type="text" name="username"/><br/>
密  码:<input type="password" name="password"/><br/>
<input type="submit" value="登录"/><br/>
</form>
</body>
</html>