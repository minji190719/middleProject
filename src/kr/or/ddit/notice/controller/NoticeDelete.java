package kr.or.ddit.notice.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import kr.or.ddit.notice.service.INoticeService;
import kr.or.ddit.notice.service.NoticeServiceImpl;

@WebServlet("/noticeDelete.do")
public class NoticeDelete extends HttpServlet {
	private static final long serialVersionUID = 1L;


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		// 파라미터값 받기
		int notice_no = Integer.parseInt(request.getParameter("notice_no"));
		
		System.out.println("notice_no는" + notice_no);
		
		// 서비스 객체 생성
		INoticeService service = NoticeServiceImpl.getInstance();
		
		int deleteResult = service.deleteNotice(notice_no);
		System.out.println("result는 " + deleteResult);
		
		request.setAttribute("DeleteResult", deleteResult);
		
//		response.sendRedirect(request.getContextPath() + "/view/page/qna/notice_list.jsp");
		response.sendRedirect(request.getContextPath() + "/noticeList.do");
//		RequestDispatcher rd = request.getRequestDispatcher("view/page/qna/notice_list.jsp");
		
//		rd.forward(request, response);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
