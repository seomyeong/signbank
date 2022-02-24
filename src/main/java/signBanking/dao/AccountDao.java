package signBanking.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import signBanking.bean.Account;
import signBanking.bean.CheckingAccount;
import signBanking.bean.SavingsAccount;
import signBanking.data.AccountNumGenerator;
import signBanking.data.DataSource;

public class AccountDao {
	DataSource ds = null;

	public AccountDao() {
		ds = DataSource.getInstance();
	}

	// 전체계좌조회
	public List<Account> allAccountInquiry(String userId) {

		String sql = "SELECT * FROM Customer";
		Connection con = ds.getConnection();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		int customerId = 0;

		try {
			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();

			while (rs.next()) {
				if (rs.getString("userId").equals(userId)) {
					customerId = rs.getInt("id");
					break;
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		sql = "SELECT * FROM Account";
		con = ds.getConnection();

		List<Account> accountList = new ArrayList<>();
		CheckingAccount account = null;

		try {
			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();

			while (rs.next()) {
				if (customerId == rs.getInt("customerId")) {
					account = new CheckingAccount();

					account.setAccountNum(rs.getString("accountNum"));
					account.setAccType(rs.getString("accType").charAt(0));
					account.setBalance(rs.getDouble("balance"));
					account.setRegDate(rs.getDate("regDate"));
					account.setOverdraftAmount(rs.getDouble("overAmount"));

					accountList.add(account);
				}
			}

			rs.close();
			pstmt.close();
			con.close();

		} catch (Exception e) {
			e.printStackTrace();
		}

		return accountList;
	}

	// Account의 customerId = Customer의 id
	public long findCustomerId(String cookie_userId) {
		DataSource ds = DataSource.getInstance();
		String sql = "SELECT id FROM Customer WHERE userId=?";

		Connection con = ds.getConnection();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		long id = 0;
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, cookie_userId);
			rs = pstmt.executeQuery();

			if (rs.next()) {
				id = rs.getLong(1);
			}

			rs.close();
			pstmt.close();
			con.close();

		} catch (Exception e) {
			e.printStackTrace();
		}

		System.out.println(id);
		return id;
	}

	// 계좌개설
	public void addAccount(Account account, String cookie_userId) {
		DataSource ds = DataSource.getInstance();
		String sql = "INSERT INTO Account(accountNum, balance, accType, interestRate, overAmount, customerId)"
				+ " VALUES(?, ?, ?, ?, ?, ?)";

		Connection con = ds.getConnection();
		PreparedStatement pstmt = null; // db에 인풋하는

		try {
			pstmt = con.prepareStatement(sql);

			pstmt.setString(1, AccountNumGenerator.generateAccountNum());
			pstmt.setDouble(2, account.getBalance());

			if (account instanceof SavingsAccount) {
				SavingsAccount sa = (SavingsAccount) account;
				pstmt.setString(3, String.valueOf('S'));
				pstmt.setDouble(4, sa.getInterestRate());
				pstmt.setDouble(5, 0.0);
			} else {
				CheckingAccount ca = (CheckingAccount) account;
				pstmt.setString(3, String.valueOf('C'));
				pstmt.setDouble(4, 0.0);
				pstmt.setDouble(5, ca.getOverdraftAmount());
			}
			pstmt.setLong(6, findCustomerId(cookie_userId));
			pstmt.executeUpdate();

			pstmt.close();
			con.close();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	// 입금
	public void deposit(String accountNum, Double amount) {
		String sql = "SELECT accountNum, balance From Account";
		Connection con = ds.getConnection();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		double balance = 0;

		try {
			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();

			while (rs.next()) {
				if (rs.getString("accountNum").equals(accountNum)) {
					balance = rs.getDouble("balance");
				}
			}

			rs.close();

		} catch (Exception e) {
			e.printStackTrace();
		}

		sql = "UPDATE Account SET balance = ? WHERE accountNum = ?";

		try {
			pstmt = con.prepareStatement(sql);

			pstmt.setDouble(1, balance + amount);
			pstmt.setString(2, accountNum);

			pstmt.executeUpdate();

			pstmt.close();
			con.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	// 출금
	public String withDraw(String accountNum, Double amount) {
		String sql = "SELECT accountNum, balance, overAmount From Account";
		Connection con = ds.getConnection();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		double balance = 0;
		double overAmount = 0;

		try {
			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();

			while (rs.next()) {
				if (rs.getString("accountNum").equals(accountNum)) {
					balance = rs.getDouble("balance");
					overAmount = rs.getDouble("overAmount");
				}
			}

			rs.close();

		} catch (Exception e) {
			e.printStackTrace();
		}

		if (balance + overAmount < amount) {
			return "입력한 출금액이 한도를 초과했습니다.";
		}

		sql = "UPDATE Account SET balance = ? WHERE accountNum = ?";

		try {
			pstmt = con.prepareStatement(sql);

			pstmt.setDouble(1, balance - amount);
			pstmt.setString(2, accountNum);

			pstmt.executeUpdate();

			pstmt.close();
			con.close();
		} catch (Exception e) {
			e.printStackTrace();
		}

		return null;
	}

	// userId와 customerId 체크
	public long useridTocustomerid(String userId) {
		DataSource ds = DataSource.getInstance();
		String sql = "SELECT id FROM Customer WHERE userId=?";

		Connection con = ds.getConnection();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		long id = 0;
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, userId);
			rs = pstmt.executeQuery();

			if (rs.next()) {
				id = rs.getLong(1);
			}

			rs.close();
			pstmt.close();
			con.close();

		} catch (Exception e) {
			e.printStackTrace();
		}

		return id;
	}

	// userServiceMenu에서 최종금액 출력시킬 메소드
	public String findTotalBalance(String userId) {
		DataSource ds = DataSource.getInstance();

		String sql = "SELECT balance FROM Account WHERE customerId=?";
		Connection con = ds.getConnection();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		double totalBalance = 0;
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setLong(1, useridTocustomerid(userId));
			rs = pstmt.executeQuery();

			while (rs.next()) {
				totalBalance += rs.getDouble("balance");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return Double.toString(totalBalance);
	}

	// 회원탈퇴 - account 계좌삭제
	public void deleteAccount(String userId) {
		DataSource ds = DataSource.getInstance();
		String sql = "DELETE FROM Account WHERE customerId=?";
		Connection con = ds.getConnection();
		PreparedStatement pstmt = null;

		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setLong(1, useridTocustomerid(userId));
			pstmt.executeUpdate();

			ds.close(pstmt, con);

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}// end of class