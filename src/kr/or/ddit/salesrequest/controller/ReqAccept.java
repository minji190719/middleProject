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

import com.google.gson.Gson;

import kr.or.ddit.salesrequest.service.ISalesRequestService;
import kr.or.ddit.salesrequest.service.SalesRequestServiceImpl;
import kr.or.ddit.usedprod.service.IUsedProdService;
import kr.or.ddit.usedprod.service.UsedProdServiceImpl;
import kr.or.ddit.vo.SalesRequestVO;
import kr.or.ddit.vo.UsedProdVO;

@WebServlet("/reqAccept.do")
public class ReqAccept extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		response.setContentType("application/x-www-form-urlencoded; charset=utf-8");
		String reqno = request.getParameter("reqno");
		String star = request.getParameter("star"); //U_PROD_QUALITY
		System.out.println("reqno : " + reqno);
		System.out.println("star : " + star);
		//req_price => U_PROD_QUALITY
		
		
		//salesrequest에서 reqno로 select 일치하는거로 vo 셀렉트 -> 그 값에서 usedprod로 insert
		//
		
		ISalesRequestService service = SalesRequestServiceImpl.getInstance();
		SalesRequestVO vo = service.selectSalesRequest_req_no(reqno);
		System.out.println(" vo : " + vo);
		System.out.println(" vo : " + vo.getMem_id());
		System.out.println(" vo : " + vo.getOrigin_name());
		System.out.println(" vo : " + vo.getOrigin_price());
		System.out.println(" vo : " + vo.getReq_date());
		System.out.println(" vo : " + vo.getReq_no());
		
		IUsedProdService service2 = UsedProdServiceImpl.getInstance();
		
		UsedProdVO vo2 = new UsedProdVO();
		            
		vo2.setReq_no(reqno);
		vo2.setU_prod_price(vo.getReq_price());
		vo2.setU_prod_quality(star);
		
		
		int result = service2.insertUsedProd(vo2);
		
		System.out.println(result);
		
		String str = (result >= 1) ? "판매요청이 승인되었습니다" : "판매요청 승인에 실패했습니다";
		
		System.out.println(str);

		Gson gson = new Gson();
		
		String jsonData = gson.toJson(str);
		
		System.out.println(str);
		
		PrintWriter out = response.getWriter();
		
		out.write(jsonData);
		
		response.flushBuffer();
		
		
		// SALESREQUEST REQ_STATUS 변경
		Map<String, Object> map = new HashMap<String, Object>();
		
		map.put("column","req_status");
		map.put("data", 1);
		map.put("req_no", reqno);
		
		
		int cnt = service.updateSalesRequest(map);
		

	}

}
