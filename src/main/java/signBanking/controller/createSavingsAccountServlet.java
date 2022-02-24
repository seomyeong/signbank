package signBanking.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import signBanking.bean.SavingsAccount;
import signBanking.data.BakingCookie;
import signBanking.service.AccountService;
@WebServlet("/view/createSavingsAccount.do")
public class createSavingsAccountServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
    public createSavingsAccountServlet() {
        super();
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		
		String balance = request.getParameter("balance");
		double doubleBalance = Double.parseDouble(request.getParameter("balance"));
		
		List<String> errorMsgs = new ArrayList<>();
		if(isEmpty(balance)) {
			errorMsgs.add("초기입금액을 넣어주세요");
		}
		
		if(!errorMsgs.isEmpty()) {
			request.setAttribute("errorMsgs", errorMsgs);
			request.getRequestDispatcher("errorMsg.jsp").forward(request, response);
			return;
		}
		
		
		// DB INSERT
		AccountService accountService = new AccountService();
		SavingsAccount sa = new SavingsAccount(doubleBalance);
		
		String userId = BakingCookie.getCookieValue("userId", request);
		
		accountService.addAccount(sa, userId);
		
		request.setAttribute("userId",userId);
		request.getRequestDispatcher("successCreateAccount.jsp").forward(request, response);
		
		
	}
	private boolean isEmpty(String param) {
		if(param == null || param.length() == 0) {
			return true;
		}
		return false;
	}

}