package kr.or.ddit.comment.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
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
 * Servlet implementation class CommentInsert
 */
@WebServlet("/CommentInsert.do")
public class CommentInsert extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		String sns_no = request.getParameter("sns_no");
		
		RequestDispatcher rd = request.getRequestDispatcher("view/page/sns/sns_detail.jsp?sns_no=" + sns_no);
		
		rd.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("데이터 오니..?");
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		response.setContentType("application/x-www-form-urlencoded; charset=utf-8");
		String sns_no = request.getParameter("sns_no");
//		String comNo = request.getParameter("com_no");
		String comContent = request.getParameter("com_content");
//		String boardNo = request.getParameter("board_no");
		
		HttpSession session = request.getSession();
	      
	    MemberVO member = (MemberVO) session.getAttribute("member");
	        
		String jsonData = "";
	    
	    if (member == null) {
	    	jsonData = "로그인을 해주세요.";

	    } else {
		    String memId = member.getMem_id();
			CommentVO comvo = new CommentVO();
			
			comvo.setMem_id(memId);
			comvo.setCom_content(comContent);
			comvo.setBoard_no(sns_no);
			
			ICommentService service = CommentSericeImpl.getInstance();
			
			int cnt = service.insertComment(comvo);
			
			jsonData = (cnt >= 1) ? "댓글이 등록되었습니다." : "작성 실패";
	    }
		
		
		PrintWriter out = response.getWriter();
		
		out.write(jsonData);
		
		response.flushBuffer();

	}

}
