package kr.or.ddit.qna.controller;

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
import kr.or.ddit.vo.QnaVO;

/**
 * Servlet implementation class QnaList_prod
 */
@WebServlet("/QnaList_prod.do")
public class QnaList_prod extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		response.setContentType("application/json; charset=utf-8");
		String req_no = request.getParameter("req_no");
		
		System.out.println("QNA REQ_NO : " + req_no);
		iQnaService service = QnaServiceImpl.getInstance();
		
		Gson gson = new Gson();
		
		List<QnaVO> list = service.selectQna_prod(req_no);
		
		String jsonData = gson.toJson(list);
		
		PrintWriter out = response.getWriter();
		
		out.write(jsonData);
		
		response.flushBuffer();
	}

}
