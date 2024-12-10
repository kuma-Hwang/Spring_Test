<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원가입</title>

<style type="text/css">
	*{ padding: 0; margin: 0;}
	form { margin: 0 auto;}
	input[type="text"] {width: 150px; height: 20px;}
	input[type="submit"] { width: 100px; height: 30px; background: #5b9bd5; color: #fff; font-size:11px; margin: 30px 0 0 30px;}
	input[type="reset"] { width: 100px; height: 30px; background: #5b9bd5; color: #fff; font-size:11px;}
</style>
</head>
<body>
	<form action="/member/save" method="post">
		<p>학번 : <input type="text" name="memberId" placeholder="학번" id="memberId"></p>
		<p>비밀번호 : <input type="text" name="memberPassword" placeholder="비밀번호"></p>
		<p>이   름 : <input type="text" name="memberName" placeholder="이름"></p>
		<p>국   어 : <input type="text" name="korean" placeholder="점수를 입력하세요"></p>
		<p>영   어 : <input type="text" name="english" placeholder="점수를 입력하세요"></p>
		<p>수   학 : <input type="text" name="math" placeholder="점수를 입력하세요"></p>
		<input type="submit" value="입력">
		<input type="reset" value="초기화">
	</form>
</body>
</html>