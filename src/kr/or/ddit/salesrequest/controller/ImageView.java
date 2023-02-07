package kr.or.ddit.salesrequest.controller;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.or.ddit.salesrequest.service.ISalesRequestService;
import kr.or.ddit.salesrequest.service.SalesRequestServiceImpl;
import kr.or.ddit.vo.SalesRequestVO;

@WebServlet("/imageView.do")
public class ImageView extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		String reqno = request.getParameter("reqno");
		
		ISalesRequestService service = SalesRequestServiceImpl.getInstance();
		
		SalesRequestVO vo = service.selectSalesRequest_req_no(reqno);
		
		String fileName = vo.getReq_photo();
		if (fileName == null) {
			fileName = "noImage.png";
		}
		String imagePath = "D:\\A_TeachingMaterial\\05_JQuery\\nikepro\\WebContent\\images\\usedprod";
		
		String imageFilePath = imagePath + File.separator + fileName;
		
		File file = new File(imageFilePath);
		
		if(file.exists()) {
			BufferedOutputStream bos = new BufferedOutputStream(response.getOutputStream());
			
			BufferedInputStream bis = new BufferedInputStream(new FileInputStream(file));
			
			byte[] buffer = new byte[1024];
			int len = -1;

			while ((len = bis.read(buffer)) > 0 ) {
				bos.write(buffer, 0, len);
			}
			
		}
	
	}

}
