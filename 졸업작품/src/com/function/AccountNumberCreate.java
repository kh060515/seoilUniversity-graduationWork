package com.function;

import java.util.Random;

public class AccountNumberCreate {
	public String acnum() {
		String accountNumber = "7";
		Random rand=new Random();
		for (int i = 0; i < 5; i++) {
			accountNumber=accountNumber+rand.nextInt(10);
		}
		accountNumber=accountNumber+"-";
		for (int i = 0; i < 2; i++) {
			accountNumber=accountNumber+rand.nextInt(10);
		}
		accountNumber=accountNumber+"-";
		for (int i = 0; i < 6; i++) {
			accountNumber=accountNumber+rand.nextInt(10);
		}
		
		return accountNumber;
	}
}
