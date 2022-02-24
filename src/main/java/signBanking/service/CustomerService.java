package signBanking.service;

import signBanking.bean.Customer;
import signBanking.dao.CustomerDao;

public class CustomerService {
	private CustomerDao customerDao;

	public CustomerService() {
		customerDao = new CustomerDao();
	}

	public void addCustomer(String name, String ssn, String userId, String userPw) {
		customerDao.addCustomer(name, ssn, userId, userPw);
		System.out.println("고객 등록");

	}

	public boolean login(String userId, String userPw) {
		return customerDao.login(userId, userPw);

	}

	public Customer customerUpdateForInfo(String cookie) {

		Customer customer = customerDao.customerUpdateForInfo(cookie);

		return customer;
	}

	public void customerUpdate(Customer customer, String cookies_userId) {
		if (customer == null) {
			throw new RuntimeException("Customer is null");
		}
		customerDao.customerUpdate(customer, cookies_userId);
		System.out.println("정보수정 완료");
	}// end of customerUpdate

	
	
	
	
	public String findCustomerName(String userId) {
		String name = null;
		name = customerDao.findCustomerName(userId);
		return name;
	}

	public String findCustomerPw(String userId) {
		return customerDao.findCustomerPw(userId);
	}

	public void deleteCustomer(String userId) {
		customerDao.deleteCustomer(userId);
	}

}