<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>07_ForEach02.jsp</title>
</head>
<body>
<% 
	String [] movieList = {"타이타닉", "시네마 천국", "혹성 탈출", "킹콩"};
	pageContext.setAttribute("movieList",movieList);
%>
<table border="1" style="width:700px; text-align:center">
	<tr><th>index</th><th>count</th><th>title</th></tr>
	<c:forEach items="${movieList}" var="movie" varStatus="status">
		<tr><td>${status.index}</td><td>${status.count}</td><td>${movie}</td></tr>
	</c:forEach>
</table>
<!-- 
varStatus : 반복실행의 상태값을 갖고 있는 클래스
status : 현재 반복순서의 객체 변수
${status.count} : 1부터 시작한 반복의 현재 아이템
${status.index} : 0부터 시작한 반복의 현재 아이템
 -->
 
 
 <!-- 위의 pageContext 에 저장된 movieList 를 이용하여 반복실행문을 제작하되, 영화 제목으로
 구성된 리스트를 만들어 주세요 첫번째 목록은 글자색 빨간색으로 표시하고 나머지는 검은색으로 표시해주세요-->
 
<ul>
	<c:forEach items="${movieList}" var="movie" varStatus="status">
	<c:choose>
		<c:when test="${status.first}">
			<li style="color:red;font-weight:bold">${movie}</li>
		</c:when>
		<c:otherwise>
			<li style="color:black">${movie}</li>
		</c:otherwise>
	</c:choose>
	</c:forEach> 
</ul>

<!-- 
${staus.first} : 현재 루프가 처음이면 true 리턴 
${staus.last} : 현재 루프가 마지막이라면 true 리턴
-->

<!-- 마지막 아이템만 빼고 각 아이템 사이에 (,) 컴마를 찍어 출력하고 싶을때 -->
<c:forEach items="${movieList}" var="movie" varStatus="status">
	<%-- ${movie} --%>${status.current} <c:if test="${not status.last}">, </c:if>
</c:forEach>
<!-- 
${status.current} : 현재 아이템
${status.begin} : 시작값
${status.end} : 끝값
${status.step} : 증가값
-->
<br><br>
<h3>반복 실행문의 또다른 사용 예</h3>
<c:forEach var="cnt" begin="1" end="10" varStatus="status">
	${cnt} <c:if test="${not status.last}">, </c:if>
</c:forEach>
<br><br>
<br><br>
<table border="1" style="width:50%;text-align:center;" align="left">
	<tr><th>index</th><th>count</th><th>cnt</th></tr>
	<c:forEach var="cnt" begin="7" end="10" varStatus="status">
		<tr><td>${status.index}</td><td>${status.count}</td><td>${cnt}</td></tr>
	</c:forEach>
</table>
</body>
</html>
