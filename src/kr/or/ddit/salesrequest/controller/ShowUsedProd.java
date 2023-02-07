package kr.or.ddit.salesrequest.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.or.ddit.prod.service.IProdService;
import kr.or.ddit.prod.service.ProdServiceImpl;
import kr.or.ddit.salesrequest.dao.SalesRequestDaoImpl;
import kr.or.ddit.salesrequest.service.ISalesRequestService;
import kr.or.ddit.salesrequest.service.SalesRequestServiceImpl;
import kr.or.ddit.usedprod.dao.UsedProdDaoImpl;
import kr.or.ddit.usedprod.service.IUsedProdService;
import kr.or.ddit.usedprod.service.UsedProdServiceImpl;
import kr.or.ddit.vo.ProdVO;
import kr.or.ddit.vo.SalesRequestVO;
import kr.or.ddit.vo.UsedProdVO;

@WebServlet("/showUsedProd.do")
public class ShowUsedProd extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		String req_no = request.getParameter("reqno");
		
		
		ISalesRequestService service1 = SalesRequestServiceImpl.getInstance();
		SalesRequestVO reqvo = service1.selectSalesRequest_req_no(req_no);
		
		IUsedProdService service2 = UsedProdServiceImpl.getInstance();
		UsedProdVO uvo = service2.selectUsedProd(req_no);
		
		request.setAttribute("reqvo", reqvo);
		request.setAttribute("uvo", uvo);
		
		System.out.println("======================= reqvo: " + reqvo);
		System.out.println("======================= uvo: " + uvo);
		
		request.getRequestDispatcher("view/page/ONUM/ShowUsedProd.jsp").forward(request, response);
	
	
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
