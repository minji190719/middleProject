package kr.or.ddit.review.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.or.ddit.review.service.ReviewServiceImpl;
import kr.or.ddit.review.service.iReviewService;
import kr.or.ddit.vo.ReviewVO;

/**
 * Servlet implementation class ReviewInsert_search
 */
@WebServlet("/reviewInsert_search.do")
public class ReviewInsert_search extends HttpServlet {
   private static final long serialVersionUID = 1L;
       
   protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
      response.getWriter().append("Served at: ").append(request.getContextPath());
   }

   protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
      request.setCharacterEncoding("utf-8");
      response.setCharacterEncoding("utf-8");
      response.setContentType("application/x-www-form-urlencoded; charset=utf-8");
      
      iReviewService service = ReviewServiceImpl.getInstance();
      String cart_no = request.getParameter("cart_no");
      
      ReviewVO vo_search_review = service.selectReview(cart_no);
      System.out.println("테스트1");
      
      String result = "";
      if (vo_search_review != null) {
         result = "이미 리뷰를 작성한 상품입니다.";
         
         System.out.println("테스트2");
         
         PrintWriter out = response.getWriter();
          
          out.write(result);
          
          response.flushBuffer();
          
      } else {
         result = "쓸 수 있음";
         System.out.println("테스트3");
         PrintWriter out = response.getWriter();
         
         out.write(result);
         
         response.flushBuffer();
         
      }
      
   }

}