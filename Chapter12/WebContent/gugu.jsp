<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%
	request.setCharacterEncoding("utf-8");
	int dan = Integer.parseInt(request.getParameter("dan"));
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>구구단 결과</title>
</head>
<body>
	<table border = "1" width = "160">
		<tr align=center bgcolor="#FFFF66" >
			<td colspan ="2"><%= dan %>단 출력
		</tr>
		<%
			for(int i = 1; i<=19; i++) {
		%>
			<tr align=center>
				<td width ="80"><%= dan %> X <%= i %> </td>
				<td width ="80"><%= dan*i %> </td>
			</tr>
		<%
			}
		%>
	</table>
</body>
</html>