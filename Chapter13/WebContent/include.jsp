<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Include.jsp : ������</title>
	</head>
	<body>
		�ȳ��ϼ���. jsp ���θ� ���ۺκ��Դϴ�.
		<br>
		<jsp:include page="duke_image.jsp">
			<jsp:param value="��ũ" name="name"/>
			<jsp:param value="duke.png" name="imgName"/>
		</jsp:include>
		<br>
		jsp ���θ� ���κ��Դϴ�.
	</body>
</html>