package kr.or.ddit.wish.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import kr.or.ddit.cart.service.CartServiceImpl;
import kr.or.ddit.cart.service.ICartService;
import kr.or.ddit.vo.CartVO;
import kr.or.ddit.vo.MemberVO;
import kr.or.ddit.vo.WishVO;
import kr.or.ddit.wish.service.IWishService;
import kr.or.ddit.wish.service.WishServiceImpl;

/**
 * Servlet implementation class InsertWish
 */
@WebServlet("/insertWish.do")
public class InsertWish extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		request.setCharacterEncoding("utf-8");
		
		HttpSession session = request.getSession(false);
		
		MemberVO member = (MemberVO)session.getAttribute("member");
		
		if(member==null) {
			request.setAttribute("result", 0);
			
			request.getRequestDispatcher("jhs/result.jsp").forward(request, response);
			
		}else {
		
		String mem_id = member.getMem_id();
		String prod_id = request.getParameter("prod_id");
		String prod_size = request.getParameter("size");
		
		
		IWishService service = WishServiceImpl.getInstance();
		WishVO vo = new WishVO();
		WishVO vo2 = new WishVO();
		int res =0;
		vo = service.checkWish(prod_id);
		System.out.println("위시리스트 중복 여부 체크" + vo);
		
		if(vo == null) {
			vo2.setMem_id(mem_id);
			vo2.setProd_id(prod_id);
			vo2.setProd_size(prod_size);
			
			res = service.insertWish(vo2);
			
		}else {
			res = 1;
		}

		request.setAttribute("result", res);
		
		request.getRequestDispatcher("jhs/result.jsp").forward(request, response);
		}	
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		request.setCharacterEncoding("utf-8");
		String cart_no = request.getParameter("cart_no");
		
		IWishService wservice = WishServiceImpl.getInstance();
		ICartService cservice = CartServiceImpl.getInstance();
		
		CartVO cvo = cservice.selectCart(cart_no);
		WishVO wvo = new WishVO();
		
		System.out.println("cvo확인:"+ cvo );
		
		wvo.setMem_id(cvo.getMem_id());
		wvo.setProd_id(cvo.getProd_id());
		wvo.setProd_size(cvo.getProd_size());
		
		int res=0;
		if(wservice.insertWish(wvo) >0) {
			res = cservice.deleteCart(cart_no);
		}
		
		request.setAttribute("result", res);
		
		request.getRequestDispatcher("jhs/result.jsp").forward(request, response);
		
		
	
	
	}

}
