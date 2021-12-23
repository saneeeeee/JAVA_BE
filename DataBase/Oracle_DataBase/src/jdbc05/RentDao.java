package jdbc05;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import jdbc04.MemberDto;

public class RentDao {

	private RentDao() {}
	private static RentDao itc = new RentDao();
	public static RentDao getInstance() {return itc;}
	
	Connection con = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;
	
	public ArrayList<RentDto> select() {
		ArrayList<RentDto> list = new ArrayList<RentDto>();
		con = DBM.getConnection();
		//	테이블의 rentdate 필드 : Date 형식 -> Dto 의 rentDate : String 으로 변환해서 저장
		//	select 문안에서 to_char() 함수가 사용이 되야 가능합니다.
		String sql = "select to_char(rentdate, 'YYYY-MM-DD') as rentdate, num, booknum, membernum, discount from rentlist order by num desc";
		try {
			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();	
			while( rs.next() ) {
				RentDto rdto = new RentDto();
				rdto.setRentdate(rs.getString("rentdate"));
				rdto.setNum(rs.getInt("num"));
				rdto.setBooknum(rs.getInt("booknum"));
				rdto.setMembernum(rs.getInt("membernum"));
				rdto.setDiscount(rs.getInt("discount"));
				list.add( rdto );
			}	
		} catch (SQLException e) { e.printStackTrace();
		} finally { DBM.close(con, pstmt, rs);}
		return list;
	};
	
	public int insert(RentDto rdto) {
		int result = 0;
		con = DBM.getConnection();
		String sql = "insert into rentlist values(sysdate, rent_seq.nextVal, ?, ?, ?)";
		try {
			pstmt = con.prepareStatement(sql);
			
			pstmt.setInt(1,  rdto.getBooknum() );
			pstmt.setInt(2,  rdto.getMembernum() );
			pstmt.setInt(3,  rdto.getDiscount() );
			
			result = pstmt.executeUpdate();
		} catch (SQLException e) { e.printStackTrace();
		} finally {	DBM.close(con, pstmt, rs);}
		return result;
	};
	
	public RentDto getRent(int num) {
		RentDto rdto = null;
		con = DBM.getConnection();
		String sql = "select to_char(rentdate, 'YYYY-MM-DD') as rentdate, num, booknum, membernum, discount from rentlist where num = "+num;
		try {
			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();	
			if( rs.next() ) {
				rdto = new RentDto();
				rdto.setRentdate(rs.getString("rentdate"));
				rdto.setNum(rs.getInt("num"));
				rdto.setBooknum(rs.getInt("booknum"));
				rdto.setMembernum(rs.getInt("membernum"));
				rdto.setDiscount(rs.getInt("discount"));
			}	
		} catch (SQLException e) { e.printStackTrace();
		} finally { 
			DBM.close(con, pstmt, rs);
			}
		return rdto;
	};
	
	public int update(RentDto rdto) {
		int result = 0;
		con = DBM.getConnection();
		
		String sql = "update rentlist set rentdate=to_date(''||?||'','yyyy-MM-DD'), booknum = ?, membernum = ?, discount = ? where num = ?";
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, rdto.getRentdate() );
			pstmt.setInt(2, rdto.getBooknum());
			pstmt.setInt(3, rdto.getMembernum());
			pstmt.setInt(4, rdto.getDiscount());
			pstmt.setInt(5, rdto.getNum());
			
			result = pstmt.executeUpdate();
		} catch (SQLException e) { e.printStackTrace();
		} finally {
			DBM.close(con, pstmt, rs);
		}
		return result;
	};
	
	public int delete(int num) {
		int result = 0;
		con = DBM.getConnection();
		String sql = "delete from rentlist where num = "+num;
		try {
			pstmt = con.prepareStatement(sql);
			result = pstmt.executeUpdate();
		} catch (SQLException e) { e.printStackTrace();
		} finally {
			DBM.close(con, pstmt, rs);
		}
		return result;
	}

	public boolean checkBooknum(int booknum) {
		boolean result = false;
		con = DBM.getConnection();
		String sql = "select * from booklist where num = " + booknum;
		try {
			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();	
			if( rs.next() ) result = true;	
		} catch (SQLException e) { e.printStackTrace();
		} finally { DBM.close(con, pstmt, rs);}
		return result;
	}

	public boolean checkMembernum(int membernum) {
		boolean result = false;
		con = DBM.getConnection();
		String sql = "select * from memberlist where num = "+ membernum;
		try {
			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();	
			if( rs.next() ) result = true;
		} catch (SQLException e) { e.printStackTrace();
		} finally { DBM.close(con, pstmt, rs);}
		return result;
	}

	public ArrayList<RentDetailDto> selectAll() {
		ArrayList<RentDetailDto> list = new ArrayList<RentDetailDto>();
		con = DBM.getConnection();
		String sql = "select * from rentdetail";
		
		try {
			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();	
			while(rs.next()) {
				
				RentDetailDto rdd = new RentDetailDto();
				rdd.setRentdate(rs.getString("rentdate"));
				rdd.setRentnum(rs.getInt("rentnum"));
				rdd.setMembernumber(rs.getInt("membernumber"));
				rdd.setMembername(rs.getString("membername"));
				rdd.setPrice(rs.getInt("price"));
				rdd.setBooknum(rs.getInt("booknumber"));
				rdd.setSubject(rs.getString("subject"));
				list.add( rdd );
			}
		} catch (SQLException e) { e.printStackTrace();
		} finally { DBM.close(con, pstmt, rs);}
	
		return list;
	};
}
