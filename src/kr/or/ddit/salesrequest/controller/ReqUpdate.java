package kr.or.ddit.salesrequest.controller;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.UUID;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;

import kr.or.ddit.salesrequest.service.ISalesRequestService;
import kr.or.ddit.salesrequest.service.SalesRequestServiceImpl;
import kr.or.ddit.vo.MemberVO;
import kr.or.ddit.vo.SalesRequestVO;

@MultipartConfig
@WebServlet("/reqUpdate.do")
public class ReqUpdate extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		String reqno = request.getParameter("reqno");
		String user = request.getParameter("user");
				
		ISalesRequestService service = SalesRequestServiceImpl.getInstance();
		SalesRequestVO reqVo = service.selectSalesRequest_req_no(reqno);
		request.setAttribute("reqVo", reqVo);
		request.setAttribute("user", user);
		System.out.println("====================reqvo : " + reqVo);
		request.getRequestDispatcher("/view/page/ONUM/ReqUpdateForm.jsp").forward(request, response);

	
	}
	
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String uploadPath = "D:\\A_TeachingMaterial\\05_JQuery\\nikepro\\WebContent\\images\\usedprod";
		
		File fileUploadDir = new File(uploadPath);
		if(!fileUploadDir.exists()) {
			fileUploadDir.mkdir();
		}
		
		
		request.setCharacterEncoding("utf-8");
		String user = request.getParameter("user");
		String reqno = request.getParameter("reqno");
		String prodName = request.getParameter("prodName");
		int Origin_price = Integer.parseInt(request.getParameter("Origin_price"));
		int Req_price = Integer.parseInt(request.getParameter("Req_price"));
		String prodDetail = request.getParameter("prodDetail");
		String newPhoto = request.getParameter("newphoto");
		String oldPhoto = request.getParameter("old_photo");
		
		System.out.println("=============user>>" + user);
		
		ISalesRequestService service = SalesRequestServiceImpl.getInstance();
		
		
		SalesRequestVO reqvo = new SalesRequestVO();
		reqvo.setReq_no(reqno);
		reqvo.setOrigin_name(prodName);
		reqvo.setOrigin_price(Origin_price);
		reqvo.setReq_price(Req_price);
		reqvo.setReq_detail(prodDetail);
		reqvo.setReq_photo(oldPhoto);
		
		Part part = request.getPart("newphoto");
		
		if(part != null) {
			String photo = extractFileName(part);
			if(!"".equals(photo)) {
				String savePhoto = UUID.randomUUID().toString();
				part.write(uploadPath + File.separator + savePhoto);
				reqvo.setReq_photo(savePhoto);				
			}
		}
		
		
		//////////////////////////////////
		HttpSession session = request.getSession();
	      
	    MemberVO member = (MemberVO) session.getAttribute("member");
	        
	    String memId = member.getMem_id();
	    //////////////////////////////////////
			
		
		int cnt = service.updateSalesRequest2(reqvo);
//		response.sendRedirect(request.getContextPath() + "/view/page/ONUM/ReqList.jsp");
		
		
		response.setContentType("text/html; charset=UTF-8");
		PrintWriter out = response.getWriter();
		
		if(memId.equals("ADMIN")) {		// 관리자일 경우			

			// 경로
			String url = request.getContextPath() + "/view/page/ONUM/ReqList.jsp";
			
			
			if(cnt > 0) {		// 수정 성공시
				out.println("<script>alert('해당 판매요청이 수정되었습니다'); location.href='" + url + "';</script>");
				out.close();
			
			}else {				// 수정 실패시
				out.println("<script>alert('해당 판매요청 수정에 실패했습니다'); location.href='" + url + "';</script>");
				out.close();
				
			}
			
		}else {		// 사용자일 경우
			
			// 경로
			String url = request.getContextPath() + "/view/page/ONUM/OnumMypage.jsp";
			
			
			if( cnt > 0 ) {		// 수정 성공시
				out.println("<script>alert('해당 판매요청이 수정되었습니다'); location.href='" + url + "';</script>");
				out.close();
				
			}else {		// 수정 실패시
				out.println("<script>alert('해당 판매요청 수정에 실패했습니다. 관리자에 문의하세요'); location.href='" + url + "';</script>");
				out.close();
			}
		}
		
//		if(memId.equals("ADMIN")) {
//			System.out.println("============== 사용자간다 : " + memId); 
//			response.sendRedirect(request.getContextPath() + "/view/page/ONUM/ReqList.jsp");
//		}else {
//			response.sendRedirect(request.getContextPath() + "/view/page/ONUM/OnumMypage.jsp");			
//		}
		
		
	}
	
	
	private String extractFileName(Part part) {
		String fileName = "";
		String contentDisposition = part.getHeader("Content-Disposition");
		String[]items = contentDisposition.split(";");
		for(String item : items) {
			if(item.trim().startsWith("filename")) {
				fileName = item.substring(item.indexOf("=") + 2, item.length() -1 );
			}		
		}
		return fileName;
		
	}
	
	
	
	
}
