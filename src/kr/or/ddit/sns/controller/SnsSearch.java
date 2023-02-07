package kr.or.ddit.sns.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import kr.or.ddit.sns.service.ISnsService;
import kr.or.ddit.sns.service.SnsServiceImpl;
import kr.or.ddit.vo.SnsVO;

/**
 * Servlet implementation class SnsSearch
 */
@WebServlet("/snsSearch.do")
public class SnsSearch extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("오나");
		request.setCharacterEncoding("utf-8");
	    response.setCharacterEncoding("utf-8");
	    response.setContentType("application/json; charset=utf-8");
		
		String searchText = request.getParameter("search_box");
		System.out.println("검색어 : " + searchText);
		
		ISnsService service = SnsServiceImpl.getInstance();
		
		List<SnsVO> list = service.selectSns_prod_name(searchText);
		System.out.println(list); //여기까지 잘옴
		
		Gson gson = new Gson();
		
		String result = gson.toJson(list);
		System.out.println(result);
		PrintWriter out = response.getWriter();
		
		out.write(result);
		
		response.flushBuffer();
		
	}

}
