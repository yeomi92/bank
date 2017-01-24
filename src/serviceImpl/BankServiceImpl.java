package serviceImpl;

import java.util.Calendar;
import constants.Account;
import domain.AccountBean;
import service.BankService;
import util.RandomGenerator;

public class BankServiceImpl implements BankService{//business logic
	AccountBean[] list;//����ϰ� ��� ����(associate��������)
	public BankServiceImpl() {
		list = new AccountBean[10000];
	}
	@Override
	public AccountBean createAccount(String uid, String accountType, int money) {
		AccountBean account = new AccountBean();//����ϰ� �������� ��(dependency��������)
		account.setAccoutNo(RandomGenerator.getRandomNum(999999,100000));
		account.setCreateDate(Calendar.getInstance().get(Calendar.YEAR)+"��"+(Calendar.getInstance().get(Calendar.MONTH)+1)+"��"+Calendar.getInstance().get(Calendar.DAY_OF_MONTH)+"��");
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
