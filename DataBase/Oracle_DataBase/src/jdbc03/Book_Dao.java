package jdbc03;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

// Dao : Database Access Object - 데이터베이스 접근(Access) 및 처리를 담당하는 클래스 객체
// dao 는 아래와 같은 네개의 기본멤버메서드가 존재합니다. 이 네개를 CRUD(Create, Read, Update, Delete)라고 부르기도 합니다.

public class Book_Dao {
	String url = "jdbc:oracle:thin:@localhost:1521:xe";
	String driver = "oracle.jdbc.OracleDriver";
	Connection con = null;
	PreparedStatement pstmt = null;	//	con 에 SQL 실행해주는 객체
	ResultSet rs = null;
	
	public void select() {
		//	테이블내용을 조회해서 결과를 리턴해주는 메서드
	}
	
	public void insert(Book_Dto bdto) {
		//	전달된 데이터를 테이블에 레코드로 추가하는 메서드	
		try {
			Class.forName(driver);
			con = DriverManager.getConnection(url, "scott", "tiger");
			String sql = "insert into booklist values( book_seq.nextVal, ?, ? , ? , ? , ? )";

			pstmt = con.prepareStatement(sql);

			pstmt.setString(1, bdto.getSubject());
			pstmt.setInt(2, bdto.getMakeyear());
			pstmt.setInt(3, bdto.getInprice());
			pstmt.setInt(4, bdto.getRentprice());
			pstmt.setString(5, bdto.getGrade());

			pstmt.executeUpdate();
			
		} 
		catch (ClassNotFoundException e) {e.printStackTrace();} 
		catch (SQLException e) {e.printStackTrace();}
		finally {
			try {
				if( con!= null) con.close();
				if( pstmt != null) pstmt.close();
				if( rs != null) rs.close();
			} catch (SQLException e) {e.printStackTrace();}
		}
	}
	
	public void update() {
		// 전달된 값으로 레코드를 수정하는 메서드
	}
	
	public void delete() {
		// 전달된 값으로 레코드를 삭제하는 메서드
	}
}
