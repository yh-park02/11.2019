<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>로그인</title>
<style>
	#msg{color:red}
</style>
</head>
<body>
	<div id="msg">${msg}</div>
	
	<!-- action은 서버에서 처리할 URL이다.
	생략하면 요청한 URL을 그대로 사용한다.
	최근에는 form에 오게된 요청과 form을 처리하는 요청을 동일하게 만들고
	form에 오게된 요청은 GET으로 form을 처리하는 요청을 POST로 설정해서 구분한다.
	데이터 삽입은 POST, 수정은 PUT, 삭제는 DELETE로 구분하기도 한다. -->
	<form method="post">
		아이디<br/>
		<input type="text" name="id" id="id" required="required"
		placeholder="아이디를 입력하세요!" /><br/>
		
		비밀번호<br/>
		<input type="password" name="password" id="password" required="required"
		placeholder="비밀번호를 입력하세요!" /><br/>
		<input type="submit" value="로그인" />
	</form>
</body>
</html>