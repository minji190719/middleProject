package kr.or.ddit.session.controller;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import kr.or.ddit.vo.MemberVO;

/**
 * Servlet Filter implementation class SessionFilter
 */
@WebFilter(
//		dispatcherTypes = { DispatcherType.REQUEST, DispatcherType.FORWARD },
//		servletNames = { "SignUpController" },
		urlPatterns = { "/login.do", "/signUp.do" })
public class PublicOnlyFilter implements Filter {

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
		
		HttpSession session = request.getSession(false);
		MemberVO member = (MemberVO) session.getAttribute("member");

		if (member != null) {
			/**
			 * 로그인 된 상태
			 */

			response.sendRedirect(request.getContextPath() + "/home.do");

		} else {
			/**
			 * 로그인 안 된 상태
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
