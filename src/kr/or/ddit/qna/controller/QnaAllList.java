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

import kr.or.ddit.qna.dao.IQnaDao;
import kr.or.ddit.qna.dao.QnaDaoImpl;
import kr.or.ddit.qna.service.QnaServiceImpl;
import kr.or.ddit.qna.service.iQnaService;
import kr.or.ddit.vo.QnaVO;

@WebServlet("/QnaAllList.do")
public class QnaAllList extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//request.getRequestDispatcher("test-jinho/qna_main.html").forward(request, response);
		request.getRequestDispatcher("view/page/qna/qna_main.jsp").forward(request, response);
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		response.setContentType("application/json; charset=utf-8");
		
		iQnaService service = QnaServiceImpl.getInstance();
		
		
		Gson gson = new Gson();
		
		List<QnaVO> list = service.selectAllQna();
		
		String jsonData = gson.toJson(list);
		
		PrintWriter out = response.getWriter();
		
		out.write(jsonData);
		
		response.flushBuffer();
	}
}
