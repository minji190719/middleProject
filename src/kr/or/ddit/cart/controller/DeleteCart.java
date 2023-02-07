package kr.or.ddit.cart.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.or.ddit.cart.service.CartServiceImpl;
import kr.or.ddit.cart.service.ICartService;

/**
 * Servlet implementation class DeleteCart
 */
@WebServlet("/deleteCart.do")
public class DeleteCart extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setCharacterEncoding("utf-8");
		String cart_no = request.getParameter("cart_no");
		System.out.println("cart_no확인 :" + cart_no);
		
		ICartService service = CartServiceImpl.getInstance();
		
		int res = service.deleteCart(cart_no);
		System.out.println("res:" +res);
		
		
		request.setAttribute("result", res);
		
		request.getRequestDispatcher("/jhs/result.jsp").forward(request, response);
		
		
		
		
		
		
		
	
	
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
