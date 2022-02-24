package signBanking.bean;

public class SavingsAccount extends Account {
	private double interestRate = 1.8; //금리
	
	
	
	public SavingsAccount(double initBalance) {
		super(initBalance); //account클래스 초기입금액 전달
	}
	
	public void accumulateInterest() {
		balance = balance + (balance * interestRate);
	}

	public double getInterestRate() {
		return interestRate;
	}

	public void setInterestRate(double interestRate) {
		this.interestRate = interestRate;
	}

}