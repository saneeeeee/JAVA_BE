package jdbc01;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class JDBC_Select {

	public static void main(String[] args) {
		String url = "jdbc:oracle:thin:@localhost:1521:xe";
		String driver = "oracle.jdbc.OracleDriver";
		String id = "scott";
		String pw = "tiger";
		
		Connection con = null;
		PreparedStatement pstmt = null;	//	con 에 SQL 실행해주는 객체
		ResultSet rs = null;					// SQL 실행결과를 저장하는 객체;
		
		try {
			Class.forName(driver);
			con = DriverManager.getConnection(url, id, pw);
			System.out.println("연결이 성공하였습니다.");
			
			String sql = "select * from customer";
			//	pstmt 에 sql 을 장착하고 실행해서, 그 결과를 rs 에 저장합니다.
			//	저장결과를 하나씩 레코드별로 필드별로 하나씩 꺼내서
			// 콘솔창에 출력합니다.
			
			
			
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			System.out.println("ojdbc6.jar 파일을 확인하세요.");
		}catch (SQLException e) {
			e.printStackTrace();
			System.out.println("연결 정보를 확인하세요.");
		}
		
		try {
			if( con!= null) con.close();
			if( pstmt != null) pstmt.close();
			if( rs != null) rs.close();
			System.out.println("데이터베이스 종료.");
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("연결이 종료되지 않았습니다.");
		}
	}

}
