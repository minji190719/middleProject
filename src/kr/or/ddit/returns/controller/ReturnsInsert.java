package kr.or.ddit.returns.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import kr.or.ddit.returns.service.IReturnsService;
import kr.or.ddit.returns.service.ReturnsServiceImpl;
import kr.or.ddit.vo.MemberVO;
import kr.or.ddit.vo.ReturnsVO;

/**
 * Servlet implementation class ReturnsInsert
 */
@WebServlet("/returnsInsert.do")
public class ReturnsInsert extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String cart_no = request.getParameter("cart_no");
		System.out.println("왔다");
		request.getRequestDispatcher("view/page/returns/returns_insert.jsp?cart_no=" + cart_no).forward(request, response);
	} 

	/**
	 * @see Http     Servlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		response.setContentType("application/x-www-form-urlencoded; charset=utf-8");
		
		String returns_title = request.getParameter("returns_title");
		String returns_content = request.getParameter("returns_content");
		String cart_no = request.getParameter("cart_no");
		System.out.println(cart_no);
		System.out.println(returns_content);
		System.out.println(returns_title);
		
		HttpSession session = request.getSession();
	    MemberVO member = (MemberVO) session.getAttribute("member");
	    String mem_id = member.getMem_id();
	    
	    ReturnsVO vo = new ReturnsVO();
	    
	    //나머진 시퀀스,시스데이트, 사진 NULL
	    vo.setMem_id(mem_id);
	    vo.setReturn_content(returns_content);
	    vo.setReturn_title(returns_title);
	    vo.setCart_no(cart_no);
	    
	    IReturnsService service = ReturnsServiceImpl.getInstance();
	    
	    int result = service.insertReturns(vo);
	    
	    String str = (result >= 1) ? "글쓰기 성공!" : "글쓰기 실패!";
	    
		PrintWriter out = response.getWriter();
		
		out.write(str);
		
		response.flushBuffer();
	    
	}

}
