package kr.or.ddit.returns.controller;

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

import kr.or.ddit.cart.service.CartServiceImpl;
import kr.or.ddit.cart.service.ICartService;
import kr.or.ddit.member.service.IMemberService;
import kr.or.ddit.member.service.MemberServiceImpl;
import kr.or.ddit.returns.service.IReturnsService;
import kr.or.ddit.returns.service.ReturnsServiceImpl;
import kr.or.ddit.vo.CartVO;
import kr.or.ddit.vo.MemberVO;
import kr.or.ddit.vo.ReturnsVO;

@WebServlet("/returnsUpdate.do")
public class ReturnsUpdate extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String returns_no = request.getParameter("returns_no");
		System.out.println("업데이트파라미터 : " + returns_no);
		request.getRequestDispatcher("view/page/returns/returns_update.jsp?returns_no=" + returns_no).forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
	    response.setCharacterEncoding("utf-8");
	    response.setContentType("application/json; charset=utf-8");
	    
	    HttpSession session = request.getSession();
	    MemberVO member = (MemberVO) session.getAttribute("member");
	    String mem_id = member.getMem_id();
	    
	    IReturnsService service = ReturnsServiceImpl.getInstance();

	    if (mem_id.equals("ADMIN")) {
	    	String returns_no = request.getParameter("returns_no");
	    	
	    	ReturnsVO vo = service.selectReturns_admin_returns_no(returns_no);
	    	System.out.println(vo.getReturn_title().substring(0, 2));
	    	
	    		if (vo.getReturn_title().substring(0, 2).equals("[반")) {
	    			 String str = "이미 처리가 완료되었습니다.";
	    			    
	    			 PrintWriter out = response.getWriter();
	    				
	    			out.write(str);
	    				
	    			response.flushBuffer();
	    			
	    		} else {
	    			String title = "[반품 처리 완료]" + vo.getReturn_title();
	    			String returns_content = vo.getReturn_content();
	    			
	    			Map<String, Object> map = new HashMap<String, Object>();
	    			
	    			map.put("returns_no", returns_no);
	    			map.put("returns_title", title);
	    			map.put("returns_content", returns_content);
	    			
	    			int result = service.updateReturns(map);
	    			////카트테이블에서 해당 결제상태 2로 변경해줘야함
	    			//RETURNS.CART_NO 있음.
	    			int result_status = service.updateReturns_admin_cart_status(vo.getCart_no());
	    			
	    			//멤버 마일리지 적립
	    			IMemberService service_mem = MemberServiceImpl.getInstance();
	    			ICartService service_cart = CartServiceImpl.getInstance();
	    			CartVO vo_cart = service_cart.selectCart(vo.getCart_no());
	    			
	    			//적립될 마일리지
	    			MemberVO vo_mem = service_mem.selectMember(mem_id);
	    			int mile_new = vo_mem.getMem_mileage() + vo_cart.getProd_price();
	    			
	    			Map<String, Object> map_mem = new HashMap<String, Object>();
	    			map_mem.put("column", "mem_mileage");
	    			map_mem.put("mem_id", mem_id);
	    			map_mem.put("mem_mileage", mile_new);
	    			
	    			
	    			int result_mem = service_mem.updateMember(map_mem);
	    			String str = (result >= 1 && result_status >= 1) ? "승인 완료" : "승인 실패";
	    			
	    			PrintWriter out = response.getWriter();
	    			
	    			out.write(str);
	    			
	    			response.flushBuffer();
	    			
	    		}
	    		
	    } else {
	    	
	    	//보내준 번호, 제목, 내용으로 수정하기
	    	
	    	String returns_no = request.getParameter("returns_no"); 
	    	String returns_title = request.getParameter("returns_title"); 
	    	String returns_content = request.getParameter("returns_content").replace("/n", "<br>"); 
	    	
	    	System.out.println("수정할 제목 : " + returns_title);
	    	System.out.println("수정할 내용 : " + returns_content);
	    	
	    	Map<String, Object> map = new HashMap<String, Object>();
	    	
	    	map.put("returns_no", returns_no);
	    	map.put("returns_title", returns_title);
	    	map.put("returns_content", returns_content);
	    	
	    	int result = service.updateReturns(map);
	    	
	    	String str = (result >= 1) ? "수정 성공!" : "수정 실패!";
	    	
	    	PrintWriter out = response.getWriter();
	    	
	    	out.write(str);
	    	
	    	response.flushBuffer();
	    }
	    
	}
	

}
