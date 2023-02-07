package kr.or.ddit.payment.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import kr.or.ddit.address.service.AddressServiceImpl;
import kr.or.ddit.address.service.IAddressService;
import kr.or.ddit.cart.service.CartServiceImpl;
import kr.or.ddit.cart.service.ICartService;
import kr.or.ddit.member.service.IMemberService;
import kr.or.ddit.member.service.MemberServiceImpl;
import kr.or.ddit.vo.AddressVO;
import kr.or.ddit.vo.CartVO;
import kr.or.ddit.vo.MemberVO;
import oracle.net.resolver.AddrResolution;

/**
 * Servlet implementation class PayPage
 */
@WebServlet("/payPage.do")
public class PayPage extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
	request.setCharacterEncoding("utf-8");
	HttpSession session = request.getSession(false);
	
	MemberVO member = (MemberVO)session.getAttribute("member");
	
	String mem_id = member.getMem_id();
	
	ICartService cservice = CartServiceImpl.getInstance();
	IAddressService aservice = AddressServiceImpl.getInstance();
	IMemberService mservice = MemberServiceImpl.getInstance();
	
	List<CartVO> list = cservice.selectAllCart(mem_id);
	AddressVO avo = aservice.selectAddress(mem_id);
	MemberVO mvo = mservice.selectMember(mem_id);
	
	request.setAttribute("cartList", list);
	request.setAttribute("address", avo);
	request.setAttribute("mem", mvo);
	
	request.getRequestDispatcher("/jhs/payPage.jsp").forward(request, response);
	
	
	
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
