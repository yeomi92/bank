package domain;

import constants.Bank;

public class AccountBean {
	protected String uid,accountType,createDate,money,accoutNo;
	public String getMoney() {
		return money;
	}
	public void setMoney(String money) {
		this.money = money;
	}
	public String getAccoutNo() {
		return accoutNo;
	}
	public void setAccoutNo(String accoutNo) {
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
		return "["+Bank.BANK_NAME+"]\n���¹�ȣ: "+accoutNo+"\n��������: "+accountType+"\nID: "+uid+"\n������: "+createDate+"\n�ܾ�: "+money+"��";
	}
}
