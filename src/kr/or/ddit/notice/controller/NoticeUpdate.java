package kr.or.ddit.notice.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.or.ddit.notice.service.INoticeService;
import kr.or.ddit.notice.service.NoticeServiceImpl;
import kr.or.ddit.vo.NoticeVO;

/**
 * Servlet implementation class NoticeUpdate
 */
@WebServlet("/noticeUpdate.do")
public class NoticeUpdate extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		int no = Integer.parseInt(request.getParameter("noValue"));
		String title = request.getParameter("titleValue");
		String content = request.getParameter("contentValue").replaceAll("\n", "<br>");
		System.out.println("no는 " + no + ", title은 " + title + ", content는 " + content);
		
		NoticeVO vo = new NoticeVO();
		
		vo.setNotice_no(no);
		vo.setNotice_title(title);
		vo.setNotice_content(content);
		
		INoticeService service = NoticeServiceImpl.getInstance();
		
		int result = (int) service.updateNotice2(vo);
		
		response.sendRedirect( request.getContextPath() + "/noticeList.do");
		//request.getRequestDispatcher("/view/page/qna/notice_list.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
