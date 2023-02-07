package kr.or.ddit.notice.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import kr.or.ddit.notice.service.INoticeService;
import kr.or.ddit.notice.service.NoticeServiceImpl;
import kr.or.ddit.vo.NoticeVO;


@WebServlet("/noticeSearchList.do")
public class NoticeSearchList extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 0. 한글 입력일 수 있으므로 utf-8로 인코딩
		request.setCharacterEncoding("utf-8");
		
		// 0. 클라이언트 전송시 search값을 받는다.
		String notice_title = request.getParameter("title");
		
		System.out.println("noticetitle:" + notice_title);
		
		// 1. service객체를 얻는다.
		INoticeService service = NoticeServiceImpl.getInstance();
		
		
		// 2. service메소드를 호출하여 결과값을 얻고 결과값을 저장한다.
		List<NoticeVO> list = null;
		
		if(notice_title == null) {
			list = (List<NoticeVO>) service.selectAllNotice();
			request.setAttribute("list", list);
			System.out.println("allNotice는 " + list);
		}else {
			list = (List<NoticeVO>) service.selectNotice_title(notice_title);
			request.setAttribute("list", list);
			System.out.println("searchNotice는 " + list);
		}
		
		// 3. request에 결과값을 저장한다.			
		request.setAttribute("notice_title", notice_title);
		System.out.println("notice title은 " + notice_title);
		
		// 4. view페이지로 이동(forward처리)
		request.getRequestDispatcher("/view/page/qna/notice_searchList.jsp").forward(request, response);
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		response.setContentType("application/json; charset=utf-8");
		
		INoticeService service = NoticeServiceImpl.getInstance();		
		
		Gson gson = new Gson();
		
		List<NoticeVO> list = service.selectAllNotice();
		
		String jsonData = gson.toJson(list);
		
		PrintWriter out = response.getWriter();
		
		out.write(jsonData);
		
		response.flushBuffer();
	}

}
