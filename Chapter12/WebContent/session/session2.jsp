<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%
	String address = (String)session.getAttribute("address");
	String name = (String)session.getAttribute("name");
	//JSP에서는 자동으로 세션 객체를 생성하기에 굳이 getSession으로 호출할 필요가 없음
	//HttpSession session = request.getSession(); 이거 안쓴다고
%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>session 내장 객체 테스트 2</title>
	</head>
<body>
	<h1>이름은 <%=name %>입니다.</h1><br>
	<h1>주소는 <%=address %>입니다.</h1><br>
</body>
</html>