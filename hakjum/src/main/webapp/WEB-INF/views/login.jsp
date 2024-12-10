<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>로그인</title>
<style type="text/css">
	*{ padding: 0; margin: 0;}
	form { margin: 0 auto;}
	input[type="text"] {width: 150px; height: 20px;}
	input[type="submit"] { width: 100px; height: 30px; background: #5b9bd5; color: #fff; font-size:11px; margin: 30px 0 0 30px;}
</style>
</head>
<body>
	<form action="/member/login" method="post">
		ID: <input type="text" name="memberId" placeholder="학번"> <br/>
		PW: <input type="text" name="memberPassword" placeholder="비밀번호">
		<br/><p/>
		<input type="submit" value="로그인">
	</form>
</body>
</html>