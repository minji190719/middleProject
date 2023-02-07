package kr.or.ddit.salesrequest.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import kr.or.ddit.salesrequest.service.ISalesRequestService;
import kr.or.ddit.salesrequest.service.SalesRequestServiceImpl;
import kr.or.ddit.vo.MemberVO;

// 판매요청 삭제

@WebServlet("/reqDelete.do")
public class ReqDelete extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		String reqno = request.getParameter("reqno");
		
		//////////////////////////////////
		HttpSession session = request.getSession();
	      
	    MemberVO member = (MemberVO) session.getAttribute("member");
	        
	    String memId = member.getMem_id();
	    //////////////////////////////////////
	    
	    
		
		//String user = request.getParameter("user");
		
		ISalesRequestService service = SalesRequestServiceImpl.getInstance();
		
		int cnt = service.deleteSalesRequest(reqno);
		
		response.setContentType("text/html; charset=UTF-8");
		PrintWriter out = response.getWriter();
		
		if(memId.equals("ADMIN")) {		// 관리자일 경우			

			// 경로
			String url = request.getContextPath() + "/view/page/ONUM/ReqList.jsp";
			
			
			if(cnt > 0) {		// 삭제 성공시
				out.println("<script>alert('해당 판매요청이 삭제되었습니다'); location.href='" + url + "';</script>");
				out.close();
//			System.out.println("============== 사용자간다 : " + memId); 
//			response.sendRedirect(request.getContextPath() + "/view/page/ONUM/ReqList.jsp");				
			
			}else {				// 삭제 실패시
				out.println("<script>alert('기승인건은 반려 후 삭제가 가능합니다'); location.href='" + url + "';</script>");
				out.close();
//			System.out.println("============== 사용자간다 : " + memId); 
//			response.sendRedirect(request.getContextPath() + "/view/page/ONUM/ReqList.jsp");				
				
			}
			
		}else {
			
			// 경로
			String url = request.getContextPath() + "/view/page/ONUM/OnumMypage.jsp";
			
			
			if( cnt > 0 ) {		// 삭제 성공시
				out.println("<script>alert('해당 판매요청이 삭제되었습니다'); location.href='" + url + "';</script>");
				out.close();
//			response.sendRedirect(request.getContextPath() + "/view/page/ONUM/OnumMypage.jsp");			
				
			}else {		// 삭제 실패시
				out.println("<script>alert('해당 판매요청 삭제에 실패했습니다. 관리자에 문의하세요'); location.href='" + url + "';</script>");
				out.close();
//			response.sendRedirect(request.getContextPath() + "/view/page/ONUM/OnumMypage.jsp");							
			}
		}
	}

}
