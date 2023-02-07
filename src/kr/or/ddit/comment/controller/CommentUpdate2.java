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
 * Servlet implementation class CommentUpdate2
 */
@WebServlet("/commentUpdate2.do")
public class CommentUpdate2 extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		response.setContentType("application/x-www-form-urlencoded; charset=utf-8");
		String comNo = request.getParameter("com_no");
		String newValue = request.getParameter("com_content");
		
		Map<String, Object> map = new HashMap<String, Object>();
		
		map.put("data", newValue);
		map.put("com_no", comNo);
		map.put("column", "com_content");
		
		ICommentService service = CommentSericeImpl.getInstance();
		
		int result = service.updateComment(map);
		
		String jsonData = (result >= 1) ? "수정 성공!" : "수정 실패!";
		
	    Gson gson = new Gson();
	    
		PrintWriter out = response.getWriter();
		
		out.write(jsonData);
		
		response.flushBuffer();
	}

}
