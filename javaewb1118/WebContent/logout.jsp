<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>로그아웃</title>
</head>
<body>
<%
	//세션을 초기화하는 메소드
	session.invalidate();	
%>
	<p>로그아웃하셨습니다.</p>
</body>
</html>