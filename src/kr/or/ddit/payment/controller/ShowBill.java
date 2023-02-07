package kr.or.ddit.payment.controller;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.mail.EmailException;

//import org.apache.commons.mail.EmailException;

import kr.or.ddit.cart.service.CartServiceImpl;
import kr.or.ddit.cart.service.ICartService;
import kr.or.ddit.delivery.service.DeliveryServiceImpl;
import kr.or.ddit.delivery.service.IDeliveryService;
import kr.or.ddit.member.service.IMemberService;
import kr.or.ddit.member.service.MemberServiceImpl;
import kr.or.ddit.payment.service.IPaymentService;
import kr.or.ddit.payment.service.PaymentServiceImpl;
import kr.or.ddit.vo.CartVO;
import kr.or.ddit.vo.DeliveryVO;
import kr.or.ddit.vo.MemberVO;
import kr.or.ddit.vo.PaymentVO;

/**
 * Servlet implementation class ShowBill
 */
@WebServlet("/showBill.do")
public class ShowBill extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setCharacterEncoding("utf-8");
		
		HttpSession session = request.getSession(false);
		
		MemberVO member = (MemberVO)session.getAttribute("member");
		
		
		String mem_id = member.getMem_id();
		String pay_no = request.getParameter("pay_no");
		System.out.println("여기는 showBill pay_no 넘어왓나 오바?==" + pay_no);
		
		MemberVO mvo = new MemberVO();
		PaymentVO pvo = new PaymentVO();
		DeliveryVO dvo = new DeliveryVO();
		
		
		IPaymentService pservice = PaymentServiceImpl.getInstance();
		IDeliveryService dservice = DeliveryServiceImpl.getInstance();
		ICartService cservice = CartServiceImpl.getInstance();
		IMemberService mservice = MemberServiceImpl.getInstance();

		mvo = mservice.selectMember(mem_id); 
		pvo = pservice.selectPayment(pay_no);
		
		//멤버 마일리지 계산 및 토탈금액 보여주기
		int result_price = pvo.getPay_total();
		int origin_price = pvo.getPay_total();
		
		Map<String, Object> map_mem = new HashMap<String, Object>();
		
		String mileage_flag = request.getParameter("mileage_flag");
		System.out.println(mileage_flag);
		
		if (mileage_flag.equals("true")) {
			map_mem.put("column", "mem_mileage");
			map_mem.put("mem_id", mem_id);
			map_mem.put("data", 0);
			int mile_update = mservice.updateMember(map_mem);
			result_price = result_price - member.getMem_mileage();
		}
		
		
		dvo = dservice.selectDelivery(pay_no);
		List<CartVO> clist = cservice.selectCart3(pay_no);

		Commons_attatch mail = new Commons_attatch();
		
		try {
			mail.sendEmail();
			
		} catch (EmailException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		request.setAttribute("mvo", mvo);
		request.setAttribute("pvo", pvo);
		request.setAttribute("dvo", dvo);
		request.setAttribute("clist", clist);
		request.setAttribute("origin_price", origin_price);
		request.setAttribute("result_price", result_price);
		
		System.out.println("showbill.do에서 리스트확인:" + clist);
		
		System.out.println(origin_price);
		System.out.println(result_price);
		request.getRequestDispatcher("/jhs/showBill.jsp").forward(request, response);
		
//		
	
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
