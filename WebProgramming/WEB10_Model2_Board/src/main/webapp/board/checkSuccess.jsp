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
</head>
<body>
<script type="text/javascript">
	if(window.name=='update'){
		window.opener.location.href = "board.do?command=boardUpdateForm&num=${param.num}";
	}else if(window.name == 'delete'){
		var bool = confirm("정말로 삭제할까요?");
		if(bool)
			window.opener.location.href = "board.do?command=boardDelete&num=${param.num}";
	}
	
	self.close();
</script>

</body>
</html>