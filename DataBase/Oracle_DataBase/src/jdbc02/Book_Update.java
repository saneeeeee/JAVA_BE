package jdbc02;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class Book_Update {
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
			System.out.print("수정할 도서의 번호를 입력하세요 : ");
			String num = sc.nextLine();
			
			System.out.print("수정할 항목을 선택하세요. 1. 출판년도  2. 입고가격  3. 대여가격  4. 등급 : ");
			String input = sc.nextLine();
			
			String sql;
			switch (input) {
			case "1":
				System.out.print("수정할 년도를 입력하세요 : ");
				int makeyear = Integer.parseInt(sc.nextLine());
				sql = "Update booklist set makeyear = ? where num = ?";
				pstmt = con.prepareStatement(sql);
				pstmt.setInt(1, makeyear);
				pstmt.setInt(2, Integer.parseInt(num));
				break;
			case "2":
				System.out.print("수정할 입고가격을 입력하세요 : ");
				int inprice = Integer.parseInt(sc.nextLine());
				sql = "Update booklist set inprice = ? where num = ?";
				pstmt = con.prepareStatement(sql);
				pstmt.setInt(1, inprice);
				pstmt.setInt(2, Integer.parseInt(num));
				break;
			case "3":
				System.out.print("수정할 대여가격을 입력하세요 : ");
				int rentprice = Integer.parseInt(sc.nextLine());
				sql = "Update booklist set rentprice = ? where num = ?";
				pstmt = con.prepareStatement(sql);
				pstmt.setInt(1, rentprice);
				pstmt.setInt(2, Integer.parseInt(num));
			case "4":
				System.out.print("수정할 등급을 입력하세요 : ");
				String grade = sc.nextLine();
				sql = "Update booklist set grade = ? where num = ?";
				pstmt = con.prepareStatement(sql);
				pstmt.setString(1, grade);
				pstmt.setInt(2, Integer.parseInt(num));
				break;
			}
			
			int result = pstmt.executeUpdate();
			if(result == 1) System.out.println("레코드 수정 성공");
			else System.out.println("레코드 수정 실패");
			
		} catch (ClassNotFoundException e) {e.printStackTrace();}
		catch (SQLException e) {e.printStackTrace();}
		
		try {
			if( con!= null) con.close();
			if( pstmt != null) pstmt.close();
		} catch (SQLException e) {e.printStackTrace();}
	}
}
