package kr.or.ddit.notice.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.google.gson.Gson;

import kr.or.ddit.member.service.IMemberService;
import kr.or.ddit.notice.service.INoticeService;
import kr.or.ddit.notice.service.NoticeServiceImpl;
import kr.or.ddit.vo.MemberVO;
import kr.or.ddit.vo.NoticeVO;

@WebServlet("/noticeView.do")
public class NoticeView extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {		

		// 파라미터값 가져오기(글번호)
		int notice_no = Integer.parseInt(request.getParameter("notice_no"));

		System.out.println("글번호는 " + notice_no);

		// 서비스 객체 생성
		INoticeService service = NoticeServiceImpl.getInstance();

		// NoticeVo객체를 가져온다.
		NoticeVO noticeVO = (NoticeVO) service.selectNotice_no(notice_no);

		System.out.println("vo객체는" + noticeVO);

		// request객체에 값을 담는다.
		request.setAttribute("noticeVO", noticeVO);
		
		// 관리자인 경우 수정창으로, 그외에는 뷰창으로 보낸다.
		HttpSession session = request.getSession(false);
		MemberVO member = (MemberVO) session.getAttribute("member");		
		
		if(member==null) {			
			request.getRequestDispatcher("view/page/qna/notice_view.jsp").forward(request, response);
			System.out.println("member는 비회원입니다.");
			return;
		}
		
		if("ADMIN".equals(member.getMem_id())){
			request.getRequestDispatcher("view/page/qna/notice_update.jsp").forward(request, response);
			System.out.println("member는 관리자입니다.");
		}else {
			request.getRequestDispatcher("view/page/qna/notice_view.jsp").forward(request, response);
			System.out.println("member는 일반회원입니다.");
		}
		
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
//		request.setCharacterEncoding("utf-8");
//
//		// 파라미터값 가져오기(글번호)
//		int notice_no = Integer.parseInt(request.getParameter("notice_no"));
//
//		System.out.println("글번호는 " + notice_no);
//
//		// 서비스 객체 생성
//		INoticeService service = NoticeServiceImpl.getInstance();
//
//		// NoticeVo객체를 가져온다.
//		NoticeVO noticeVO = (NoticeVO) service.selectNotice_no(notice_no);
//
//		System.out.println("vo객체는" + noticeVO);
//
//		// request객체에 값을 담는다.
//		request.setAttribute("noticeVO", noticeVO);
//
//		// JSP페이지로 이동
//		RequestDispatcher rd = request.getRequestDispatcher("view/page/qna/notice_update.jsp");
//		rd.forward(request, response);
		
//		request.setCharacterEncoding("utf-8");
//		response.setCharacterEncoding("utf-8");
//		
//		int notice_no = Integer.parseInt(request.getParameter("notice_no"));
//		System.out.println("notice_no는 " + notice_no);
//		// 서비스 객체 생성
//		INoticeService service = NoticeServiceImpl.getInstance();
//
//		// NoticeVo객체를 가져온다.
//		NoticeVO noticeVO = (NoticeVO) service.selectNotice_no(notice_no);
//		
//		// Json 데이터로 변경하기 위한 Gson객체 생성: Json데이터로 변환하는 객체
//		Gson gson = new Gson();
//		String jsonData = null;
//		jsonData = gson.toJson(noticeVO);
	}

}
