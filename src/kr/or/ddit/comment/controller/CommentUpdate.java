package kr.or.ddit.comment.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.google.gson.Gson;

import kr.or.ddit.comment.service.CommentSericeImpl;
import kr.or.ddit.comment.service.ICommentService;
import kr.or.ddit.vo.CommentVO;
import kr.or.ddit.vo.MemberVO;

/**
 * Servlet implementation class CommentUpdate
 */
@WebServlet("/commentUpdate.do")
public class CommentUpdate extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		response.setContentType("application/x-www-form-urlencoded; charset=utf-8");
		String comNo = request.getParameter("com_no");
		
		ICommentService service = CommentSericeImpl.getInstance();
		
		CommentVO vo = service.selectComment_com_no(comNo);
		
		String writer = vo.getMem_id();
		
		HttpSession session = request.getSession();
	      
	    MemberVO member = (MemberVO) session.getAttribute("member");
	        
	    String memId = member.getMem_id();
	    
	    Gson gson = new Gson();
	    
	    String jsonData = (writer.equals(memId)) ? "일치" : "불일치";
	    
		PrintWriter out = response.getWriter();
		
		out.write(jsonData);
		
		response.flushBuffer();
		
		
		
	}

}
