package kr.or.ddit.cart.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.websocket.Session;

import kr.or.ddit.cart.service.CartServiceImpl;
import kr.or.ddit.cart.service.ICartService;
import kr.or.ddit.prod.service.IProdService;
import kr.or.ddit.prod.service.ProdServiceImpl;
import kr.or.ddit.vo.CartVO;
import kr.or.ddit.vo.MemberVO;
import kr.or.ddit.vo.ProdVO;

/**
 * Servlet implementation class SelectAllCart
 */
@WebServlet("/selectAllCart.do")
public class SelectAllCart extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		request.setCharacterEncoding("utf-8");
		
		HttpSession session = request.getSession(false);
		
		MemberVO member = (MemberVO)session.getAttribute("member");
		
		String mem_id = member.getMem_id();
		
		
		System.out.println("mem_id확인:" + mem_id );
		
		ICartService service = CartServiceImpl.getInstance();
		
		List<CartVO> list = service.selectAllCart(mem_id);

	
		System.out.println("cartLsit확인:" + list );
		

		request.setAttribute("list", list);
		
		request.getRequestDispatcher("/jhs/cartPage.jsp").forward(request, response);
		
	
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		doGet(request, response);
	}

}
