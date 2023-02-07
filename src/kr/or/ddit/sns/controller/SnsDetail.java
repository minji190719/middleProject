package kr.or.ddit.sns.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import kr.or.ddit.qna.service.QnaServiceImpl;
import kr.or.ddit.qna.service.iQnaService;
import kr.or.ddit.sns.service.ISnsService;
import kr.or.ddit.sns.service.SnsServiceImpl;
import kr.or.ddit.vo.QnaVO;
import kr.or.ddit.vo.SnsVO;

/**
 * Servlet implementation class SnsDetail
 */
@WebServlet("/snsDetail.do")
public class SnsDetail extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		String sns_no = request.getParameter("sns_no");
		/*
		 * ISnsService service = SnsServiceImpl.getInstance();
		 * 
		 * SnsVO snsvo = service.selectSns_no(sns_no);
		 * 
		 * request.setAttribute("snsvo", snsvo);
		 */
		//디테일 페이지로만 넘겨줌
		RequestDispatcher rd = request.getRequestDispatcher("view/page/sns/sns_detail.jsp?sns_no=" + sns_no);
		
		rd.forward(request, response);
	
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		response.setContentType("application/x-www-form-urlencoded; charset=utf-8");
		
		ISnsService service = SnsServiceImpl.getInstance();
		
		Gson gson = new Gson();
		
		String sns_no = request.getParameter("sns_no");
		
		SnsVO vo = service.selectSns_no(sns_no);
		int count = vo.getSns_count();
		
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("column", "sns_count");
		map.put("data", count+1);
		map.put("sns_no", sns_no);
		int result = service.updateSns(map); //조회수 증가
		
		String jsonData = gson.toJson(vo);
	
		PrintWriter out = response.getWriter();
		
		out.write(jsonData);
		
		response.flushBuffer();
	}

}
