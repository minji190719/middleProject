package kr.or.ddit.returns.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.or.ddit.returns.service.IReturnsService;
import kr.or.ddit.returns.service.ReturnsServiceImpl;

/**
 * Servlet implementation class ReturnsDelete
 */
@WebServlet("/returnsDelete.do")
public class ReturnsDelete extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
	    response.setCharacterEncoding("utf-8");
	    response.setContentType("application/x-www-form-urlencoded; charset=utf-8");
	    
	    String returns_no = request.getParameter("returns_no");
	    
	    IReturnsService service = ReturnsServiceImpl.getInstance();
	    
	    int result = service.deleteReturns(returns_no);
	    
	    String str = (result >= 1) ? "삭제 성공!" : "삭제 실패!";
	    
    	PrintWriter out = response.getWriter();
		
		out.write(str);
		
		response.flushBuffer();
	    
	}

}
