package kr.or.ddit.member.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import kr.or.ddit.member.service.IMemberService;
import kr.or.ddit.member.service.MemberServiceImpl;
import kr.or.ddit.vo.MemberVO;

/**
 * Servlet implementation class LoginController
 */
@WebServlet("/login.do")
public class LoginController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		request.getRequestDispatcher("view/page/login.jsp").forward(request,
				response);

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		request.setCharacterEncoding("UTF-8");

		String memId = request.getParameter("memId");
		String memPass = request.getParameter("memPass");

		Map<String, Object> map = new HashMap<>();

		map.put("mem_id", memId);
		map.put("mem_pass", memPass);
		
		IMemberService service = MemberServiceImpl.getInstance();

		MemberVO member = service.getLoginMember(map);

		if (member == null) {
			response.setContentType("text/html; charset=UTF-8");

			PrintWriter out = response.getWriter();
			String url = request.getContextPath() + "/login.do";

			out.println("<script>alert('아이디가 존재하지 않거나, 비밀번호가 틀렸습니다.'); location.href='" + url + "';</script>");
			out.flush();
			out.close();
//			response.sendRedirect(request.getContextPath() + "/login.do");
			return;
		}

		HttpSession session = request.getSession();

		session.setAttribute("member", member);
		session.setMaxInactiveInterval(60 * 60 * 24);

		int time = session.getMaxInactiveInterval();
		System.out.println("세션 유지 시간 : " + time);

		response.sendRedirect(request.getContextPath() + "/home.do");

	}

}
