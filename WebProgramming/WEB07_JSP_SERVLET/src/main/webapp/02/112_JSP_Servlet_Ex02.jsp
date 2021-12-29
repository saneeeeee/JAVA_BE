<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>112_JSP_Servlet_Ex02.jsp</title>
</head>
<body>
<%
String id = (String)request.getAttribute("id");
String pwd = (String)request.getAttribute("pwd");
String gender = (String)request.getAttribute("gender");
String mail = (String)request.getAttribute("mail");
String [] items = (String [])request.getAttribute("items");
String job = (String)request.getAttribute("job");
String [] interests = (String [])request.getAttribute("interests");
String cont = (String)request.getAttribute("content");
%>
아이디 : <%=id %><br>
암&nbsp;호 : <%=pwd %><br>
성&nbsp;별 : <%=gender %><br>
메일수신여부 : <%=mail %><br>
가입인사 : <%=cont %><br>
구입항목 : <%for(String sit :items) {%><%=sit + " " %><%} %><br>
직&nbsp;업 : <%=job %><br>
관심분야 : <%for(String sin :interests){ %><%=sin + " " %><%} %><br>
</body>
</html>
