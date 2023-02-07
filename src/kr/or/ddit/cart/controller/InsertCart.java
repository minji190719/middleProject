package kr.or.ddit.cart.controller;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import kr.or.ddit.cart.dao.CartDaoImpl;
import kr.or.ddit.cart.service.CartServiceImpl;
import kr.or.ddit.cart.service.ICartService;
import kr.or.ddit.prod.service.IProdService;
import kr.or.ddit.prod.service.ProdServiceImpl;
import kr.or.ddit.salesrequest.service.ISalesRequestService;
import kr.or.ddit.salesrequest.service.SalesRequestServiceImpl;
import kr.or.ddit.vo.CartVO;
import kr.or.ddit.vo.MemberVO;
import kr.or.ddit.vo.ProdVO;
import kr.or.ddit.vo.SalesRequestVO;

/**
 * Servlet implementation class InsertCart
 */
@WebServlet("/insertCart.do")
public class InsertCart extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		request.setCharacterEncoding("utf-8");
		
		HttpSession session = request.getSession(false);
		
		MemberVO member = (MemberVO)session.getAttribute("member");
		
		int res =0;
		
		if(member==null) {		
			request.setAttribute("result", 0);
			
			request.getRequestDispatcher("jhs/result.jsp").forward(request, response);
			
		}else {			
			
		
		String mem_id = member.getMem_id();
		
		System.out.println("멤버아이디 확인: "+mem_id);
		
		
		String prod_id = request.getParameter("prod_id");
		System.out.println("prod_id 확인 : " + prod_id.substring(0, 1));
		
		
///////////////////////////////// 중고품일 경우		
		if(prod_id.substring(0, 1).equals("U")) { 
			
			String prod_name = request.getParameter("prod_name");
			int prod_price = Integer.parseInt(request.getParameter("prod_price"));
			System.out.println("memid확인:" + mem_id );
			System.out.println("prod_id확인:" + prod_id );
			System.out.println("prod_name확인:" + prod_name );
			System.out.println("prod_price확인:" + prod_price );
			
			ICartService cservice = CartServiceImpl.getInstance();
			
			SalesRequestVO vo = new SalesRequestVO();
			
			ISalesRequestService sservice = SalesRequestServiceImpl.getInstance();
			vo = sservice.selectSalesRequest_req_no(prod_id);
			
//			vo.setReq_no(prod_id);
			vo.setMem_id(mem_id);
//			vo.setOrigin_name(prod_name);
//			vo.setReq_price(prod_price);
			

			res = cservice.insertCart2(vo);
			
			
			
////////////////////////////////////////새상품일 경우	
		}else {  
			String size = request.getParameter("size");
			
			System.out.println("사이즈 : " + size);
			
			String prod_name = request.getParameter("prod_name");
			int prod_price = Integer.parseInt(request.getParameter("prod_price"));
			System.out.println("memid확인:" + mem_id );
			ICartService cservice = CartServiceImpl.getInstance();
			
			Map<String, String> map = new HashMap<String, String>();
			map.put("prod_id", prod_id);
			map.put("mem_id", mem_id);
			map.put("prod_size", size);
			
			CartVO vo = new CartVO();
			CartVO vo2 = new CartVO();//insert 시 null 포인터 방지용 객체 생성
			vo.setProd_name(prod_name);
			vo.setProd_price(prod_price);
			
			vo = cservice.selectCart2(map);
			
			System.out.println("cart 인서트 vo 확인 :"  +  vo);
			if(vo==null) {
				vo2.setCart_qty(1);
				vo2.setCart_status("0");
				vo2.setProd_id(prod_id);
				vo2.setProd_size(size);
				vo2.setMem_id(mem_id);
				vo2.setProd_name(prod_name);
				vo2.setProd_price(prod_price);
				res = cservice.insertCart(vo2);
			}else {
				res = cservice.updateCart3(map);
			}
			
		} // 중고, 새상품 if 구분
		
		request.setAttribute("result", res);
		
		request.getRequestDispatcher("/jhs/result.jsp").forward(request, response);
		
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setCharacterEncoding("utf-8");
		
		String cart_no = request.getParameter("cart_no");
		int cart_qty = Integer.parseInt(request.getParameter("cart_qty"));
		
		System.out.println("카트번호:" + cart_no+"카트 수량:"+cart_qty);
		
		
		
		ICartService cservice = CartServiceImpl.getInstance();
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("cart_no", cart_no);
		map.put("cart_qty", cart_qty);
		
		int res = cservice.updateCart5(map);
		
		request.setAttribute("result", res);
		
		request.getRequestDispatcher("/jhs/result.jsp").forward(request, response);
		
	}

}
