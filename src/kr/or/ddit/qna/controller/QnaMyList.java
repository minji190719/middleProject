package kr.or.ddit.qna.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.management.modelmbean.RequiredModelMBean;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.google.gson.Gson;

import kr.or.ddit.qna.service.QnaServiceImpl;
import kr.or.ddit.qna.service.iQnaService;
import kr.or.ddit.vo.MemberVO;
import kr.or.ddit.vo.QnaVO;

/**
 * Servlet implementation class QnaMyList
 */
@WebServlet("/QnaMyList.do")
public class QnaMyList extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("view/page/qna/qna_mylist.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		response.setContentType("application/json; charset=utf-8");
		
		HttpSession session = request.getSession();
		MemberVO member = (MemberVO) session.getAttribute("member");
		String mem_id = member.getMem_id();
		
		iQnaService service = QnaServiceImpl.getInstance();
		
		List<QnaVO> list = service.selectQna_mem_id(mem_id);
		System.out.println("내 문의내역 : " + list);
		Gson gson = new Gson();
		
		String jsonData = gson.toJson(list);
		
		PrintWriter out = response.getWriter();
		
		out.write(jsonData);
		
		response.flushBuffer();
		
	}

}
