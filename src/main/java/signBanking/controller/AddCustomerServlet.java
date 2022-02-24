
//---------- errorMsg.jsp말고 addCustomer.jsp로
package signBanking.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import signBanking.service.CustomerService;

@SuppressWarnings("serial")
@WebServlet("/view/addCustomer.do")
public class AddCustomerServlet extends HttpServlet {
       
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		
		String name = request.getParameter("name");
		String userId = request.getParameter("userId");
		String userPw = request.getParameter("userPw");
		String ssn1 = request.getParameter("ssn1");
		String ssn2 = request.getParameter("ssn2");
		String ssn = ssn1 + ssn2;
		
		
		
		List<String> errorMsgs = new ArrayList<>();
		
		
		if(isEmpty(name)) {
			request.setAttribute("nameState", "성명을 입력해주세요.");
			errorMsgs.add("성명을 입력해주세요.");
		} else {
			request.setAttribute("name", name);
		}
		if(isEmpty(userId)) {
			request.setAttribute("userIdState", "아이디를 입력해주세요.");
			errorMsgs.add("아이디를 입력해주세요.");
		} else {
			request.setAttribute("userId", userId);
		}
		if(isEmpty(userPw)) {
			request.setAttribute("userPwState", "비밀번호를 입력해주세요.");
			errorMsgs.add("비밀번호를 입력해주세요.");
		} else {
			request.setAttribute("userPw", userPw);
		}
		if(isEmpty(ssn1) || isEmpty(ssn2)) {
			request.setAttribute("ssnState", "주민등록번호를 입력해주세요.");
			errorMsgs.add("주민등록번호를 입력해주세요.");
		} else {
			request.setAttribute("ssn1", ssn1);
			request.setAttribute("ssn2", ssn2);
		}
		
		if(!errorMsgs.isEmpty()) {
			request.getRequestDispatcher("/view/addCustomer.jsp").forward(request, response);
			return;
		}
		
		// DB INSERT
		CustomerService customerService = new CustomerService();
		
		customerService.addCustomer(name, ssn, userId, userPw);
		
		request.setAttribute("name", name);
		request.getRequestDispatcher("successAddCustomer.jsp").forward(request, response);
		return;
	}

	
	private boolean isEmpty(String param) {
		if(param == null || param.length() == 0) {
			return true;
		}
		return false;
	}

}