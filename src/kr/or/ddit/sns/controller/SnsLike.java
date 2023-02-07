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

import kr.or.ddit.like.service.ILikeService;
import kr.or.ddit.like.service.LikeServiceImpl;
import kr.or.ddit.member.service.IMemberService;
import kr.or.ddit.member.service.MemberServiceImpl;
import kr.or.ddit.sns.service.ISnsService;
import kr.or.ddit.sns.service.SnsServiceImpl;
import kr.or.ddit.vo.LikeVO;
import kr.or.ddit.vo.MemberVO;
import kr.or.ddit.vo.SnsVO;

/**
 * Servlet implementation class SnsLike
 */
@WebServlet("/snsLike.do")
public class SnsLike extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		response.setContentType("application/x-www-form-urlencoded; charset=utf-8");
		
		
		
		String str = "";
		//이 글에 좋아요 누른 적 있는지 체크 //맵 변수로 SNS_NO, MEM_ID 받아야함
		HttpSession session = request.getSession();
        MemberVO member = (MemberVO) session.getAttribute("member");
        
        if (member == null) {
        	str = "로그인을 해주세요.";
        } else {
	        String mem_id = member.getMem_id();
	        String sns_no = request.getParameter("sns_no");
	        System.out.println("좋아요 mem_id : " + mem_id);
	        System.out.println("좋아요 sns_no : " + sns_no);
	        
	
	        ILikeService service_like = LikeServiceImpl.getInstance();
	        Map<String, Object> map_like = new HashMap<String, Object>();
	        map_like.put("sns_no", sns_no);
	        map_like.put("mem_id", mem_id);
	        
	        int count = service_like.selectLike_mem_id(map_like);
	        
	        
	        Gson gson = new Gson();
	        
	        if (count < 1) { //좋아요 누른적 없음
	        	System.out.println("if문 통과");
	        	//먼저 해당 컬럼의 좋아요 수를 셀렉트
	        	ISnsService service_sns = SnsServiceImpl.getInstance();
	        	
	        	SnsVO vo = service_sns.selectSns_no(sns_no);
	        	
	        	int likeCount = vo.getSns_like();
	        	
	        	int resultCount = likeCount + 1;
	        	
	        	Map<String, Object> map_sns = new HashMap<String, Object>();
	        	
	        	map_sns.put("column", "sns_like");
	        	map_sns.put("data", resultCount);
	        	map_sns.put("sns_no", sns_no);
	        	
	        	int result = service_sns.updateSns(map_sns);
	        	str = (result >= 1) ? "좋아요를 누르셨습니다!" : "좋아요 실패!";
	        	
	        	//이제 LIKES테이블에 인서트
	        	LikeVO vo_like = new LikeVO();
	        	vo_like.setMem_id(mem_id);
	        	vo_like.setSns_no(sns_no);
	        	
	        	int result_like = service_like.insertLike(vo_like);
	        	System.out.println("result_like(1이면성공) : " + result_like);
	        	
	        } else { //좋아요 누른적 있음
	        	System.out.println("else문 통과 -좋아요취소");
	        	ISnsService service_sns = SnsServiceImpl.getInstance();
	        	
	        	SnsVO vo = service_sns.selectSns_no(sns_no);
	        	
	        	int likeCount = vo.getSns_like();
	        	
	        	int resultCount = likeCount - 1;
	        	
	        	Map<String, Object> map_sns = new HashMap<String, Object>();
	        	map_sns.put("column", "sns_like");
	        	map_sns.put("data", resultCount);
	        	map_sns.put("sns_no", sns_no);
	        	int result = service_sns.updateSns(map_sns);
	        	
	        	Map<String, Object> map_like_delete = new HashMap<String, Object>();
	        	map_like_delete.put("mem_id", mem_id);
	        	map_like_delete.put("sns_no", sns_no);
	        	int result2 = service_like.deleteLike(map_like_delete);
	        	
	        	
	        	if ((result + result2) >= 2) {
	        		str = "이미 좋아요를 누른 게시글입니다. 좋아요가 취소되었습니다.";
	        	} else {
	        		str = "좋아요 취소에 실패했습니다.";
	        	}
	        		
	        }
        
        }
        
        PrintWriter out = response.getWriter();
        
        out.write(str);
        
        response.flushBuffer();
        
	}

}
