package kr.or.ddit.member.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.or.ddit.member.service.IMemberService;
import kr.or.ddit.member.service.MemberServiceImpl;
import kr.or.ddit.vo.MemberVO;

/**
 * Servlet implementation class MyPageController
 */
@WebServlet("/member/myPage.do")
public class MyPageController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		request.setCharacterEncoding("UTF-8");

		MemberVO member = (MemberVO) request.getSession(false)
				.getAttribute("member");

		if ("ADMIN".equals(member.getMem_id())) {
			request.getRequestDispatcher("/view/page/member/adminPage.jsp")
					.forward(request, response);
		} else {
			request.getRequestDispatcher("/view/page/member/myPage.jsp")
					.forward(request, response);
		}

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		request.setCharacterEncoding("UTF-8");

		MemberVO member = (MemberVO) request.getSession()
				.getAttribute("member");

		String memId = member.getMem_id();
		String memPass = request.getParameter("memPass");
		String memName = request.getParameter("memName");
		String memZip = request.getParameter("memZip");
		String memAdd1 = request.getParameter("memAdd1");
		String memAdd2 = request.getParameter("memAdd2");
		String memTel = request.getParameter("memTel");
		String memMail = request.getParameter("memMail");
		String memBirth = member.getMem_birth();

		MemberVO vo = new MemberVO();

		vo.setMem_id(memId);
		vo.setMem_pass(memPass);
		vo.setMem_name(memName);
		vo.setMem_zip(memZip);
		vo.setMem_add1(memAdd1);
		vo.setMem_add2(memAdd2);
		vo.setMem_tel(memTel);
		vo.setMem_mail(memMail);
		vo.setMem_birth(memBirth);

		IMemberService service = MemberServiceImpl.getInstance();

		int check = service.updateMember2(vo);

		if (check < 1) {
			doGet(request, response);
		} else {
			response.sendRedirect(request.getContextPath() + "/home.do");
		}

	}

}
