package kr.or.ddit.prod.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.or.ddit.prod.service.IProdService;
import kr.or.ddit.prod.service.ProdServiceImpl;
import kr.or.ddit.vo.ProdVO;

/**
 * Servlet implementation class ShowProd
 */
@WebServlet("/showProd.do")
public class ShowProd extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		String prod_id = request.getParameter("prod_id");
		
		
		
		IProdService service = ProdServiceImpl.getInstance();
		ProdVO pvo= service.selectProd_prod_id(prod_id);
		
		switch (pvo.getLprod_gu()) {
		case "sh100_M":
				pvo.setLprod_name("남성 신발");
			break;
		case "cl100_M":
				pvo.setLprod_name("남성 의류");
			break;
		case "ac100_M":
				pvo.setLprod_name("남성 악세사리");
			break;
		case "sh100_F":
				pvo.setLprod_name("여성 신발");
			break;
		case "cl100_F":
				pvo.setLprod_name("여성 의류");
			break;
		case "ac100_F":
				pvo.setLprod_name("여성 악세사리");
			break;
		}
		
		request.setAttribute("pvo", pvo);
		System.out.println("pvo확인:" +pvo.getProd_id());
		System.out.println("pvo확인:" +pvo.getLprod_gu());
		request.getRequestDispatcher("jhs/showProd.jsp").forward(request, response);
		
	
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
