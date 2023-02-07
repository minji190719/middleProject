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
@WebServlet("/prodList.do")
public class ProdLsit extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		request.setCharacterEncoding("utf-8");
		IProdService service = ProdServiceImpl.getInstance();
		
		
//		String lprod_gu = request.getParameter("lprod_gu"); //jsp name 가져오겟지?
		String lprod_gu =  request.getParameter("lprod_gu");
		System.out.println("헤더에서 데이터 들어오나유" +lprod_gu);
		List<ProdVO> plist = service.selectProd_lprod_gu(lprod_gu);
		System.out.println("plist확인 : " + plist);
		request.setAttribute("plist", plist);
		request.setAttribute("lprod_gu", lprod_gu);
		
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
