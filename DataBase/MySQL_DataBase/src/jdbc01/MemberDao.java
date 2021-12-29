package jdbc01;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.mysql.cj.x.protobuf.MysqlxConnection.Close;
import com.mysql.cj.x.protobuf.MysqlxCrud.Delete;
import com.mysql.cj.x.protobuf.MysqlxCrud.Insert;

public class MemberDao {
	
	Connection con = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;
	
	private MemberDao() {}
	private static MemberDao itc = new MemberDao();
	public static MemberDao getInstance() {return itc;}
	
	
	public ArrayList<MemberDto> select(){
		ArrayList<MemberDto> list = new ArrayList<>();
		String sql = "select num,name,phone,date_format(birth, '%Y-%m-%d') as birth,bpoint,date_format(joindate, '%Y-%m-%d') as joindate,gender,age from `scott`.`memberlist` order by num desc";
		con = DBM_MySQL.getConnection();
		try {
			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				MemberDto mdto = new MemberDto();
				mdto.setNum( rs.getInt("num") );
				mdto.setName( rs.getString("name") );
				mdto.setPhone( rs.getString("phone") );
				mdto.setBirth( rs.getString( "birth") );
				mdto.setBpoint( rs.getInt("bpoint") );
				mdto.setJoindate( rs.getString("joindate") );
				mdto.setGender( rs.getString("gender") );
				mdto.setAge( rs.getInt("age") );
				list.add( mdto );
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			DBM_MySQL.close(con,pstmt,rs);
		}
		return list;
	}
	
	public int insert(MemberDto mdto){
		String sql = "insert into memberlist(name,phone,birth,age,gender) values(?,?,str_to_date(concat('',?,''), '%Y-%m-%d'),?,?)";
		int result = 0;
		con = DBM_MySQL.getConnection();
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, mdto.getName());
			pstmt.setString(2, mdto.getPhone());
			pstmt.setString(3, mdto.getBirth());
			pstmt.setInt(4, mdto.getAge());
			pstmt.setString(5, mdto.getGender());
			
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			DBM_MySQL.close(con,pstmt,rs);
		}
		return result;
	}
	
	public int update(MemberDto mdto){
		int result = 0;
		String sql = "update `scott`.`memberlist` set name = ? , phone = ? , birth = str_to_date(concat('', ? ,''),'%Y-%m-%d'), bpoint = ? , age = ? , gender = ? , joindate = str_to_date(concat('', ? ,''),'%Y-%m-%d') where num = "+mdto.getNum();
		con = DBM_MySQL.getConnection();
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, mdto.getName());
			pstmt.setString(2, mdto.getPhone());
			pstmt.setString(3, mdto.getBirth());
			pstmt.setInt(4, mdto.getBpoint());
			pstmt.setInt(5, mdto.getAge());
			pstmt.setString(6, mdto.getGender());
			pstmt.setString(7, mdto.getJoindate());
			
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			DBM_MySQL.close(con,pstmt,rs);
		}
		return result;
	}
	
	public int delete(int num){
		int result = 0;
		String sql = "delete from `scott`.`memberlist` where num = "+num;
		con = DBM_MySQL.getConnection();
		try {
			pstmt = con.prepareStatement(sql);
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			DBM_MySQL.close(con,pstmt,rs);
		}
		return result;
	}
	
	public MemberDto getMember(int num){
		MemberDto mdto = new MemberDto();
		String sql = "select num,name,phone,date_format(birth, '%Y-%m-%d') as birth,bpoint,date_format(joindate, '%Y-%m-%d') "
				+ " as joindate,gender,age from `scott`.`memberlist` where num = " + num;
		con = DBM_MySQL.getConnection();
		try {
			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				mdto.setNum(rs.getInt("num"));
				mdto.setName( rs.getString("name") );
				mdto.setPhone( rs.getString("phone") );
				mdto.setBirth( rs.getString( "birth") );
				mdto.setBpoint( rs.getInt("bpoint") );
				mdto.setJoindate( rs.getString("joindate") );
				mdto.setGender( rs.getString("gender") );
				mdto.setAge( rs.getInt("age") );
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			DBM_MySQL.close(con,pstmt,rs);
		}
		return mdto;
	}
}
