package kr.or.ddit.sns.controller;

import java.io.IOException;
import java.io.PrintWriter;

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
 * Servlet implementation class SnsDelete
 */
@WebServlet("/snsDelete.do")
public class SnsDelete extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		response.setContentType("application/x-www-form-urlencoded; charset=utf-8");
		
		HttpSession session = request.getSession();
	    MemberVO member = (MemberVO) session.getAttribute("member");
	    String str = "";
	    
	    ISnsService service = SnsServiceImpl.getInstance();
	    String sns_no = request.getParameter("sns_no");

	    if (member == null) {
	    	str = "작성자만 지울 수 있습니다. 로그인을 해주세요.";
	    	
	    } else {
	    	String memId = member.getMem_id();

	    	//sns게시글 작성자 아이디 찾기
	    	SnsVO vo = service.selectSns_no(sns_no);
	    	String writer = vo.getMem_id();
	    	
	    	System.out.println("memId : " + memId);
	    	System.out.println("writer : " + writer);
	    	if (memId.equals(writer) || memId.equals("ADMIN")) {
	    		int result_like = service.deleteSns_like(sns_no);
	    				
	    		int result_comment = service.deleteSns_comment(sns_no);

	    		int result = service.deleteSns(sns_no);
	    		
	    		str = (result >= 1) ? "삭제 완료!" : "삭제 실패!"; 
	    		
	    	} else {
	    		str = "작성자만 지울 수 있습니다. 본인이 작성한 글이 아닙니다.";
	    		
	    	}
	    	
	    }
		
		Gson gson = new Gson();
		
		
		PrintWriter out = response.getWriter();
		
		out.write(str);
		
		response.flushBuffer();
	}

}
