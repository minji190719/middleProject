package kr.or.ddit.sns.controller;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import java.util.UUID;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;

import com.google.gson.Gson;

import kr.or.ddit.sns.service.ISnsService;
import kr.or.ddit.sns.service.SnsServiceImpl;
import kr.or.ddit.vo.MemberVO;
import kr.or.ddit.vo.SnsVO;


@WebServlet("/snsInsert.do")
@MultipartConfig(
       fileSizeThreshold = 1024 * 1024 * 10 //10메가
       , maxFileSize = 1024 * 1024 * 30, maxRequestSize = 1024 * 1024 * 100
   )
public class SnsInsert extends HttpServlet {
   private static final long serialVersionUID = 1L;


   protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
	   
	   System.out.println("데이터 오나요");
      
      HttpSession session = request.getSession();
      
      MemberVO member = (MemberVO) session.getAttribute("member");
      
      String str = "";
      
      if (member == null) { 
    	  str = "로그인을 해주세요.";
    	  
      } else {
    	  // 사용자가 업로드한 파일이 저장될 서버쪽의 폴더 경로 설정
    	  String uploadPath = "C:\\Users\\mini0\\minji-workspace\\nikepro\\WebContent\\images\\sns";
    	  
    	  // 저장될 폴더가 없으면 생성한다.
    	  File fileUploadDir = new File(uploadPath);
    	  
    	  if(!fileUploadDir.exists()) {
    		  fileUploadDir.mkdirs();
    	  }
    	  
    	  request.setCharacterEncoding("utf-8");
    	  
    	  
    	  
    	  String memId = member.getMem_id();
    	  
    	  String snsTitle = request.getParameter("sns_title");   
    	  String snsContent = request.getParameter("sns_content"); 
    	  String prodName = request.getParameter("prod_name");
    	  
    	  
    	  System.out.println("Member:"+member);
    	  System.out.println("id:" + member.getMem_id());
    	  System.out.println("아이디 : " + memId);
    	  System.out.println("제목 : "+ snsTitle);
    	  System.out.println("내용 : " + snsContent);
    	  System.out.println("상품 이름 : " + prodName);
    	  
    	  SnsVO vo = new SnsVO();
    	  
    	  vo.setMem_id(memId);
    	  vo.setSns_title(snsTitle);
    	  vo.setSns_content(snsContent);
    	  vo.setProd_name(prodName);
    	  
    	  
    	  Part part = request.getPart("sns_photo");
    	  
    	  if(part != null) {
    		  String photo = extractFileName(part);
    		  System.out.println("photo : " + photo);
    		  //String photo = vo.getSns_title();
    		  if(!"".equals(photo)) {
    			  try {
    				  String savePhoto = UUID.randomUUID().toString();
    				  savePhoto += "." + photo.substring(photo.lastIndexOf(".") + 1);
    				  part.write(uploadPath + File.separator + savePhoto);
    				  System.out.println(savePhoto);
//                 part.write(uploadPath + File.separator + photo);
    				  vo.setSns_photo(savePhoto);
    			  }catch (IOException e) {
    				  vo.setSns_photo("실패");
    			  }
    		  }
    	  }
    	  
    	  ISnsService service = SnsServiceImpl.getInstance();
    	  
    	  int cnt = service.insertSns(vo);
    	  
    	  str = "작성 완료!";
    	  
        }
      
      
	  PrintWriter out = response.getWriter();
	
	  out.write(str);
		
	  response.flushBuffer();
        
        //-------------service에로 보내는 작업
        
        
//        String retJSON = "[\"roze\",\"jenni\",\"risa\",\"minji\"]";
//        
//        response.getWriter().write(retJSON);
        
//        response.sendRedirect(request.getContextPath() + "/nikepro/snsList.do");
//        
//        List<SnsVO> snsList = service.selectAllSns();
//        
//        request.setAttribute("snsList", snsList);
        
        //파일을 업로드할때 파일테이블에 같이 진짜이름과 가짜이름 저장(보안,데이터관리)
        //이미지 보여줄때는 셀렉트를 파일테이블에서해서 보여주기
        
        
   }

   
   
   private String extractFileName(Part part) {
      String fileName = "";
      String contentDisposition = part.getHeader("Content-Disposition");
      String[] items = contentDisposition.split(";");
      for(String item : items) {
         if(item.trim().startsWith("filename")) {
            fileName = item.substring(item.indexOf("=") + 2, item.length() -1);
         }
      }
      return fileName;
   }
   

   
   
}   
