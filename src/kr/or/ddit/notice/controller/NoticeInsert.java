package kr.or.ddit.notice.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.or.ddit.notice.service.INoticeService;
import kr.or.ddit.notice.service.NoticeServiceImpl;
import kr.or.ddit.vo.NoticeVO;


@WebServlet("/noticeInsert.do")
public class NoticeInsert extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		
		String notice_title = request.getParameter("notice_title");
		String notice_content = request.getParameter("notice_content").replaceAll("<br>", " ");
		System.out.println("notice_title은 " + notice_title);
		System.out.println("notice_content는 " + notice_content);
		
		NoticeVO vo = new NoticeVO();
		vo.setMem_id("ADMIN");//임시(나중에 세션으로 가져오기)
		vo.setNotice_title(notice_title);
		vo.setNotice_content(notice_content);
		
		System.out.println("vo는 " +vo);
		INoticeService service = NoticeServiceImpl.getInstance();
		int result = service.insertNotice(vo);
		
		if(result == 1) {
			List<NoticeVO> viewVo = (List<NoticeVO>) service.selectNotice_title(notice_title);
			System.out.println("view는" + viewVo);
			int notice_no = viewVo.get(0).getNotice_no();
			System.out.println("notice_no는" + notice_no);
			//RequestDispatcher rd = request.getRequestDispatcher(request.getContextPath()+ "/noticeView.do?notice_no=" + notice_no);
			//rd.forward(request, response);
			response.sendRedirect( request.getContextPath() + "/noticeView.do?notice_no=" + notice_no);
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
