package kr.or.ddit.returns.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.google.gson.Gson;

import kr.or.ddit.cart.service.CartServiceImpl;
import kr.or.ddit.cart.service.ICartService;
import kr.or.ddit.returns.service.IReturnsService;
import kr.or.ddit.returns.service.ReturnsServiceImpl;
import kr.or.ddit.sns.service.ISnsService;
import kr.or.ddit.sns.service.SnsServiceImpl;
import kr.or.ddit.vo.CartVO;
import kr.or.ddit.vo.MemberVO;
import kr.or.ddit.vo.ReturnsVO;
import kr.or.ddit.vo.SnsVO;

/**
 * Servlet implementation class ReturnsInsert
 */
@WebServlet("/returnsList.do")
public class ReturnsList extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("view/page/returns/returns_list.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
	    response.setCharacterEncoding("utf-8");
	    response.setContentType("application/json; charset=utf-8");
	    
	    HttpSession session = request.getSession();
	      
	    MemberVO member = (MemberVO) session.getAttribute("member");
	    //아이디 유효성 검사
	    if (member == null) {
	    	String jsonData = "로그인을 해주세요.";
	    			
	    	PrintWriter out = response.getWriter();
			
			out.write(jsonData);
			
			response.flushBuffer();
			
	    } else {
	    	String mem_id = member.getMem_id();
	    	
	    	//1. 내 장바구니에서 결제완료 목록 가져오기
	    	
	    	ICartService service = CartServiceImpl.getInstance();
	    	
	    	List<CartVO> list = service.selectCart_Returns(mem_id);
	    	System.out.println(list);
	    	if (list == null) {
	    		String jsonData = "구매 내역이 없습니다.";
    			
		    	PrintWriter out = response.getWriter();
				
				out.write(jsonData);
				
				response.flushBuffer();
	    	
	    	} else {
	    		Gson gson = new Gson();
	    		
	    		String jsonData = gson.toJson(list);
	    		
	    		PrintWriter out = response.getWriter();
	    		
	    		out.write(jsonData);
	    		
	    		response.flushBuffer();
	    		
	    	}
	    }
	}

}
