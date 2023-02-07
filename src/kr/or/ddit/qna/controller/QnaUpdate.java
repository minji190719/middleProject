package kr.or.ddit.qna.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;

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

@WebServlet("/QnaUpdate.do")
public class QnaUpdate extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		response.setContentType("application/x-www-form-urlencoded; charset=utf-8");
		String qna_no = request.getParameter("qna_no");
		
		iQnaService service = QnaServiceImpl.getInstance();
		Gson gson = new Gson();
		
		String column ="QNA_CONTENT";
		String data = request.getParameter("data");
		System.out.println("qna_no : " + qna_no);
		System.out.println("column : " + column);
		System.err.println("data : " + data);
		
		Map<String, Object> map = new HashMap<String, Object>();
		
		map.put("column", column);
		map.put("qna_no", qna_no);
		map.put("data", data);
		
		int result = service.updateQna(map);
		
		String str = (result >= 1) ? "수정 성공!" : "수정 실패!";
		
		PrintWriter out = response.getWriter();
		
		out.write(str);
		
		response.flushBuffer();
	}

}
