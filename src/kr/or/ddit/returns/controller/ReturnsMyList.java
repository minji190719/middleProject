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
import kr.or.ddit.vo.CartVO;
import kr.or.ddit.vo.MemberVO;
import kr.or.ddit.vo.ReturnsVO;

/**
 * Servlet implementation class ReturnsMyList
 */
@WebServlet("/returnsMyList.do")
public class ReturnsMyList extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("view/page/returns/returns_mylist.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
	    response.setCharacterEncoding("utf-8");
	    response.setContentType("application/json; charset=utf-8");
	    
	    HttpSession session = request.getSession();
	    MemberVO member = (MemberVO) session.getAttribute("member");
	    
	    if (member == null) {
	    	String jsonData = "로그인을 해주세요.";
	    			
	    	PrintWriter out = response.getWriter();
			
			out.write(jsonData);
			
			response.flushBuffer();
			
	    } else {
	    	String mem_id = member.getMem_id();
	    	
	    	//1. 내 반품 신청목록 가져오기
	    	
	    	IReturnsService service = ReturnsServiceImpl.getInstance();
	    	
	    	List<ReturnsVO> list = service.selectReturns_mylist(mem_id);
	    	
	    	System.out.println(list);
	    	if (list == null) {
	    		String jsonData = "반품 신청 내역이 없습니다.";
    			
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
