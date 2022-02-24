package signBanking.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import signBanking.data.BakingCookie;
import signBanking.service.AccountService;
import signBanking.service.CustomerService;

/**
 * Servlet implementation class DeleteCustomerServlet
 */
@WebServlet("/view/deleteCustomer2.do")
public class DeleteCustomerServlet2 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	List<String> errorMsgs = new ArrayList<>();
    public DeleteCustomerServlet2() {super();}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		String userPw  = request.getParameter("userPw");
		String userId = BakingCookie.getCookieValue("userId", request);
		
		
		// DB INSERT
		AccountService accountService = new AccountService();
		CustomerService customerService = new CustomerService();
		
		if(customerService.findCustomerPw(userId).equals(userPw)) {
			accountService.deleteAccount(userId);
			customerService.deleteCustomer(userId);
		
			request.setAttribute(userId, userId);
			request.getRequestDispatcher("successDeleteCustomer.jsp").forward(request, response);
		
		
		} else {
			errorMsgs = new ArrayList<>();
			errorMsgs.add("비밀번호가 맞지 않습니다!");
			
			if(!errorMsgs.isEmpty()) {
				request.setAttribute("errorMsgs", errorMsgs);
				request.getRequestDispatcher("/view/error/errorMsg.jsp").forward(request, response);
				return;
			}
		}
		
	}
}