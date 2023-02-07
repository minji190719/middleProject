package kr.or.ddit.session.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.or.ddit.vo.MemberVO;

/**
 * Servlet Filter implementation class ProtectorFilter
 */
@WebFilter(
//		dispatcherTypes = { DispatcherType.REQUEST, DispatcherType.FORWARD },
//		servletNames = { "SignUpController" },
		urlPatterns = {
			"/member/myInfo.do",
			"/ONUM/myPage.do",
			"/selectAllWish.do",
			"/payment.do",
			"/selectAllCart.do",
			"/wish/insertCart.do",
			"/returnsList.do",
			"/returnsList_Admin.do"
		}
)
public class ProtectorFilter implements Filter {

	/**
	 * @see Filter#destroy()
	 */
	public void destroy() {
	}

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 * 
	 */
	public void doFilter(ServletRequest req, ServletResponse res, FilterChain chain)
			throws IOException, ServletException {

		req.setCharacterEncoding("UTF-8");
		res.setCharacterEncoding("UTF-8");

		HttpServletRequest request = (HttpServletRequest) req;
		HttpServletResponse response = (HttpServletResponse) res;

		MemberVO member = (MemberVO) request.getSession(false).getAttribute("member");

		if (member == null) {
			/**
			 * 로그인 안 된 상태
			 */

			response.setContentType("text/html; charset=UTF-8");

			PrintWriter out = response.getWriter();
			String url = request.getContextPath() + "/login.do";

			out.println("<script>alert('로그인 필요'); location.href='" + url + "';</script>");
			out.flush();
			out.close();

//			response.sendRedirect(request.getContextPath() + "/login.do");

		} else {
			/**
			 * 로그인 된 상태
			 */

			chain.doFilter(req, res);

		}

	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
	}

}
