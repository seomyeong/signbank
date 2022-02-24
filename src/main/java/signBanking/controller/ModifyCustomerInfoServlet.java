package signBanking.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import signBanking.bean.Customer;
import signBanking.data.BakingCookie;
import signBanking.service.CustomerService;

@SuppressWarnings("serial")
@WebServlet("/view/modifyCustomerInfo.do")
public class ModifyCustomerInfoServlet extends HttpServlet {

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		CustomerService customerService = new CustomerService();
		
		String cookies_userId = BakingCookie.getCookieValue("userId", request);
		
		Customer customer = customerService.customerUpdateForInfo(cookies_userId);
		
		request.setAttribute("customer", customer);
		request.getRequestDispatcher("modifyCustomerInfo.jsp").forward(request, response);

		return;
	}
}