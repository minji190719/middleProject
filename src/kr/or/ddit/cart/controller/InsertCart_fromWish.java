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

import kr.or.ddit.cart.service.CartServiceImpl;
import kr.or.ddit.cart.service.ICartService;
import kr.or.ddit.prod.service.IProdService;
import kr.or.ddit.prod.service.ProdServiceImpl;
import kr.or.ddit.vo.CartVO;
import kr.or.ddit.vo.MemberVO;
import kr.or.ddit.vo.ProdVO;
import kr.or.ddit.vo.WishVO;
import kr.or.ddit.wish.service.IWishService;
import kr.or.ddit.wish.service.WishServiceImpl;

/**
 * Servlet implementation class InsertCart_fromWish
 */
@WebServlet("/wish/insertCart.do")
public class InsertCart_fromWish extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		System.out.println("연결됐니?");
		
		request.setCharacterEncoding("utf-8");
		
		String wish_no = request.getParameter("wish_no");
		
		IWishService wservice = WishServiceImpl.getInstance();
		IProdService pservice = ProdServiceImpl.getInstance();
		ICartService cservice = CartServiceImpl.getInstance();
		
		
		WishVO wvo = wservice.selectWish(wish_no);
		String prod_id = wvo.getProd_id();
		
		ProdVO pvo = pservice.selectProd_prod_id(prod_id);

		String prod_size = wvo.getProd_size();
		String mem_id = wvo.getMem_id();
		String prod_name = pvo.getProd_name();
		int prod_price = pvo.getProd_price();
		
		
		CartVO cvo = new CartVO();	//장바구니에 상품이 있는지 체크하는 객체
		CartVO cvo2 = new CartVO();	//장바구니에 상품이 없으면 추가 되는 객체
		
		
		Map<String, String> map = new HashMap<String, String>();
		map.put("prod_id", prod_id);
		map.put("mem_id", mem_id);
		map.put("prod_size", prod_size);
		
		int res =0;
		
		cvo = cservice.selectCart2(map);
		
		if(cvo==null) { //장바구니에 해당 상품이 없을 경우 인서트
			cvo2.setCart_qty(1);
			cvo2.setCart_status("0");
			cvo2.setProd_id(prod_id);
			cvo2.setProd_size(prod_size);
			cvo2.setMem_id(mem_id);
			cvo2.setProd_name(prod_name);
			cvo2.setProd_price(prod_price);
			res = cservice.insertCart(cvo2);
			System.out.println("인서트시 res" + res);
		}else { //장바구니에 해당 상품이 있으면 장바구니 업데이트
			res = cservice.updateCart3(map);
			System.out.println("업데이트된 res" + res);
		}
				
		if(res>0) {
			res = wservice.deleteWish(wish_no);
		}
		
		
		request.setAttribute("result", res);
		
		request.getRequestDispatcher("/jhs/result.jsp").forward(request, response);
		
		
		
	
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
