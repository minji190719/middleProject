package kr.or.ddit.sns.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.or.ddit.sns.service.ISnsService;
import kr.or.ddit.sns.service.SnsServiceImpl;
import kr.or.ddit.vo.SnsVO;

/**
 * Servlet implementation class SnsImageView
 */
@WebServlet("/snsImageView.do")
public class SnsImageView extends HttpServlet {
   private static final long serialVersionUID = 1L;

   /**
    * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
    */
   protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
      request.setCharacterEncoding("utf-8");
      String snsNo = request.getParameter("sns_no");
      
      
      
      ISnsService service = SnsServiceImpl.getInstance();
      
      List<SnsVO> snsvo =  service.selectAllSns(); //이미지 전체리스트
      
      String fileName;
      
      
   }

   protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
      // TODO Auto-generated method stub
      doGet(request, response);
   }

}