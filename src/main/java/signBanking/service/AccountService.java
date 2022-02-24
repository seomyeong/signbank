package signBanking.service;

import java.util.ArrayList;
import java.util.List;

import signBanking.bean.Account;
import signBanking.dao.AccountDao;

public class AccountService {
	private AccountDao accountDao;

	public AccountService() {
		accountDao = new AccountDao();
	}

	public List<Account> allInquiry(String userId) {
		List<Account> accountList = new ArrayList<>();
		accountList = accountDao.allAccountInquiry(userId);
		System.out.println("전체 계좌 조회");

		return accountList;
	}

	public void deposit(String accountNum, double amount) {
		accountDao.deposit(accountNum, amount);
		System.out.println("입금 완료");
	}

	public String withDraw(String accountNum, double amount) {
		String state;
		state = accountDao.withDraw(accountNum, amount);
		System.out.println("출금 완료");

		return state;
	}

	public void addAccount(Account account, String cookie_userId) {
		accountDao.addAccount(account, cookie_userId);
	}

	public String findTotalBalance(String userId) {
		String totalBalance = null;
		totalBalance = accountDao.findTotalBalance(userId);
		return totalBalance;
	}

	// 회원탈퇴 - 계좌삭제service
	public void deleteAccount(String userId) {
		accountDao.deleteAccount(userId);
	}

}