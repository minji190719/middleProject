package kr.or.ddit.sns.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;

import kr.or.ddit.sns.service.ISnsService;
import kr.or.ddit.sns.service.SnsServiceImpl;
import kr.or.ddit.vo.SnsVO;


@WebServlet("/snsList.do")
public class SnsList extends HttpServlet {
   private static final long serialVersionUID = 1L;

   /**
    * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
    */
   protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
      response.setCharacterEncoding("utf-8");
      ISnsService service = SnsServiceImpl.getInstance();
      
      List<SnsVO> snsList = service.selectAllSns();
      
      JsonObject job = new JsonObject();
      
      Gson gson = new Gson();
      
      JsonElement element = gson.toJsonTree(snsList);
      
      job.add("snsList", element);
      
      PrintWriter out = response.getWriter();
      
      out.print(job);
      
      
//      RequestDispatcher rd = request.getRequestDispatcher("/view/page/sns/sns.jsp");
//      rd.forward(request, response);
      
   }

   protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
      request.setCharacterEncoding("utf-8");
      response.setCharacterEncoding("utf-8");
      response.setContentType("application/json; charset=utf-8");
      
      ISnsService service = SnsServiceImpl.getInstance();
      
      List<SnsVO> list = service.selectAllSns();
      
      Gson gson = new Gson();
      
      String jsonData = gson.toJson(list);
      
      PrintWriter out = response.getWriter();
      
      out.write(jsonData);
      
      response.flushBuffer();
      
   }

}