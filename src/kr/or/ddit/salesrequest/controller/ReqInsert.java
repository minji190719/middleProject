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
import javax.servlet.http.Part;

import com.google.gson.Gson;

import kr.or.ddit.salesrequest.service.ISalesRequestService;
import kr.or.ddit.salesrequest.service.SalesRequestServiceImpl;
import kr.or.ddit.vo.SalesRequestVO;

@MultipartConfig
@WebServlet("/reqInsert.do")
public class ReqInsert extends HttpServlet {
	private static final long serialVersionUID = 1L;
 
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		// 사용자가 업로드한 파일이 저장될 서버쪽의 폴더 경로 설정
		String uploadPath = "C:\\eclipse\\WebWorkspace\\nikepro\\WebContent\\images\\usedprod";
		
		// 저장될 폴더가 없으면 생성한다.
		File fileUploadDir = new File(uploadPath);
		if (!fileUploadDir.exists()) {
			fileUploadDir.mkdirs();
		}
		
     	String mem_id       = request.getParameter("mem_id");
     	String origin_name  = request.getParameter("origin_name");
     	String origin_price = request.getParameter("origin_price");
     	String req_price    = request.getParameter("req_price" );
     	String req_photo    = request.getParameter("req_photo");
     	String req_detail   = request.getParameter("req_detail");

     	System.out.println("==========>>" + mem_id      );
     	System.out.println("==========>>" + origin_name );
     	System.out.println("==========>>" + origin_price);
     	System.out.println("==========>>" + req_price   );
     	System.out.println("==========>> 사진사진사진사진 : " + req_photo   );
     	System.out.println("==========>>" + req_detail  );
     	
     	SalesRequestVO vo = new SalesRequestVO();
		vo.setMem_id(mem_id);
		vo.setOrigin_name(origin_name);
		vo.setOrigin_price(Integer.parseInt(origin_price));
		vo.setReq_price(Integer.parseInt(req_price));
		vo.setReq_photo(req_photo);
		vo.setReq_detail(req_detail);
		
		System.out.println("========== vo >>" + vo);
		
		
		// form의 file입력 요소의 name값을 이용하여 Part객체 구하기
		Part part = request.getPart("req_photo");
		
		if(part != null) {
			String photo = extractFileName(part);
			if(!"".equals(photo)) {
				try {
					String savePhoto = UUID.randomUUID().toString();
					part.write(uploadPath + File.separator + savePhoto);
					vo.setReq_photo(savePhoto);
				}catch(IOException e) {
					vo.setReq_photo(null);
				}
			}
				
		}
		
		ISalesRequestService service = SalesRequestServiceImpl.getInstance();
		
		int cnt = service.insertSalesRequest(vo);
				
		System.out.println("========== 업로드 결과값 >>" + cnt);
		
		Gson gson = new Gson();
		String jsonData = gson.toJson(cnt);
		
		response.setContentType("application/json; charset=utf-8");	// 응답을 JSON으로 하겠다는 설정
		PrintWriter out = response.getWriter();
		
		out.write(jsonData);
		
		response.flushBuffer();
	}
	
	private String extractFileName(Part part) {
		String fileName = ""; 
		String contentDisposition = part.getHeader("Content-Disposition");
		String[] items = contentDisposition.split(";");
		for (String item : items) {
			if (item.trim().startsWith("filename")) {
				fileName = item.substring(item.indexOf("=") + 2, item.length() - 1);
			}
		}
		return fileName;
	}

}
