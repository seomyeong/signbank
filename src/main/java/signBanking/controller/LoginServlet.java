package signBanking.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import signBanking.service.AccountService;
import signBanking.service.CustomerService;


@SuppressWarnings("serial")
@WebServlet("/view/login.do")
public class LoginServlet extends HttpServlet {

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		
		
		String userId = request.getParameter("userId");
		String userPw = request.getParameter("userPw");
		//saveid부분 코드
		String saveId = request.getParameter("saveId");
		
		if(saveId != null && saveId.equalsIgnoreCase("on")) {
			Cookie c = new Cookie("saveId", userId);
			c.setMaxAge(60 * 60 * 24);
			response.addCookie(c);
		}else {
			Cookie[] cookies = request.getCookies();
			for(Cookie c : cookies) {
				if(c.getName().equals("saveId"));{
					c.setMaxAge(0); 
					response.addCookie(c); 
				}
			}
		}
		

		List<String> errorMsgs = new ArrayList<>();
		
		if(isEmpty(userId)) {
			errorMsgs.add("아이디를 입력하시오");
		} if(isEmpty(userPw)) {
			errorMsgs.add("비밀번호를 입력하시오");
		}
		if(!errorMsgs.isEmpty()) {
			request.setAttribute("errorMsgs", errorMsgs);
			
			request.getRequestDispatcher("/view/error/errorMsg.jsp").forward(request, response);
			return;
		}
		
		
		
		//로그인메소드 호출
		HttpSession session = request.getSession();
		
		AccountService accountService = new AccountService();
		CustomerService customerService = new CustomerService();
				
		String totalBalance = accountService.findTotalBalance(userId);
		String customerName = customerService.findCustomerName(userId);
		
		
		if(customerService.login(userId, userPw) == true) {
			
			Cookie cookie = new Cookie("userId", userId);
			cookie.setMaxAge(60 * 60 * 24);
			response.addCookie(cookie);
			
			session.setAttribute("totalBalance", totalBalance);
			session.setAttribute("customerName", customerName);
			request.getRequestDispatcher("/view/userServiceMenu.jsp").forward(request, response);
			
			response.sendRedirect("userServiceMenu.jsp");
		} else {
			errorMsgs.add("가입된 정보가 없습니다.");
			if(!errorMsgs.isEmpty()) {
				request.setAttribute("errorMsgs", errorMsgs);
				request.getRequestDispatcher("/view/error/errorMsg.jsp").forward(request, response);
				return;
			}
		}
	}
	
	
	
	
	private boolean isEmpty(String param) {
		if(param == null || param.length() == 0) {
			return true;
		}
		return false;
	}

}