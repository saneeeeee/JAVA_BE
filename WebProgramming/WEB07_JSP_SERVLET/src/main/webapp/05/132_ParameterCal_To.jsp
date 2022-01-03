<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>142_ParameterCal_To.jsp</title>
</head>
<body>
고전적인 방식 : <br> 
<%
String str1 = request.getParameter("num1");
String str2 = request.getParameter("num2");
int number1 = Integer.parseInt(str1);
int number2 = Integer.parseInt(str2);
%>

<%= number1%> + <%=number2%> = <%=number1 + number2%><br>
<%=str1 %> + <%=str2%> + <%=str1+str2 %>
<hr><br>
EL 방식 : <br>

${param.num1} + ${param.num2} = ${param.num1 + param.num2}<!-- 산술 덧셈 --><br>
${param.num1} + ${param.num2} = ${param.num1 += param.num2} <!-- 이어붙이기 -->
</body>
</html>