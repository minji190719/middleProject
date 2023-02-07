package kr.or.ddit.review.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import kr.or.ddit.qna.service.QnaServiceImpl;
import kr.or.ddit.qna.service.iQnaService;
import kr.or.ddit.review.service.ReviewServiceImpl;
import kr.or.ddit.review.service.iReviewService;
import kr.or.ddit.vo.QnaVO;
import kr.or.ddit.vo.ReviewVO;

/**
 * Servlet implementation class ReviewDetail_prod
 */
@WebServlet("/ReviewDetail_prod.do")
public class ReviewDetail_prod extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		response.setContentType("application/x-www-form-urlencoded; charset=utf-8");
		
		iReviewService service = ReviewServiceImpl.getInstance();
		
		Gson gson = new Gson();
		
		String review_no = request.getParameter("review_no");
		System.out.println("review_no : " + review_no);
		
		ReviewVO vo = service.selectReview_review_no(review_no);
		
		String jsonData = gson.toJson(vo);
		System.out.println(jsonData);
		
		PrintWriter out = response.getWriter();
		
		out.write(jsonData);
		
		response.flushBuffer();
	}

}
