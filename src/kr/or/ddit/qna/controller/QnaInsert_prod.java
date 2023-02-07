package kr.or.ddit.qna.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import kr.or.ddit.qna.service.QnaServiceImpl;
import kr.or.ddit.qna.service.iQnaService;
import kr.or.ddit.vo.MemberVO;
import kr.or.ddit.vo.QnaVO;

/**
 * Servlet implementation class QnaInsert_prod
 */
@WebServlet("/QnaInsert_prod.do")
public class QnaInsert_prod extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String prod_id = request.getParameter("prod_id");
		System.out.println("도착 : " + prod_id);
		request.getRequestDispatcher("view/page/qna/qna_insert.jsp?prod_id=" + prod_id).forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		response.setContentType("application/x-www-form-urlencoded; charset=utf-8");
		
		HttpSession session = request.getSession();
	    MemberVO member = (MemberVO) session.getAttribute("member");
	    String mem_id = member.getMem_id();
		
		String qna_title = request.getParameter("qna_title");
		String qna_content = request.getParameter("qna_content");
		String prod_id = request.getParameter("prod_id");
		
		QnaVO vo = new QnaVO();
		
		vo.setMem_id(mem_id);
		vo.setProd_id(prod_id);
		vo.setQna_title(qna_title);
		vo.setQna_content(qna_content);
		
		iQnaService service = QnaServiceImpl.getInstance();
		
		int result = service.insertQna(vo);
		
		String str = (result >= 1) ? "QnA를 작성하였습니다." : "작성 실패!";
		
		PrintWriter out = response.getWriter();
		 
		out.write(str);
		 
		response.flushBuffer();
	}

}
