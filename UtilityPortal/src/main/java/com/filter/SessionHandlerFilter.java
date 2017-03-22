package com.filter;

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

/**
 * Servlet Filter implementation class SessionHandlerFilter
 */
@WebFilter("/SessionHandlerFilter")
public class SessionHandlerFilter implements Filter {

	/**
	 * Default constructor.
	 */
	public SessionHandlerFilter() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see Filter#destroy()
	 */
	public void destroy() {
		// TODO Auto-generated method stub
	}

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		// TODO Auto-generated method stub
		// place your code here

		// pass the request along the filter chain
		HttpServletRequest req = (HttpServletRequest) request;
		HttpServletResponse res = (HttpServletResponse) response;
		HttpSession session = req.getSession(false);

		if (!(req.getServletPath().endsWith("Portal/") || req.getServletPath().endsWith("LoginPage/")
				|| req.getServletPath().endsWith("/LoginValidation"))) {
			if (session != null ? session.getAttribute("sessionID") != null : false) {
				String name = (String) session.getAttribute("sessionID");

				System.out.println("THE SESSION NAME IS \t\t" + name);

			} else {
				System.out.println("Please login first");
				req.getRequestDispatcher("/").forward(req, res);
				return;
			}

		}
		chain.doFilter(request, response);

	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}

}
