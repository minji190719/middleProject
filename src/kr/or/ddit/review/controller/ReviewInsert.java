package kr.or.ddit.review.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import kr.or.ddit.review.service.ReviewServiceImpl;
import kr.or.ddit.review.service.iReviewService;
import kr.or.ddit.vo.MemberVO;
import kr.or.ddit.vo.ReviewVO;

/**
 * Servlet implementation class ReviewInsert
 */
@WebServlet("/reviewInsert.do")
public class ReviewInsert extends HttpServlet {
   private static final long serialVersionUID = 1L;
       
   protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
      String cart_no = request.getParameter("cart_no");
      System.out.println("왔다");
      request.getRequestDispatcher("view/page/review/review_insert.jsp?cart_no=" + cart_no).forward(request, response);
   }

   protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
      request.setCharacterEncoding("utf-8");
      response.setCharacterEncoding("utf-8");
      response.setContentType("application/x-www-form-urlencoded; charset=utf-8");
      
      String review_title = request.getParameter("review_title");
      String review_content = request.getParameter("review_content");
      String review_rating = request.getParameter("review_rating");
      String cart_no = request.getParameter("cart_no");
      
      HttpSession session = request.getSession();
       MemberVO member = (MemberVO) session.getAttribute("member");
       String mem_id = member.getMem_id();
       
       iReviewService service = ReviewServiceImpl.getInstance();
       //이미 작성했는지 먼저 유효성 검사 ->cart_no로만 확인해도 될듯
       
       ReviewVO vo_search = service.selectReview(cart_no);
       String str = "";
       if (vo_search != null) {
          str = "이미 리뷰를 작성한 상품입니다.";
         
       } else {
          ReviewVO vo = new ReviewVO();
          
          vo.setMem_id(mem_id);
          vo.setCart_no(cart_no);
          vo.setReview_title(review_title);
          vo.setReview_content(review_content);
          vo.setReview_rating(review_rating);
          
          
          int result = service.insertReview(vo);
          
          str = (result >= 1) ? "리뷰를 작성하였습니다." : "글쓰기 실패!";
          
       }
       
          PrintWriter out = response.getWriter();
          
          out.write(str);
          
          response.flushBuffer();
          
      
   }

}