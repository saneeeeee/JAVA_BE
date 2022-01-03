<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>11_Format02.jsp</title>
</head>
<body>
<h3>톰캣 서버의 기본 로케일 : <%=response.getLocale() %></h3>
<!-- 혹시 다른 곳으로 되어있다면 -->
<fmt:setLocale value="ko_KR" />
<h3>로케일을 한국으로 설정 후 로케일 확인 : <%=response.getLocale() %></h3>

<h3>
통화(currency) : 
<fmt:formatNumber value="10000" type="currency" /><br>
숫자(number) : 
<fmt:formatNumber value="1000.1234" type="number" maxFractionDigits="2" /><br>
<!-- maxFractionDigits : 소숫점 자리수 -->
<c:set var="now" value="<%=new java.util.Date() %>"></c:set>
날짜 : <fmt:formatDate value="${now }" /><br><br>
</h3>
<h3>
<fmt:setLocale value="en_US" />
로케일을 영어로 설정 후 로케일 확인 : <%=response.getLocale() %><br>
통화(currency) : 
<fmt:formatNumber value="10000" type="currency" /><br>
<c:set var="now" value="<%=new java.util.Date() %>"></c:set>
날짜 : <fmt:formatDate value="${now}" /><br><br>
</h3>
<h3>
<fmt:setLocale value="ja_JP" />
로케일을 영어로 설정 후 로케일 확인 : <%=response.getLocale() %><br>
통화(currency) : 
<fmt:formatNumber value="10000" type="currency" /><br>
<c:set var="now" value="<%=new java.util.Date() %>"></c:set>
날짜 : <fmt:formatDate value="${now}" /><br><br>
</h3>
<br>

<fmt:requestEncoding value="UTF-8" />
<%-- <% request.setCharacterEncoding("UTF-8");%> --%>
</body>
</html>