package kr.or.ddit.prod.controller;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.or.ddit.prod.service.IProdService;
import kr.or.ddit.prod.service.ProdServiceImpl;
import kr.or.ddit.vo.ProdVO;

@WebServlet("/prodList2_color.do")
public class ProdList2_color extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String lprod_gu = request.getParameter("lprod_gu");
		String prod_color = request.getParameter("prod_color");
		String prod_purpose = request.getParameter("prod_purpose");
		
		System.out.println(lprod_gu);
		System.out.println(prod_color);
		System.out.println("퍼포즈 : " + prod_purpose);
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("lprod_gu", lprod_gu);
		map.put("prod_color", prod_color);
		map.put("prod_purpose", prod_purpose);
		
		IProdService service = ProdServiceImpl.getInstance();
		List<ProdVO> plist_color = service.selectProd_lprod_gu_color(map);
		System.out.println(plist_color);
		request.setAttribute("plist", plist_color);
		request.setAttribute("lprod_gu", lprod_gu);
		request.setAttribute("prod_color", prod_color);
		request.setAttribute("prod_purpose", prod_purpose);
		
		request.getRequestDispatcher("/jhs/prodList_color.jsp").forward(request, response);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
