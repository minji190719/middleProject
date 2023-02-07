package kr.or.ddit.comment.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import kr.or.ddit.comment.service.CommentSericeImpl;
import kr.or.ddit.comment.service.ICommentService;
import kr.or.ddit.vo.CommentVO;

/**
 * Servlet implementation class CommentList
 */
@WebServlet("/commentList.do")
public class CommentList extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		String sns_no = request.getParameter("sns_no");
		
		RequestDispatcher rd = request.getRequestDispatcher("view/page/sns/sns_detail.jsp?sns_no=" + sns_no);
		
		rd.forward(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("댓글 리스트 데이터 넘어와?");
		
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		response.setContentType("application/x-www-form-urlencoded; charset=utf-8");
		
		ICommentService service = CommentSericeImpl.getInstance();
		
		Gson gson = new Gson();
		
		String board_no = request.getParameter("sns_no");
		
		System.out.println(board_no);
		
		List<CommentVO> list = service.selectCommentBoardNo(board_no);
		
		String jsonData = gson.toJson(list);
		
		PrintWriter out = response.getWriter();
		
		out.write(jsonData);
		
		response.flushBuffer();
	}

}
