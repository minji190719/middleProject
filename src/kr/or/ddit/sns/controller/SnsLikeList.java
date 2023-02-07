package kr.or.ddit.sns.controller;

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

import kr.or.ddit.sns.service.ISnsService;
import kr.or.ddit.sns.service.SnsServiceImpl;
import kr.or.ddit.vo.MemberVO;
import kr.or.ddit.vo.SnsVO;

/**
 * Servlet implementation class SnsLikeList
 */
@WebServlet("/snsLikeList.do")
public class SnsLikeList extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("view/page/sns/sns_likelist.jsp").forward(request, response);
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
	    	
	    	ISnsService service = SnsServiceImpl.getInstance();
	    	
	    	List<SnsVO> list = service.selectAllSns_Like(mem_id);
	    	
	    	Gson gson = new Gson();
	    	
	    	String jsonData = gson.toJson(list);
	    	
	    	PrintWriter out = response.getWriter();
	    	
	    	out.write(jsonData);
	    	
	    	response.flushBuffer();		
	    }
	      
	}

}
