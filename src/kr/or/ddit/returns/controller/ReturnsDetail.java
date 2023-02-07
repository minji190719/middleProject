package kr.or.ddit.returns.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.management.modelmbean.RequiredModelMBean;
import javax.security.auth.message.callback.PrivateKeyCallback.Request;
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
 * Servlet implementation class ReturnsDetail
 */
@WebServlet("/returnsDetail.do")
public class ReturnsDetail extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//세션으로 어드민 구분
		HttpSession session = request.getSession();
	    MemberVO member = (MemberVO) session.getAttribute("member");
	    
	    if (member == null) { //비회원
	    	request.getRequestDispatcher("").forward(request, response);
	    } 
		
	    if (member.getMem_id().equals("ADMIN")) { //어드민
	    	String returns_no = request.getParameter("returns_no");
	    	String mem_id = request.getParameter("mem_id");
	    	System.out.println("파라미터 : " + returns_no);
	    	System.out.println("파라미터 : " + mem_id);
	    	
	    	request.getRequestDispatcher("view/page/returns/returns_detail_admin.jsp?returns_no=" + returns_no + "&mem_id=" + mem_id).forward(request, response);
	    
	    } else {	//일반회원
	    	String returns_no = request.getParameter("returns_no");
	    	System.out.println("파라미터 : " + returns_no);
	    	
	    	request.getRequestDispatcher("view/page/returns/returns_detail.jsp?returns_no=" + returns_no).forward(request, response);
	    	
	    }
		
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
	    response.setCharacterEncoding("utf-8");
	    response.setContentType("application/json; charset=utf-8");
	    
	    HttpSession session = request.getSession();
	    MemberVO member = (MemberVO) session.getAttribute("member");
	    
	    if (member == null) { //비회원
	    	String jsonData = "로그인을 해주세요.";
	    			
	    	PrintWriter out = response.getWriter();
			
			out.write(jsonData);
			
			response.flushBuffer();
			
	    } else {
	    	//세션으로 어드민 구분
	    	String mem_id = member.getMem_id();

	    	IReturnsService service = ReturnsServiceImpl.getInstance();
	    	
	    	if (mem_id.equals("ADMIN")) { //어드민
	    		String returns_no = request.getParameter("returns_no");
	    		ReturnsVO vo = service.selectReturns_admin_returns_no(returns_no);
	    		
	    		System.out.println("vo : " + vo);
	    		if (vo == null) {
	    			String jsonData = "해당 게시물이 없습니다.";
	    			
	    			PrintWriter out = response.getWriter();
	    			
	    			out.write(jsonData);
	    			
	    			response.flushBuffer();
	    			
	    		} else {
	    			Gson gson = new Gson();
	    			
	    			String jsonData = gson.toJson(vo);
	    			
	    			PrintWriter out = response.getWriter();
	    			
	    			out.write(jsonData);
	    			
	    			response.flushBuffer();
	    			
	    		}
	    		
	    	} else { //일반회원
	    		//String mem_id = request.getParameter("mem_id");
	    		String returns_no = request.getParameter("returns_no");
	    		//1. 해당 게시글 상세보기
	    		
	    		
	    		Map<String, Object> map = new HashMap<String, Object>();
	    		map.put("mem_id", mem_id);
	    		map.put("returns_no", returns_no);
	    		
	    		ReturnsVO vo = service.selectReturns_returns_no(map);
	    		
	    		System.out.println("vo : " + vo);
	    		if (vo == null) {
	    			String jsonData = "해당 게시물이 없습니다.";
	    			
	    			PrintWriter out = response.getWriter();
	    			
	    			out.write(jsonData);
	    			
	    			response.flushBuffer();
	    			
	    		} else {
	    			Gson gson = new Gson();
	    			
	    			String jsonData = gson.toJson(vo);
	    			
	    			PrintWriter out = response.getWriter();
	    			
	    			out.write(jsonData);
	    			
	    			response.flushBuffer();
	    			
	    		}
	    	}
	    }
	}

}
