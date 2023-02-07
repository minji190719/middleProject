package kr.or.ddit.qna.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.google.gson.Gson;

import kr.or.ddit.qna.dao.IQnaDao;
import kr.or.ddit.qna.dao.QnaDaoImpl;
import kr.or.ddit.qna.service.QnaServiceImpl;
import kr.or.ddit.qna.service.iQnaService;
import kr.or.ddit.vo.MemberVO;
import kr.or.ddit.vo.QnaVO;

/**
 * Servlet implementation class QnaInsert
 */
@WebServlet("/QnaInsert.do")
public class QnaInsert extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {


	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		response.setContentType("application/x-www-form-urlencoded; charset=utf-8");

		String prod_id = request.getParameter("prod_id");
		HttpSession session = request.getSession();
		MemberVO member = (MemberVO) session.getAttribute("member");

		String str = (member == null) ? "로그인을 해주세요." : "성공";
		
		 PrintWriter out = response.getWriter();
		 
		 out.write(str);
		 
		 response.flushBuffer();
	
//		 request.setCharacterEncoding("utf-8");
//		 response.setCharacterEncoding("utf-8");
//		 response.setContentType("application/x-www-form-urlencoded; charset=utf-8");
//		 
//		 String qna_no = request.getParameter("qna_no").trim(); String mem_id =
//		 request.getParameter("mem_id").trim(); String qna_title =
//		 request.getParameter("qna_title"); String qna_content =
//		 request.getParameter("qna_content"); System.out.println("qna_no : " +
//		 qna_no); System.out.println("mem_id : " + mem_id);
//		 System.out.println("qna_title : " + qna_title);
//		 System.out.println("qna_content : " + qna_content);
//		 
//		 
//		 QnaVO vo = new QnaVO(); iQnaService service = QnaServiceImpl.getInstance();
//		 
//		 vo.setQna_no(qna_no); vo.setMem_id(mem_id); vo.setQna_title(qna_title);
//		 vo.setQna_content(qna_content);
//		 
//		 int result = service.insertQna(vo);
//		 
//		 Gson gson = new Gson(); //인서트 후 작성한 글 상세보기 보여주기 ? ㄴㄴ
//		 
//		 String jsonData = (result == 1) ? "작성하기 성공" : "작성하기 실패";
//		 
//		 PrintWriter out = response.getWriter();
//		 
//		 out.write(jsonData);
//		 
//		 response.flushBuffer();
		
	}

}
