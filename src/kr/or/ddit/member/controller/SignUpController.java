package kr.or.ddit.member.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.or.ddit.address.service.AddressServiceImpl;
import kr.or.ddit.address.service.IAddressService;
import kr.or.ddit.member.service.IMemberService;
import kr.or.ddit.member.service.MemberServiceImpl;
import kr.or.ddit.vo.AddressVO;
import kr.or.ddit.vo.MemberVO;

/**
 * Servlet implementation class SignUpController
 */
@WebServlet("/signUp.do")
public class SignUpController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		request.getRequestDispatcher("view/page/signUp.jsp").forward(request,
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
//		String confirmPass = request.getParameter("confirmPass");
		String memName = request.getParameter("memName");
		String memZip = request.getParameter("memZip");
		String memAdd1 = request.getParameter("memAdd1");
		String memAdd2 = request.getParameter("memAdd2");
		String memTel = request.getParameter("memTel");
		String memMail = request.getParameter("memMail");
		String memBirth = request.getParameter("memBirth");
		
		MemberVO memVo = new MemberVO();

		memVo.setMem_id(memId);
		memVo.setMem_pass(memPass);
		memVo.setMem_name(memName);
		memVo.setMem_zip(memZip);
		memVo.setMem_add1(memAdd1);
		memVo.setMem_add2(memAdd2);
		memVo.setMem_tel(memTel);
		memVo.setMem_mail(memMail);
		memVo.setMem_birth(memBirth);

		IMemberService memService = MemberServiceImpl.getInstance();

		int memCheck = memService.insertMember(memVo);

		if (memCheck < 1) {
			response.sendRedirect(request.getContextPath() + "/signUp.do");
		} else {
			AddressVO addrVo = new AddressVO();
			
			addrVo.setMem_id(memId);
			addrVo.setAddr_zip(memZip);
			addrVo.setAddr1(memAdd1);
			addrVo.setAddr2(memAdd2);
			
			IAddressService addrService = AddressServiceImpl.getInstance();
			
			int addrCheck = addrService.insertAddress(addrVo);
			
			if (addrCheck < 1) {
				response.sendRedirect(request.getContextPath() + "/signUp.do");
			} else {
				response.sendRedirect(request.getContextPath() + "/home.do");
			}
		}
	}
}
