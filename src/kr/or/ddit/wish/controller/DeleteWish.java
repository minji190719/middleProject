package kr.or.ddit.wish.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.or.ddit.wish.service.IWishService;
import kr.or.ddit.wish.service.WishServiceImpl;

/**
 * Servlet implementation class DeleteWish
 */
@WebServlet("/deleteWish.do")
public class DeleteWish extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setCharacterEncoding("utf-8");
		String wish_no = request.getParameter("wish_no");
		
		IWishService service = WishServiceImpl.getInstance();
		int res =service.deleteWish(wish_no);
		
		
		request.setAttribute("result", res);
		
		request.getRequestDispatcher("jhs/result.jsp").forward(request, response);

		
		
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
