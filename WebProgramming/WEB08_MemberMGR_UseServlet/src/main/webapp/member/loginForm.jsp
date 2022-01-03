<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>loginForm.jsp</title>
</head>
<body>
<form method="post" action="login.do" name="frm">
	<table>
		<tr><td>아이디</td><td><input type="text" name="id" id="userid"></td></tr>
		<tr><td>암 호</td><td><input type ="password" name="pwd" id="userpwd"></td></tr>
		<tr><td colspan="2" align="center">
				<input type="submit" value="로그인">
				<input type="reset" value="취소">
				<input type="button" value="회원가입"></td></tr>
		<tr><td cospan="2">${message}</td></tr>
	</table>
</form>
</body>
</html>