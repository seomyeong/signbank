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

/**
 * Servlet implementation class DeleteCustomerServlet
 */
@WebServlet("/view/deleteCustomer.do")
public class DeleteCustomerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
    public DeleteCustomerServlet() {super();}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
CustomerService customerService = new CustomerService();
		
	String cookies_userId =  BakingCookie.getCookieValue("userId", request);

		
		Customer customer = customerService.customerUpdateForInfo(cookies_userId);
		
		request.setAttribute("customer", customer);
		request.getRequestDispatcher("deleteCustomer.jsp").forward(request, response);

		return;

	}
}