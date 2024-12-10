<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>UPDATE</title>
</head>
<body>
	<form action="/member/update" method="post" name="updateForm">
		<p>
			아 이 디 : <input type="text" name="memberId" value="${member.memberId}"
				disabled>
				<input type="hidden" name="memberId" value="${member.memberId}">
		</p>
		<p>
			비밀번호 : <input type="text" name="memberPassword" id="memberPassword">
		</p>
		<p>
			이 름 : <input type="text" name="memberName"
				value="${member.memberName}" disabled>
		</p>
		<p>
			국어 점수 : <input type="text" name="Korean" value="${member.korean}">
		</p>

		<p>
			영어 점수 : <input type="text" name="English" value="${member.english}">
		</p>

		<p>
			수학 점수 : <input type="text" name="Math" value="${member.math}">
		</p>

		<input type="button" value="수정" onclick="update()">
	</form>
</body>

<script>
    const update = () => {
        const passwordDB = '${member.memberPassword}';
        const password = document.getElementById("memberPassword").value;
        if (passwordDB == password) {
            document.updateForm.submit();
        } else {
            alert("비밀번호가 일치하지 않습니다!");
        }
    }
</script>
</html>