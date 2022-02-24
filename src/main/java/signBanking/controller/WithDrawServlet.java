//package signBanking.controller;
//
//import java.io.IOException;
//import java.util.List;
//
//import javax.servlet.ServletException;
//import javax.servlet.annotation.WebServlet;
//import javax.servlet.http.HttpServlet;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//
//import signBanking.bean.Account;
//import signBanking.dao.AccountDao;
//
//@SuppressWarnings("serial")
//@WebServlet("/view/WithDrawServlet.do")
//public class WithDrawServlet extends HttpServlet {
//	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		AccountDao accountDao = new AccountDao();
//		//List<Account> accountList = accountDao.allAccountInquiry(request);
//		List<Account> accountList = accountDao.allAccountInquiry(request);
//		
//		request.setAttribute("accountList", accountList);
//		request.getRequestDispatcher("withDraw.jsp").forward(request, response);
//		
//		return;
//		
//	}
//
//}



//리팩토링
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

import signBanking.bean.Account;
import signBanking.data.BakingCookie;
import signBanking.service.AccountService;

@SuppressWarnings("serial")
@WebServlet("/view/withDraw.do")
public class WithDrawServlet extends HttpServlet {
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		AccountService service = new AccountService();
		List<Account> accountList = new ArrayList<>();
		
		String userId = BakingCookie.getCookieValue("userId", request);
		
//		Cookie[] cookies = request.getCookies();
//		
//		for(Cookie c : cookies) {
//	         if(c.getName().equals("userId")) {
//	            userId = c.getValue();
//	         }
//	    }
		
		accountList = service.allInquiry(userId);
		
		request.setAttribute("accountList", accountList);
		request.getRequestDispatcher("withDraw.jsp").forward(request, response);
		
		return;
		
	}

}