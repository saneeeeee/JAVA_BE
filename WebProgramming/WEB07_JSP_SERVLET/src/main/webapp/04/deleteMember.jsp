<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.Connection"%>
<%request.setCharacterEncoding("UTF-8"); // 리퀘스트의 한글 인코딩 설정
Connection con = null;
PreparedStatement pstmt = null;
String url = "jdbc:oracle:thin:@localhost:1521:xe";
String driver = "oracle.jdbc.driver.OracleDriver";
String id = request.getParameter("userid");
String sql = "delete from mem where id=?";
try{
	Class.forName(driver);
	con = DriverManager.getConnection(url, "scott", "tiger");
	pstmt = con.prepareStatement(sql);
	pstmt.setString(1, id);
	pstmt.executeUpdate();
}catch(Exception e){	e.printStackTrace();
}finally{
	try {		if (pstmt != null) pstmt.close();
				if (con != null)	con.close();
	} catch (Exception e) {	e.printStackTrace();	}
}
response.sendRedirect("MemberMGR.jsp");
%>
