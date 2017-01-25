package service;

import domain.AccountBean;

public interface BankService {
	public AccountBean createAccount(String uid,String accountType,int money);
	public boolean checkmoney(int money);
	public String deposit(int money);
	public String withdraw(int money);
	
}