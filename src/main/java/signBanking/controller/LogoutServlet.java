package signBanking.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@SuppressWarnings("serial")
@WebServlet("/view/logout.do")
public class LogoutServlet extends HttpServlet {
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		session.invalidate();
		
	
		Cookie[] cookies = request.getCookies();
		
		for(Cookie c : cookies) {
			c.setMaxAge(0);
		}
		
		request.getRequestDispatcher("index.jsp").forward(request, response);
		
		return;	
	}

}
