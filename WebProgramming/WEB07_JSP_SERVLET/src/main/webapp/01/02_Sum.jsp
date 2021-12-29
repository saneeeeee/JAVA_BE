<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>02_Sum.jsp</title>
</head>
<body>
<!-- JSP 는 JAVA 에서 사용하던 거의 모든 문법이 똑같이 사용됩니다 -->

<%
	int sum = 0;
	for(int i = 1; i<=100;i++){
		sum+=i;
	}
%>
<h2><%= sum %></h2>

<%
	sum = 0;
	for(int i = 1; i<=100;i++){
		sum+=i;
%>
<h2><%= sum %></h2>
<%
	}
%>
</body>
</html>