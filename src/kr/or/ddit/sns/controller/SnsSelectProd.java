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

import kr.or.ddit.prod.service.IProdService;
import kr.or.ddit.prod.service.ProdServiceImpl;

import kr.or.ddit.vo.ProdVO;


/**
 * Servlet implementation class SnsSelectProd
 */
@WebServlet("/snsSelectProd.do")
public class SnsSelectProd extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		System.out.println("넘어와?");
//		
//		response.setCharacterEncoding("utf-8");
//		
//		IProdService service = ProdServiceImpl.getInstance();
//		
//		List<ProdVO> list = service.selectAllProd();
//		
//		JsonObject job = new JsonObject();
//	      
//	      Gson gson = new Gson();
//	      
//	      JsonElement element = gson.toJsonTree(list);
//	      
//	      job.add("list", element);
//	      
//	      PrintWriter out = response.getWriter();
//	      
//	      out.print(job);
		
		doPost(request, response);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		  request.setCharacterEncoding("utf-8");
	      response.setCharacterEncoding("utf-8");
	      response.setContentType("application/json; charset=utf-8");
	      
	      IProdService service = ProdServiceImpl.getInstance();
	      
	      List<ProdVO> list = service.selectAllProd();
	      
	      Gson gson = new Gson();
	      
	      String jsonData = gson.toJson(list);
	      
	      PrintWriter out = response.getWriter();
	      
	      out.write(jsonData);
	      
	      response.flushBuffer();
	}

}
