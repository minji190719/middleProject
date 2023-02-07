package kr.or.ddit.payment.controller;

import java.io.IOException;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import kr.or.ddit.address.service.AddressServiceImpl;
import kr.or.ddit.address.service.IAddressService;
import kr.or.ddit.cart.service.CartServiceImpl;
import kr.or.ddit.cart.service.ICartService;
import kr.or.ddit.delivery.dao.DeliveryDaoImpl;
import kr.or.ddit.delivery.service.DeliveryServiceImpl;
import kr.or.ddit.delivery.service.IDeliveryService;
import kr.or.ddit.payment.dao.IPaymentDao;
import kr.or.ddit.payment.dao.PaymentDaoImpl;
import kr.or.ddit.payment.service.IPaymentService;
import kr.or.ddit.payment.service.PaymentServiceImpl;
import kr.or.ddit.salesrequest.dao.SalesRequestDaoImpl;
import kr.or.ddit.salesrequest.service.ISalesRequestService;
import kr.or.ddit.salesrequest.service.SalesRequestServiceImpl;
import kr.or.ddit.vo.AddressVO;
import kr.or.ddit.vo.CartVO;
import kr.or.ddit.vo.DeliveryVO;
import kr.or.ddit.vo.MemberVO;
import kr.or.ddit.vo.PaymentVO;

/**
 * Servlet implementation class Payment
 */
@WebServlet("/payment.do")
public class Payment extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		request.setCharacterEncoding("utf-8");
		
		String pay_no = null;
		String addr_no = null;
		
		
		
		HttpSession session = request.getSession(false);
		
		MemberVO member = (MemberVO)session.getAttribute("member");
		
		String mem_id = member.getMem_id();
		
		int pay_total = Integer.parseInt(request.getParameter("pay_total"));
		pay_no = request.getParameter("pay_no");

		String str = request.getParameter("cart_json");
		
		System.out.println(pay_total);
		System.out.println("str: " + str);
		
		Gson gson = new Gson();
		
		List<CartVO> list = gson.fromJson( str.toString() , new TypeToken<ArrayList<CartVO>>(){}.getType());
		
		System.out.println("변신한 리시트" + list);
		
		
		Map<String, String> map = new HashMap<String, String>();
		
		PaymentVO vo = new PaymentVO();
		vo.setMem_id(mem_id);
		vo.setPay_total(pay_total);
		
		
		
		IPaymentService pservice = PaymentServiceImpl.getInstance();
		ICartService cservice = CartServiceImpl.getInstance();
		ISalesRequestService sservice = SalesRequestServiceImpl.getInstance();
		IDeliveryService dservice =DeliveryServiceImpl.getInstance();
		IAddressService aservice = AddressServiceImpl.getInstance();
		
		
		int res = pservice.insertPayment(vo);
		System.out.println("페이넘버 성공했니?" + res);
		
		
		if(res > 0) {
			pay_no = pservice.selectPayNo(mem_id);
			System.out.println("pay_no들어갔니?" + pay_no);
		}else {
			System.out.println("페이넘버 셀렉트 실패");
		}
		
		if(pay_no != null) {
			for(CartVO cvo : list) {
				map.put("cart_no",cvo.getCart_no());
				map.put("pay_no",pay_no);
				res = cservice.updateCart4(map);
				if(cvo.getCart_no().substring(0, 1).equals("U")) {
					sservice.updateSalesRequest3(cvo.getCart_no());
					System.out.println("중고품 몇개 샀는지 확인 문장 개수가 중고품 개수임다");
				}
			}
		}else {
			System.out.println("카트 스테이터스 업데이트 실패");
		}

		AddressVO avo = aservice.selectAddress(mem_id);
		addr_no = avo.getAddr_no();
		
		DeliveryVO dvo = new DeliveryVO();
		dvo.setAddr_no(addr_no);
		dvo.setPay_no(pay_no);
		
		dservice.insertDelivery(dvo);
		request.setAttribute("pay_no", pay_no);
		request.setAttribute("result", res);
		request.getRequestDispatcher("/jhs/result2.jsp").forward(request, response);
		
		
	

	
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
