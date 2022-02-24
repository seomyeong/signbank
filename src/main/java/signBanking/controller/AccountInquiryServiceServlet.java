//리팩토링
package signBanking.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import signBanking.bean.Account;
import signBanking.data.BakingCookie;
import signBanking.service.AccountService;

@SuppressWarnings("serial")
@WebServlet("/view/accountInquiryService.do")
public class AccountInquiryServiceServlet extends HttpServlet {
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		AccountService service = new AccountService();
		List<Account> accountList = new ArrayList<>();
		
		String userId = BakingCookie.getCookieValue("userId", request);
		
		accountList = service.allInquiry(userId);
		
		request.setAttribute("accountList", accountList);
		request.getRequestDispatcher("accountInquiryService.jsp").forward(request, response);
		
		return;
	}

}

