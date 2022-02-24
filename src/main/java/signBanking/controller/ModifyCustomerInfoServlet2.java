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

import signBanking.bean.Customer;
import signBanking.service.CustomerService;

@SuppressWarnings("serial")
@WebServlet("/view/modifyCustomerInfo2.do")
public class ModifyCustomerInfoServlet2 extends HttpServlet {

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		String userId = request.getParameter("userId");
		String userPw = request.getParameter("userPw");
		String name = request.getParameter("name");
		
		List<String> errorMsgs = new ArrayList<>();
		
		if(isEmpty(userPw)) {
			errorMsgs.add("비밀번호를 입력해주세요.");
		}
		if(isEmpty(name)) {
			errorMsgs.add("이름을 입력해주세요.");
		}
		
		if(!errorMsgs.isEmpty()) {
			request.setAttribute("errorMsgs", errorMsgs);
			request.getRequestDispatcher("/view/error/errorMsg.jsp").forward(request, response);
			return;
		}

		Customer customer = new Customer();
		customer.setUserPw(userPw);
		customer.setName(name);
		
		//service호출
		CustomerService customerService = new CustomerService();
		String cookies_userId = null;
		
		
		Cookie[] cookies = request.getCookies();

		for(Cookie c : cookies) {
			if(c.getName().equals("userId")) {
				cookies_userId = c.getValue();
			}
		}
		
		customerService.customerUpdate(customer, cookies_userId);
		
		request.setAttribute("userId", userId);
		request.getRequestDispatcher("successModifyCustomerInfo.jsp").forward(request, response);
		return;
	}//end of post
	
	
	private boolean isEmpty(String param) {
		if(param == null || param.length() == 0) {
			return true;
		}
		return false;
	}

}