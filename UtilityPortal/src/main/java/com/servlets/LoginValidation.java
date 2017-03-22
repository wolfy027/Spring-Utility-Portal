package com.servlets;

import java.io.IOException;
import java.net.InetAddress;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class LoginValidation
 */
@WebServlet("/LoginValidation")
public class LoginValidation extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginValidation() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
		String userName = request.getParameter("userName");
		String password = request.getParameter("password");
		if(userName.equals(password)) {
			response.sendRedirect("AutomationHome.jsp");
			HttpSession session = request.getSession();
			InetAddress addr;
			addr = InetAddress.getByName(request.getRemoteAddr());
			String sessionID = session.getId()+addr.getHostName();
			
			session.setAttribute("sessionID", sessionID);
			System.out.println(sessionID+" ===== ");
		} else {
			response.sendRedirect("jsp/LoginPage.jsp");
		}
		
	}

}
