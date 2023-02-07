package kr.or.ddit.salesrequest.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.or.ddit.salesrequest.service.ISalesRequestService;
import kr.or.ddit.salesrequest.service.SalesRequestServiceImpl;
import kr.or.ddit.usedcart.service.IUsedCartService;
import kr.or.ddit.usedprod.dao.UsedProdDaoImpl;
import kr.or.ddit.usedprod.service.IUsedProdService;
import kr.or.ddit.usedprod.service.UsedProdServiceImpl;
import kr.or.ddit.vo.SalesRequestVO;
import kr.or.ddit.vo.UsedProdVO;

// 판매요청 반려 서블릿

@WebServlet("/reqReject.do")
public class ReqReject extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		String reqno = request.getParameter("reqno");
		
		IUsedProdService usedservice = UsedProdServiceImpl.getInstance();
		ISalesRequestService reqservice = SalesRequestServiceImpl.getInstance();
		
		// Usedprod 중복검사 (이미 승인된 것인지 아닌지 검사)
		UsedProdVO vo = usedservice.selectUsedProd(reqno);
		System.out.println("=========================== vo 결과값 :  "+vo);
	
		response.setContentType("text/html; charset=UTF-8");
		PrintWriter out = response.getWriter();
		String url = request.getContextPath() + "/view/page/ONUM/ReqList.jsp";
		
		if(vo == null) { // 승인된 상품이 아님 -> status 값만 변경해주면 댐 
			
			// status 값 update 
			Map<String, Object> map = new HashMap<String, Object>();
			
			map.put("column","req_status");
			map.put("data", 2);
			map.put("req_no", reqno);
			
			SalesRequestVO vo_sales = reqservice.selectSalesRequest_req_no(reqno);
			String newName = "[반려] " + vo_sales.getOrigin_name();
			
			map.put("origin_name", newName);

			int cnt = reqservice.updateSalesRequest_re(map);
			System.out.println("=========================== update 결과값 :  "+cnt);
			
			if(cnt > 0) {		// 반려 성공시
				out.println("<script>alert('해당 판매요청이 반려되었습니다'); location.href='" + url + "';</script>");
				out.close();
			
			}else {				// 반려 실패시
				out.println("<script>alert('해당 판매요청 반려에 실패했습니다'); location.href='" + url + "';</script>");
				out.close();
				
			}
			
//			response.sendRedirect(request.getContextPath() + "/view/page/ONUM/ReqList.jsp");			
	
		}else {		// 이미 승인된 상품 -> usedprod에서 데이터 삭제, status 값 변경
			
			// usedprod 데이터 삭제
			int res = usedservice.deleteUsedProd(reqno);
			
			System.out.println("=========================== delete 결과값 :  "+res);
			
			// status 값 update 
			Map<String, Object> map = new HashMap<String, Object>();
			
			map.put("column","req_status");
			map.put("data", 2);
			map.put("req_no", reqno);
			
			
			int cnt = reqservice.updateSalesRequest(map);
			
			if(cnt > 0) {		// 반려 성공시
				out.println("<script>alert('해당 판매요청이 반려되었습니다'); location.href='" + url + "';</script>");
				out.close();
			
			}else {				// 반려 실패시
				out.println("<script>alert('해당 판매요청 반려에 실패했습니다'); location.href='" + url + "';</script>");
				out.close();
				
			}
			
			
			
//			response.sendRedirect(request.getContextPath() + "/view/page/ONUM/ReqList.jsp");						
		}
		
		
		
		
		
	}


}
