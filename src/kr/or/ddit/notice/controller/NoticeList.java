package kr.or.ddit.notice.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import kr.or.ddit.notice.service.INoticeService;
import kr.or.ddit.notice.service.NoticeServiceImpl;
import kr.or.ddit.vo.MemberVO;
import kr.or.ddit.vo.NoticeVO;

@WebServlet("/noticeList.do")
public class NoticeList extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession(false);
		MemberVO member = (MemberVO) session.getAttribute("member");
		if(member!=null) {			
			String mem_id = member.getMem_id();
			request.setAttribute("mem_id", mem_id);
		}else {
			request.setAttribute("mem_id", "권한없음");
		}
		request.setCharacterEncoding("utf-8");

		INoticeService service = NoticeServiceImpl.getInstance();
		
		List<NoticeVO> noticeList = service.selectAllNotice();
		
		System.out.println("리스트 : " + noticeList);
		request.setAttribute("noticeList", noticeList);
		
		RequestDispatcher rd = request.getRequestDispatcher("view/page/qna/notice_list.jsp");
		rd.forward(request, response);
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
//		request.setCharacterEncoding("utf-8");
//		response.setCharacterEncoding("utf-8");
//		response.setContentType("application/json charset=utf-8");
//		
//		// service객체 생성
//		INoticeService service = NoticeServiceImpl.getInstance();
//		
//		
//		// service메소드 호출하기
//		List<NoticeVO> noticeList = service.selectAllNotice();
//		
//
//		// Gson객체 생성
//		Gson gson = new Gson();
//		
//		String jsonData = gson.toJson(noticeList);
//		
//		System.out.println(jsonData); // 확인용
//		
//		PrintWriter out = response.getWriter();
//		
//		out.write(jsonData);
//		
//		response.flushBuffer();
	}

}
