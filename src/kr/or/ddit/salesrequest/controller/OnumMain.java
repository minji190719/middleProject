package kr.or.ddit.salesrequest.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.or.ddit.vo.MemberVO;

@WebServlet("/ONUM/onumMain.do")
public class OnumMain extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		request.setCharacterEncoding("utf-8");
//
//		MemberVO member = (MemberVO) request.getSession(false).getAttribute("member");
//
//		if (member == null) {
//			response.sendRedirect(request.getContextPath() + "/home.do");
//			return;
//		}

		request.getRequestDispatcher("/view/page/ONUM/Main.jsp").forward(request, response);

	}

}
