<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>02_ParameterNull.jsp</title>
</head>
<body>
<h3>JSP 코드 : <%=request.getParameter("id") %></h3>
<h3>EL 코드 : ${param.id}</h3>


JSP 코드
<br>
request.getParameter("id").equals("hong") -> 에러 <br>
equals() 사용 결과 : error - equals 메서드는 "null 값" 으로 비교할 때 오류를 발생시킴
<br><br>
에러를 방지하기 위해 '==' 연산자를 사용 : <br>
request.getParameter("id") == "hong" =>
<%=request.getParameter("id")!=null && request.getParameter("id").equals("hong") %>

<br><hr>
EL 식 '==' 연산자 사용 결과 : \${param.id =="hong"} - > ${param.id =="hong"}
<br><br>
<hr>
equals() 를 사용할 때의 null 값 비교 오류해결 방법:
<pre>
<!-- <pre> 태그 : 입력 한 그대로를 화면에 보여주라는 태그 : 주로 코딩 내역을 화면에 표시할 때 사용 -->
if(request.getParameter("id")!=null){
	if(request.getParameter("id").equals("hong")){
		
	}
}

</pre>
</body>
</html>