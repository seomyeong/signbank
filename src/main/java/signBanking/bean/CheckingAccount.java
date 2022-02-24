package signBanking.bean;

public class CheckingAccount extends Account{
	
	public CheckingAccount() {}
	
	private double overdraftAmount = 5000000; //500만원
	
	public CheckingAccount(double initBalance) {
		super(initBalance);
	}

	public double getOverdraftAmount() {
		return overdraftAmount;
	}

	public void setOverdraftAmount(double overdraftAmount) {
		this.overdraftAmount = overdraftAmount;
	}
	
}