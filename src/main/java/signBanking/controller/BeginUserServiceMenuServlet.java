package signBanking.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import signBanking.data.BakingCookie;
import signBanking.service.AccountService;
import signBanking.service.CustomerService;

@SuppressWarnings("serial")
@WebServlet("/view/userServiceMenu.do")
public class BeginUserServiceMenuServlet extends HttpServlet {

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session = request.getSession();
		
		String userId = BakingCookie.getCookieValue("userId", request);

		AccountService service = new AccountService();
		CustomerService customerService = new CustomerService();

		String totalBalance = service.findTotalBalance(userId);
		String customerName = customerService.findCustomerName(userId);

		session.setAttribute("totalBalance", totalBalance);
		session.setAttribute("customerName", customerName);

		request.getRequestDispatcher("/view/userServiceMenu.jsp").forward(request, response);

		return;
	}

}
