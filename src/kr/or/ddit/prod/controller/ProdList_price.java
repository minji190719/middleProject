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

@WebServlet("/prodList_price.do")
public class ProdList_price extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		String lprod_gu = request.getParameter("lprod_gu");
		String prod_price = request.getParameter("prod_price");
		
		System.out.println("gu뭐야 : " + lprod_gu);
		System.out.println(prod_price);
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("lprod_gu", lprod_gu);
		int lownum = 0;
		int highnum = 0;
		
		switch (prod_price) {
		case "100":
			lownum = 50000;
			highnum = 100000;
			break;
			
		case "150":
			lownum = 100000;
			highnum = 150000;
			break;
			
		case "200":
			lownum = 150000;
			highnum = 200000;
			break;
			
		case "250":
			lownum = 200000;
			highnum = 100000000;
			break;
		
		}
		
		map.put("lownum", lownum);
		map.put("highnum", highnum);
		
		
		IProdService service = ProdServiceImpl.getInstance();
		List<ProdVO> plist_price = service.selectProd_lprod_gu_price(map);
		System.out.println(plist_price);
		request.setAttribute("plist", plist_price);
		request.setAttribute("lprod_gu", lprod_gu);
		request.setAttribute("prod_price", prod_price);
		
		request.getRequestDispatcher("/jhs/prodList_price_all.jsp").forward(request, response);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
