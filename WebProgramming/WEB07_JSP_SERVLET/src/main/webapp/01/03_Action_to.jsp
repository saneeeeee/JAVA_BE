<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>03_Action_to.jsp</title>
</head>
<body>
<h3> get 방식으로 요청되어진 주소 </h3>
http://localhost:8090/WEB07_JSP_SERVLET/01/03_Action_to.jsp?name=123&id=123213123&pwd=312321321&pwd_re=321312
<h3> post 방식으로 요청되어진 주소 </h3>
http://localhost:8090/WEB07_JSP_SERVLET/01/03_Action_to.jsp
<br>
<!-- 위 주소를 이용해 서버에 요청이 전달되면 해당페이지(03_Action_to.jsp)가 내부에 포함된 JSP 명령을 실행 후
클라이언트로 다운로드되어 웹브라우져에 보여지게 됩니다. 이 과정에서 Parameter 로 전달되는 name 과 value 들이 
서버에서 JSP 명령의 피연산자(연산의 대상)이 될 수 있습니다 -->

<!-- 요청방식
http://주소/경로/파일이름.jsp?첫번째전달요소의name=전달값&두번째요소name=전달값&... -->
<!-- 한글은 인코딩 방식에 따라 위와 같이 %16진수값으로 표시될 수 있습니다. -->
<!-- 아래는 서버에서 실행되어 HTML5 로 구성될 내용들입니다 -->
<%
	String name = request.getParameter("name");
	String id = request.getParameter("id");
	String pwd = request.getParameter("pwd");
	String pwd_re = request.getParameter("pwd_re");
	String useritem = request.getParameter("useritem");
%>

성명 : <%= name %><br>
아이디 : <%= id %><br>
비밀번호 : <%= pwd %><br>
비밀번호 확인 : <%= pwd_re %><br>
사용자item : <%= useritem %><br>
</body>
</html>