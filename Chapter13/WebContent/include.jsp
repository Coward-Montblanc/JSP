<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Include.jsp : 강석현</title>
	</head>
	<body>
		안녕하세요. jsp 쇼핑몰 시작부분입니다.
		<br>
		<jsp:include page="duke_image.jsp">
			<jsp:param value="듀크" name="name"/>
			<jsp:param value="duke.png" name="imgName"/>
		</jsp:include>
		<br>
		jsp 쇼핑몰 끝부분입니다.
	</body>
</html>