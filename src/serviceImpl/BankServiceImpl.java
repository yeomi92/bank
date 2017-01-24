package serviceImpl;

import java.util.Calendar;
import constants.Account;
import domain.AccountBean;
import service.BankService;
import util.RandomGenerator;

public class BankServiceImpl implements BankService{//business logic
	AccountBean[] list;//사용하고도 계속 유지(associate연관관계)
	public BankServiceImpl() {
		list = new AccountBean[10000];
	}
	@Override
	public AccountBean createAccount(String uid, String accountType, int money) {
		AccountBean account = new AccountBean();//사용하고 버려지는 것(dependency의존관계)
		account.setAccoutNo(RandomGenerator.getRandomNum(999999,100000));
		account.setCreateDate(Calendar.getInstance().get(Calendar.YEAR)+"년"+(Calendar.getInstance().get(Calendar.MONTH)+1)+"월"+Calendar.getInstance().get(Calendar.DAY_OF_MONTH)+"일");
		account.setUid(uid);
		account.setAccountType(accountType);
		account.setMoney(money);
		list[0]=account;
		return account;
	}
	@Override
	public boolean checkmoney(int money) {
		return money>=0;
	}
	@Override
	public String deposit(int money) {
		String result=Account.DEPOSIT_FAIL;
		if(checkmoney(money)){
			list[0].setMoney(list[0].getMoney()+money);
			result=Account.DEPOSIT_SUCCESS;
		}
		return result;
	}
	@Override
	public String withdraw(int money) {
		String result=Account.WITHDRAW_FAIL;
		if(checkmoney(list[0].getMoney()-money)){
			list[0].setMoney(list[0].getMoney()-money);
			result=Account.WITHDRAW_SUCCESS;
		}
		return result;
	}
	
}
