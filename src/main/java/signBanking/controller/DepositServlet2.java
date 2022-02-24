//package signBanking.controller;
//
//import java.io.IOException;
//import java.util.ArrayList;
//import java.util.List;
//
//import javax.servlet.ServletException;
//import javax.servlet.annotation.WebServlet;
//import javax.servlet.http.HttpServlet;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//
//import signBanking.dao.AccountDao;
//
//@SuppressWarnings("serial")
//@WebServlet("/view/DepositServlet2.do")
//public class DepositServlet2 extends HttpServlet {
//	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		
//		String accountNum = request.getParameter("accountNum");
//		double amount = Double.parseDouble(request.getParameter("amount"));
//		//--
//		String amountInput = request.getParameter("amount");
//		List<String> errorMsgs = new ArrayList<>();
//		
//		if(isEmpty(amountInput)) {
//			errorMsgs.add("금액을 입력해주세요.");
//		}
//		if(!errorMsgs.isEmpty()) {
//			request.setAttribute("errorMsgs", errorMsgs);
//			request.getRequestDispatcher("/view/error/errorMsg.jsp").forward(request, response);
//			return;
//		}
//		//--
//		AccountDao accountDao = new AccountDao();
//		accountDao.deposit(accountNum, amount);
//		
//		
//		
//		request.setAttribute("accountNum", accountNum);
//		request.setAttribute("balance", amount);
//		request.getRequestDispatcher("successDeposit.jsp").forward(request, response);
//		
//		return;
//	}
//
//	
//	private boolean isEmpty(double param) {
//		if(param == 0.0) {
//			return true;
//		}
//		return false;
//	}
//	private boolean isEmpty(String param) {
//		if(param == null || param.length() == 0) {
//			return true;
//		}
//		return false;
//	}
//}



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

import signBanking.service.AccountService;

@SuppressWarnings("serial")
@WebServlet("/view/deposit2.do")
public class DepositServlet2 extends HttpServlet {
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String accountNum = request.getParameter("accountNum");
		double amount = Double.parseDouble(request.getParameter("amount"));
		List<String> errorMsgs = new ArrayList<>();
		
		if(isEmpty(amount)) {
			errorMsgs.add("금액을 입력해주세요.");
		}if(accountNum == null) {
			errorMsgs.add("계좌를 생성해주세요.");
		}
		
		if(!errorMsgs.isEmpty()) {
			request.setAttribute("errorMsgs", errorMsgs);
			request.getRequestDispatcher("/view/error/errorMsg.jsp").forward(request, response);
			return;
		}
		
		AccountService service = new AccountService();
		service.deposit(accountNum, amount);	
		
		request.setAttribute("accountNum", accountNum);
		request.setAttribute("balance", amount);
		request.getRequestDispatcher("successDeposit.jsp").forward(request, response);
		
		return;
	}

	
	private boolean isEmpty(double param) {
		if(param == 0.0) {
			return true;
		}
		return false;
	}
	
	
}