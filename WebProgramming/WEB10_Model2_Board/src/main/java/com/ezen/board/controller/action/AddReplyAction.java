package com.ezen.board.controller.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ezen.board.dao.BoardDao;
import com.ezen.board.dto.ReplyDto;

public class AddReplyAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ReplyDto rdto = new ReplyDto();
		
		int boardnum = Integer.parseInt(request.getParameter("boardnum"));
		rdto.setBoardnum(boardnum);
		rdto.setUserid(request.getParameter("userid"));
		rdto.setContent(request.getParameter("content"));
		
		BoardDao bdao = BoardDao.getInstance();
		
		bdao.insertReply(rdto);
		
		response.sendRedirect("board.do?command=boardViewWithoutCount&num="+boardnum);
	}
	
	
}