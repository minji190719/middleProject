package kr.or.ddit.qna.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import kr.or.ddit.qna.dao.IQnaDao;
import kr.or.ddit.qna.dao.QnaDaoImpl;
import kr.or.ddit.qna.service.QnaServiceImpl;
import kr.or.ddit.qna.service.iQnaService;

@WebServlet("/QnaDelete.do")
public class QnaDelete extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		response.setContentType("application/x-www-form-urlencoded; charset=utf-8");
		
		
		iQnaService service = QnaServiceImpl.getInstance();
		
		Gson gson = new Gson();
		
		String qna_no = request.getParameter("qna_no");
		
		int result = service.deleteQna(qna_no);
		
		String rs = (result >= 1) ? "삭제 성공!" : "삭제 실패!";
		
		PrintWriter out = response.getWriter();
		
		out.write(rs);
		
		response.flushBuffer();
	}

}
