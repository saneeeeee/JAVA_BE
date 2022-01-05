<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>loginForm.jsp</title>
<script type="text/javascript">
	function longinCheck(){
		if( document.frm.userid.value == ""){
			alert("아이디를 입력하세요");
			document.frm.userid.focus();
			return false;
		}
		
		if( document.frm.pwd.value == ""){
			alert("패스워드를 입력하세요");
			document.frm.pwd.focus();
			return false;
		}
		return true;
	}
</script>
</head>
<body>
<form action="login.do" method="post" name="frm">
	<table>
		<tr><td>아이디</td><td><input type="text" name="userid"></td></tr>
		<tr><td>암  호</td><td><input type="password" name="pwd"></td></tr>
		<tr><td colspan="2" align="center">
			<input type="submit" value="로그인" onClick="return longinCheck()">
			<input type="reset" value="취소">
			<input type="button" value="회원가입"  onClick="location.href='join.do'"></td></tr>
			<tr><td colspan="2">${message}</td></tr>
	</table>
</form>
</body>
</html>