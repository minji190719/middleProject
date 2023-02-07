package kr.or.ddit.prod.controller;

import java.io.IOException;
import java.time.Instant;
import java.time.OffsetDateTime;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class HomeController
 */
@WebServlet("/home.do")
public class HomeController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

//		request.setCharacterEncoding("UTF-8");
//
//		Instant timeInstant = Instant.now();
//		OffsetDateTime timeOffset = OffsetDateTime.now();
//
//		System.out.println(timeInstant + " : " + request.getRequestedSessionId());
//		System.out.println(timeOffset + " : " + request.isRequestedSessionIdValid());

		request.getRequestDispatcher("view/page/home.jsp").forward(request, response);

	}

}
