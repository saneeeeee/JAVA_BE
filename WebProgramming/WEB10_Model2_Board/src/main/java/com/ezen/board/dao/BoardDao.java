package com.ezen.board.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.ezen.board.dto.BoardDto;
import com.ezen.board.util.Dbman;

public class BoardDao {
	private BoardDao() {};
	private static BoardDao itc = new BoardDao();
	public static BoardDao getInstance() {return itc;}
	
	Connection con = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;
	
	public ArrayList<BoardDto> selectBoard() {
		ArrayList<BoardDto> list = new ArrayList<>();
		String sql = "select * from board order by num desc";
		con = Dbman.getConnection();
		try {
			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				BoardDto bdto = new BoardDto();
				bdto.setNum(rs.getInt("num"));
				bdto.setUserid(rs.getString("userid"));
				bdto.setPass(rs.getString("pass"));
				bdto.setEmail(rs.getString("email"));
				bdto.setTitle(rs.getString("title"));
				bdto.setContent(rs.getString("content"));
				bdto.setReadcount(rs.getInt("readcount"));
				bdto.setWritedate(rs.getTimestamp("writedate"));
				list.add(bdto);
			}
		} catch (SQLException e) {e.printStackTrace();
		} finally {Dbman.close(con, pstmt, rs);}
		
		return list;
	}

	public void plusReadCount(int num) {
		String sql = "update board set readcount = readcount +1 where num = ?";
		
		con = Dbman.getConnection();
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, num);
			pstmt.executeUpdate();
		} catch (SQLException e) {e.printStackTrace();
		} finally {Dbman.close(con, pstmt, rs);}
	}

	public BoardDto getBoard(int num) {
		BoardDto bdto = new BoardDto();
		String sql = "select * from board where num = ?";
		con = Dbman.getConnection();
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, num);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				bdto.setNum(rs.getInt("num"));
				bdto.setUserid(rs.getString("userid"));
				bdto.setPass(rs.getString("pass"));
				bdto.setEmail(rs.getString("email"));
				bdto.setTitle(rs.getString("title"));
				bdto.setContent(rs.getString("content"));
				bdto.setWritedate(rs.getTimestamp("writedate"));
				bdto.setReadcount(rs.getInt("readcount"));
			}
		} catch (SQLException e) {e.printStackTrace();
		} finally {Dbman.close(con, pstmt, rs);}
		
		return bdto;
	}

	public int writeBoard(BoardDto bdto) {
		int result = 0;
		String sql = "insert into board(num,userid,pass,email,title,content) "
				+ " values(board_seq.nextVal, ? , ? , ? , ? , ?)";
		
		con = Dbman.getConnection();
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, bdto.getUserid());
			pstmt.setString(2, bdto.getPass());
			pstmt.setString(3, bdto.getEmail());
			pstmt.setString(4, bdto.getTitle());
			pstmt.setString(5, bdto.getContent());
			
			result = pstmt.executeUpdate();
		} catch (SQLException e) {e.printStackTrace();
		} finally {Dbman.close(con, pstmt, rs);}
		
		return result;
	}
	
}