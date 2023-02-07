package kr.or.ddit.sns.controller;

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

import com.google.gson.Gson;

import kr.or.ddit.sns.service.ISnsService;
import kr.or.ddit.sns.service.SnsServiceImpl;
import kr.or.ddit.vo.MemberVO;
import kr.or.ddit.vo.SnsVO;

/**
 * Servlet implementation class SnsUpdate
 */
@WebServlet("/snsUpdate.do")
public class SnsUpdate extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		response.setContentType("application/x-www-form-urlencoded; charset=utf-8");
		String str = "";
		
		HttpSession session = request.getSession();
	    MemberVO member = (MemberVO) session.getAttribute("member");
	    
	    if (member == null) {
	    	str = "작성자만 수정할 수 있습니다. 로그인을 해주세요.";
	    	
	    } else {
		    //게시글 아이디와 세션 아이디 비교
			String sns_no = request.getParameter("sns_no");
			String sns_content = request.getParameter("sns_content");
	
			String memId = member.getMem_id();
			
			ISnsService service = SnsServiceImpl.getInstance();
			SnsVO vo = service.selectSns_no(sns_no);
			
			if (vo.getMem_id().equals(memId)) {
				Map<String, Object> map = new HashMap<String, Object>();
				
				//일단 sns_content로 고정
				map.put("column", "sns_content");
				map.put("data", sns_content);
				map.put("sns_no", sns_no);
				
				int result = service.updateSns(map);
				
				str = (result >= 1) ? "수정 완료!" : "수정 실패!"; 
			} else {
				str = "작성한 본인만 수정할 수 있습니다.";
			}
	    }
	    
	    Gson gson = new Gson();
		
		PrintWriter out = response.getWriter();
		
		out.write(str);
		
		response.flushBuffer();
	}

}
