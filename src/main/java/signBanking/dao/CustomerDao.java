package signBanking.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import signBanking.bean.Customer;
import signBanking.data.DataSource;

public class CustomerDao {
	DataSource ds = DataSource.getInstance();

	// 로그인기능
	public boolean login(String userId, String userPw) {

		String sql = "SELECT userId, userPw FROM Customer";
		Connection con = ds.getConnection();
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {
			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();

			while (rs.next()) {
				if (rs.getString("userId").equals(userId) && rs.getString("userPw").equals(userPw)) {
					return true;
				}
			}
			pstmt.close();
			con.close();

		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

	// 회원가입
	public void addCustomer(String name, String ssn, String userId, String userPw) {

		String sql = "INSERT INTO Customer(name, ssn, userId, userPw) VALUES (?, ?, ?, ?) ";
		Connection con = ds.getConnection();
		PreparedStatement pstmt = null;

		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, name);
			pstmt.setString(2, ssn);
			pstmt.setString(3, userId);
			pstmt.setString(4, userPw);

			pstmt.executeUpdate();

			pstmt.close();
			con.close();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	// 로그인한 아이디의 디비값 불러오는 메소드
	public Customer customerUpdateForInfo(String cookie) {
		Connection con = ds.getConnection();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		Customer customer = null;

		try {
			String sql = "SELECT userId, userPw, name FROM Customer WHERE userId='" + cookie + "'";

			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();

			while (rs.next()) {
				String userId = rs.getString("userId");
				String userPw = rs.getString("userPw");
				String name = rs.getString("name");
				customer = new Customer(userId, userPw, name);
			}
			ds.close(rs, pstmt, con);

		} catch (Exception e) {
			e.printStackTrace();
		}
		return customer;
	}// end of customerUpdateForInfo

	// 회원정보수정 - 로그인한 아이디의 userPw, name 수정
	public void customerUpdate(Customer customer, String cookies_userId) {
		Connection con = ds.getConnection();
		PreparedStatement pstmt = null;

		try {
			String sql = "UPDATE CUSTOMER SET userPw=?, name=? WHERE userId='" + cookies_userId + "'";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, customer.getUserPw());
			pstmt.setString(2, customer.getName());
			pstmt.executeUpdate();

			ds.close(pstmt, con);

		} catch (Exception e) {
			e.printStackTrace();
		}

	}// end of customerUpdate

	// userId로 이름찾기
	public String findCustomerName(String userId) {
		String sql = "SELECT name FROM Customer WHERE userId=?";
		Connection con = ds.getConnection();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String name = null;
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, userId);
			rs = pstmt.executeQuery();

			if (rs.next()) {
				name = rs.getString(1);
			}

			ds.close(rs, pstmt, con);

		} catch (Exception e) {
			e.printStackTrace();
		}
		return name;
	}

	// userId로 비밀번호 찾기
	public String findCustomerPw(String userId) {
		String sql = "SELECT userPw FROM Customer WHERE userId=?";
		Connection con = ds.getConnection();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String userPw = null;
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, userId);
			rs = pstmt.executeQuery();

			if (rs.next()) {
				userPw = rs.getString(1);
			}

			ds.close(rs, pstmt, con);

		} catch (Exception e) {
			e.printStackTrace();
		}
		return userPw;
	}

	// 회원탈퇴 - Customer 정보 삭제
	public void deleteCustomer(String userId) {
		String sql = "DELETE FROM Customer WHERE userId=?";
		Connection con = ds.getConnection();
		PreparedStatement pstmt = null;

		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, userId);
			pstmt.executeUpdate();

			ds.close(pstmt, con);

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}// end of class