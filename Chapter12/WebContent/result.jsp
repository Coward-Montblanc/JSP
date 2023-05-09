<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%
	request.setCharacterEncoding("utf-8");
	String id = request.getParameter("user_id");
	String pwd = request.getParameter("user_pwd");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>로그인 결과</title>
</head>
<body>
	<h1>로그인 결과 출력</h1>
	<h2>ID : <%= id %></h2>
	<h2>PASSWORD : <%= pwd %></h2>
</body>
</html>