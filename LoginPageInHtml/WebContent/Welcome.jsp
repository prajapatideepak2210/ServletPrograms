<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Welcome to jsp</title>
</head>
<body bgcolor="pink">
	<h2 align="center"><%="Hello " %> 
	<% String name=request.getParameter("uname");%>
	<% out.print(name+" Welcome to Your Profile."); %><br/></h2>
	
	<h3 align="center"><%out.print("This is the jsp Page."); %></h3>
</body>
</html>