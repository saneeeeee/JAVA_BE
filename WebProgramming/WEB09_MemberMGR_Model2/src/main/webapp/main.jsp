<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript">
function deleteMember(){
	var bool = confirm("정말로 탈퇴하시겠습니까?");
	if(bool){
		location.href="member.do?command=delete";
	}else{
		
	}
}
</script>
</head>
<body>
<table>
	<tr><td>안녕하세요. ${loginUser.name}(${loginUser.userid})님</td></tr>
	<tr><td > email : ${loginUser.email}</td></tr>
	<tr><td > 전화번호 : ${loginUser.phone}</td></tr>
	<tr>
		<td >
			<input type="button" value="로그아웃" 
			onclick="location.href='member.do?command=logout'">
			<input type="button" value="회원정보변경" 
			onclick="location.href='member.do?command=updateForm'">
			<input type="button" value="회원탈퇴" onclick="deleteMember()">
		</td>
	</tr>
</table>
<br><br>
<c:if test="${loginUser.admin == 1}">
	<table  align="center" width="800" bgcolor="black" cellspacing="1">
		<tr bgcolor="white"><th>아이디</th><th>이름</th><th>전화번호</th>
				<th>이메일</th><th>관리자/<br>일반회원</th><th>등급변경</th></tr>
		<c:forEach items="${memberList}" var="mem">
			<tr  bgcolor="white" align="center">
				<td>${mem.userid}</td><td>${mem.name}</td><td>${mem.phone}</td>
				<td>${mem.email}</td>
				<td>
					<c:choose>
						<c:when test="${mem.admin==0}">일반회원</c:when>
						<c:otherwise>관리자</c:otherwise>
					</c:choose>
				</td>			
				<td width="150">
					<c:if test="${mem.userid != loginUser.userid }">
						<c:if test="${mem.admin == 0}">
							<input type="button" value="관리자로 변경" 
								onClick="location.href='member.do?command=editadmin&userid=${mem.userid}'">
								<!-- 서블릿 이름 : EditAdminServlet -->
						</c:if>
						<c:if test="${mem.admin == 1}">
								<input type="button" value="일반회원으로 변경" 
								onClick="location.href='member.do?command=editadmin&userid=${mem.userid}'">
						</c:if>
					</c:if>
				</td>
			</tr>
		</c:forEach>
	</table>
</c:if>
<br><br><br>
</body>
</html>