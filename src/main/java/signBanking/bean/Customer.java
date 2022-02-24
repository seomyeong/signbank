package signBanking.bean;

import java.util.Date;

public class Customer {
	private long id;
	private String name;
	private String ssn;
	private Date regDate;
	private String userId;
	private String userPw;
	
	public Customer() {
		
	}
	
	public Customer(String userId, String userPw, String name) {
		this.userId=userId;
		this.userPw=userPw;
		this.name=name;
	}
	//name찾는 생성자
	public Customer(String name) {
		this.name=name;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSsn() {
		return ssn;
	}

	public void setSsn(String ssn) {
		this.ssn = ssn;
	}

	public Date getRegDate() {
		return regDate;
	}

	public void setRegDate(Date regDate) {
		this.regDate = regDate;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getUserPw() {
		return userPw;
	}

	public void setUserPw(String userPw) {
		this.userPw = userPw;
	}
	
	
	
}
