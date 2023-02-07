package kr.or.ddit.wish.controller;

import java.io.IOException;
import java.util.List;

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
 * Servlet implementation class SelectAllWish
 */
@WebServlet("/selectAllWish.do")
public class SelectAllWish extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	
		request.setCharacterEncoding("utf-8");
		
		HttpSession session = request.getSession(false);
		
		MemberVO member = (MemberVO)session.getAttribute("member");
		
		String mem_id = member.getMem_id();
		
		IWishService service = WishServiceImpl.getInstance();
		
		List<WishVO> list = service.sellectAllWish(mem_id);
		
		request.setAttribute("list", list);
		
		request.getRequestDispatcher("jhs/wishPage.jsp").forward(request, response);
	
	
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
