package signBanking.data;

import java.util.Random;

public class AccountNumGenerator {
	/**
	 * 4자리 - 4자리 수의 계좌번호 생성
	 * @return
	 */
	public static String generateAccountNum() {
		Random random = new Random();
		int num = 0;
		StringBuilder sb = new StringBuilder();
		for(int i = 0; i < 2; i++) {
			num = random.nextInt(10000);
			while(num < 1000) {
				num = random.nextInt(10000);
			}
			sb.append(num);
			if(i < 1) {
				sb.append("-");
			}
		}
		return sb.toString();
	}
	
	
	
	/*
	public static String outAccountNum() {
		
		
		
		
		
		
		
		String[] accNum = new String[10];
		for(int i = 0; i < 10 ; i++) {
			accNum[i]=AccountNumGenerator.generateAccountNum();
		}
		
		return accNum.toString();
		
	}*/
}