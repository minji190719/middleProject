package kr.or.ddit.comment.controller;

import java.io.IOException;
import java.io.PrintWriter;

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
 * Servlet implementation class CommentDelete
 */
@WebServlet("/CommentDelete.do")
public class CommentDelete extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		response.setContentType("application/x-www-form-urlencoded; charset=utf-8");
		String com_no = request.getParameter("com_no");
		
		ICommentService service = CommentSericeImpl.getInstance();
		//1. 게시글의 아이디를 먼저 찾는다.
		CommentVO vo = service.selectComment_com_no(com_no);
		
		String writer = vo.getMem_id();
		
		
		//2. 세션의 아이디값과 비교한다.
		String jsonData = "";
		HttpSession session = request.getSession();
	      
	    MemberVO member = (MemberVO) session.getAttribute("member");
	    
	    if (member == null) {
	    	jsonData = "로그인을 해주세요.";
	    	
	    } else {
	    	String memId = member.getMem_id();
	    	
	    	//3. 같으면 삭제하고, 아이디가 다르면 삭제할 수 없다.
	    	
	    	if (writer.equals(memId) || memId.equals("ADMIN")) {
	    		int result = service.deleteComment(com_no);
	    		
	    		jsonData = (result >= 1) ? "댓글 삭제 성공!" : "댓글 삭제 실패!";
	    		
	    	} else {
	    		jsonData = "본인이 작성한 댓글만 지울 수 있습니다.";
	    	}
	    	
	    }
		
		PrintWriter out = response.getWriter();
		
		out.write(jsonData);
		
		response.flushBuffer();
		
	}

}
