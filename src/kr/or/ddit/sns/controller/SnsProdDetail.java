package kr.or.ddit.sns.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.or.ddit.prod.service.IProdService;
import kr.or.ddit.prod.service.ProdServiceImpl;
import kr.or.ddit.vo.ProdVO;

/**
 * Servlet implementation class SnsProdDetail
 */
@WebServlet("/snsProdDetail.do")
public class SnsProdDetail extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("데이터 오냐구ㅠ");
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
//		response.setContentType("application/x-www-form-urlencoded; charset=utf-8");
		String prodName = request.getParameter("prod_name");

		IProdService service = ProdServiceImpl.getInstance();
		ProdVO pvo= service.selectProd_prod_name(prodName);
		
		request.setAttribute("pvo", pvo);
//		System.out.println("pvo확인:" + pvo.getProd_id());
//		System.out.println("pvo확인:" + pvo.getLprod_gu());
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
