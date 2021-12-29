package com.ezen.useservlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.swing.text.AbstractDocument.Content;

/**
 * Servlet implementation class Join_Servlet
 */
@WebServlet("/Join_Servlet")
public class Join_Servlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Join_Servlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		
		String id = request.getParameter("id");
		String pwd = request.getParameter("pwd");
		
		String gender = request.getParameter("gender");
		String [] item = request.getParameterValues("item");
		String chk_mail = request.getParameter("chk_mail");
		String content = request.getParameter("content");
		String job = request.getParameter("job");
		String [] interest = request.getParameterValues("interest");
		
		request.setAttribute("id",id);
		request.setAttribute("pwd",pwd);
		
		if(gender.equals("1")) request.setAttribute("gender", "남성");
		else request.setAttribute("gender", "여성");	
		
		if(chk_mail.equals("1")) request.setAttribute("mail", "수신");
		else request.setAttribute("mail", "거부");	

		if(!content.equals(""))request.setAttribute("content", content);
		else request.setAttribute("content","내용이 없습니다.");
		
		String [] sItem = new String [item.length];
		for(int i = 0 ; i < item.length; i++) {
			switch (item[i]) {
			case "1":sItem[i] = "신발"; break;
			case "2":sItem[i] = "가방"; break;
			case "3":sItem[i] = "벨트"; break;
			case "4":sItem[i] = "모자"; break;
			case "5":sItem[i] = "시계"; break;
			case "6":sItem[i] = "쥬얼리"; break;
			}
		}	//	전달된 파라미터 value 값들에 따른 상품명을 별도의 배열에 저장합니다
		//	작성된 배열을 request 에 items 라는 이름으로 저장합니다
		request.setAttribute("items", sItem);
		
		switch (job) {
		case "0":request.setAttribute("job", "무직"); break;
		case "1":request.setAttribute("job", "학생"); break;
		case "2":request.setAttribute("job", "컴퓨터/인터넷"); break;
		case "3":request.setAttribute("job", "언론"); break;
		case "4":request.setAttribute("job", "공무원"); break;
		case "5":request.setAttribute("job", "군인"); break;
		case "6":request.setAttribute("job", "서비스업"); break;
		}
		
		String [] sInterest = new String [interest.length];
		for(int i = 0 ; i < interest.length; i++) {
			switch (interest[i]) {
			case "1":sInterest[i] = "에스프레소"; break;
			case "2":sInterest[i] = "로스팅"; break;
			case "3":sInterest[i] = "생두"; break;
			case "4":sInterest[i] = "원두"; break;
			case "5":sInterest[i] = "핸드드립"; break;
			}
		}
		request.setAttribute("interests", sInterest);
		RequestDispatcher dp = request.getRequestDispatcher("02/112_JSP_Servlet_Ex02.jsp");
		dp.forward(request, response);
		/*if(id.equals("hong")&&pwd.equals("1234")) {
		}else response.sendRedirect("02/111_JSP_Servlet_Ex01.jsp");*/
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
