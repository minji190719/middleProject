package kr.or.ddit.prod.controller;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
 * Servlet implementation class ProdLsit
 */
@WebServlet("/prodList2.do")
public class ProdLsit2 extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		request.setCharacterEncoding("utf-8");
		IProdService service = ProdServiceImpl.getInstance();
		
		
		String lprod_gu =  request.getParameter("lprod_gu");
		String prod_purpose = request.getParameter("prod_purpose");
		
		ProdVO vo = new ProdVO();
		
		vo.setLprod_gu(lprod_gu);
		vo.setProd_purpose(prod_purpose);
		
		List<ProdVO> plist = service.selectProd_lprod_gu2(vo);
		System.out.println("plist확인 : " + plist);
		request.setAttribute("plist", plist);
		request.setAttribute("lprod_gu", lprod_gu);
		request.setAttribute("prod_purpose", prod_purpose);

		
		request.getRequestDispatcher("/jhs/prodList.jsp").forward(request, response);
		
	
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
