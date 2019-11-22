<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>메인 페이지</title>
</head>
<body>
	<!-- JSTL 의 core 기능을 사용할 수 있는 설정 -->
	<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
	
	<!-- 로그인 이 안된 경우는 로그인 링크를 생성 -->
	<c:if test="${id == null}">
		<a href = 'data/login'>로그인</a><br />
	</c:if>
	
	<!-- 로그인 된 경우는 로그아웃 링크를 생성 -->
	<c:if test="${id != null}">
		<a href = 'data/logout'>${nickname}님 로그아웃</a><br />
	</c:if>
	
	<a href = 'data/update'>데이터 수정</a><br />
	<a href = 'data/read'>데이터 읽기</a><br />
</body>
</html>