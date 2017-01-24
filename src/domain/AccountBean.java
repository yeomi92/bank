package domain;

import constants.Bank;

public class AccountBean {
	protected int money,accoutNo;
	protected String uid,accountType,createDate;
	public int getMoney() {
		return money;
	}
	public void setMoney(int money) {
		this.money = money;
	}
	public int getAccoutNo() {
		return accoutNo;
	}
	public void setAccoutNo(int accoutNo) {
		this.accoutNo = accoutNo;
	}
	public String getUid() {
		return uid;
	}
	public void setUid(String uid) {
		this.uid = uid;
	}
	public String getAccountType() {
		return accountType;
	}
	public void setAccountType(String accountType) {
		this.accountType = accountType;
	}
	public String getCreateDate() {
		return createDate;
	}
	public void setCreateDate(String createDate) {
		this.createDate = createDate;
	}
	@Override
	public String toString() {
		return "["+Bank.BANK_NAME+"]\n계좌번호: "+accoutNo+"\n예금종류: "+accountType+"\nID: "+uid+"\n가입일: "+createDate+"\n잔액: "+money+"원";
	}
}
