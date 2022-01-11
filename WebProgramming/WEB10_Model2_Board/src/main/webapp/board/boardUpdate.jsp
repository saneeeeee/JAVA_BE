<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<c:if test="${empty loginUser}">
	<jsp:forward page='board.do?command=index' />
</c:if>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css" href="css/board.css">
<script src="script/script.js"></script>
</head>
<body>
<div id="wrap" align="center">
	<h1>게시글 수정</h1>
	<form action="board.do?command=boardUpdate" method="post" name="frm">
	<input type="hidden" name="num" value="${board.num}">
		<table>
			<tr><th>작성자</th><td>${board.userid}
			<input type="hidden" name="userid" value="${loginUser.userid}"></td></tr>
			<tr><th>비밀번호</th><td>
			<input type="password" name="pass"> * 필수</td></tr>
			<tr><th>email</th><td>
			<input type="text" name="email" value="${board.email}" size="12"></td></tr>
			<tr><th>제목</th><td>
			<input type="text" size="70" name="title" > * 필수</td></tr>
			<tr><th>내용</th><td><textarea cols="70" rows="15" name="content" >${board.content}</textarea> * 필수</td></tr>
		</table>
		<input type="submit" value="수정" onClick="return boardCheck();">
		<input type="reset" value="다시 작성">
		<input type="button" value="돌아가기" onClick="location.href='board.do?command=boardViewWithoutCount&num=${board.num}'">
	</form>
</div>
</body>
</html>