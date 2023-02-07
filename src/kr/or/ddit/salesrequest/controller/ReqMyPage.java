package kr.or.ddit.salesrequest.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.or.ddit.vo.MemberVO;

/**
 * Servlet implementation class ReqMain
 */
@WebServlet("/ONUM/myPage.do")
public class ReqMyPage extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		request.setCharacterEncoding("UTF-8");

		MemberVO member = (MemberVO) request.getSession(false).getAttribute("member");
		
		if (member == null) {
			response.sendRedirect(request.getContextPath() + "/home.do");
			return;
		}
		
		request.getRequestDispatcher("/view/page/ONUM/OnumMypage.jsp").forward(request, response);

	}

}
