package jdbc02;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class Book_Insert {

	public static void main(String[] args) {
		String url = "jdbc:oracle:thin:@localhost:1521:xe";
		String driver = "oracle.jdbc.OracleDriver";
		String id = "scott";
		String pw = "tiger";
		Connection con = null;
		PreparedStatement pstmt = null;
		try {
			Class.forName(driver);
			con = DriverManager.getConnection(url, id, pw);

			Scanner sc = new Scanner(System.in);
			
			System.out.println("제목을 입력하세요 : ");
			String subject = sc.nextLine();
			System.out.println("출판년도 입력하세요 : ");
			int makeyear = Integer.parseInt(sc.nextLine());
			System.out.println("입고가격을 입력하세요 : ");
			int inprice = Integer.parseInt(sc.nextLine());
			System.out.println("출고가격 입력하세요 : ");
			int rentprice = Integer.parseInt(sc.nextLine());
			System.out.println("등급 입력하세요 : ");
			String grade = sc.nextLine();

			// 아래가 요즘 방식
			String sql = "insert into booklist values( book_seq.nextVal, ?, ? , ? , ? , ? )";

			// 먼저 sql 명령을 select 때와 같이 pstmt 에 장착합니다.
			pstmt = con.prepareStatement(sql);

			// ? 의 순서에 맞춰서 입력값들을 세팅합니다
			// pstmt.setInt(1, num);
			pstmt.setString(1, subject);
			pstmt.setInt(2, makeyear);
			pstmt.setInt(3, inprice);
			pstmt.setInt(4, rentprice);
			pstmt.setString(5, grade);

			// SQL select 명령만 excuteQuery 를 사용하고,
			// 나머지는 excuteUpdate 메서드를 사용합니다
			// excuteUpdate의 결과는 sql 명령이 정상 동작했을때 1, 실패했을때 0 이 리턴됩니다
			int result = pstmt.executeUpdate();
			if (result == 1)
				System.out.println("레코드 추가 성공");
			else
				System.out.println("레코드 추가 실패");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		try {
			if (con != null)
				con.close();
			if (pstmt != null)
				pstmt.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
