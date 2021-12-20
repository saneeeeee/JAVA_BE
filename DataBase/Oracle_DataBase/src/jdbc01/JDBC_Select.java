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
			//System.out.println("연결이 성공하였습니다.");
			String sql = "select * from customer";
			// 데이터베이스 연결 후에는 SQL 명령을 사용하기 위해 String 변수에 SQL 명령을
			// 준비합니다. 데이터 베이스에 제공되어질 명령이므로 String 형으로 준비합니다
			
			// SQL 문을 장착한 con 을 pstmt 에 전달합니다
			pstmt = con.prepareStatement(sql);
			//	pstmt = con.prepareStatement("select * from customer");
			
			//	pstmt 에 담겨진 SQL 명령 실행하고 그 결과를 rs에 저장합니다.
			rs = pstmt.executeQuery();

			System.out.println("번호 \t 이름 \t\t\t 이메일 \t\t 전화번호");
			System.out.println("--------------------------------------------------------------");
			//	rs.next() : 최초 실행은 객체의 시작부분(데이터 없는곳)에서 첫번째 레코드로 이동하는 메서드.
			//	그 다음부터는 다음 레코드로 이동.
			//	rs.next() 메서드가 실행되 때 다음 레코드가 있으면 true, 없으면 false를 리턴
			
			while(rs.next()) {
				//	결과의 처음부터 끝까지 반복실행 : 레코드 단위로 반복 실행
				//	rs.getInt() : number 형 필드값을 추출하는 메서드. 괄호안에 필드이름을 정확히
				//	써야합니다. 문자형 자료는 getString()을 이용합니다
				//	필드명에 오타가 있거나 안맞으면 부적합한 열이름 이라는 에러가 발생합니다.
				int num = rs.getInt("num");
				//	rs.getString() : varchar2 형 필드값을 추출하는 메서드
				//	모든 자료형에 대해 get~() 메서드가 모두 존재합니다
				String name = rs.getString("name");
				String email = rs.getString("email");
				String tel = rs.getString("tel");
				System.out.printf("%d \t %s \t %16s \t %s\n",num,name,email,tel);
			}
			
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
			//System.out.println("데이터베이스 종료.");
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("연결이 종료되지 않았습니다.");
		}
	}
}
