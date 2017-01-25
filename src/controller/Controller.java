package controller;

import domain.MemberBean;
import service.BankService;
import serviceImpl.BankServiceImpl;

import javax.swing.*;
import constants.Bank;
import domain.AccountBean;

public class Controller {
	public void start(){
		MemberBean member=null;
		AccountBean account=null;
		BankService service = new BankServiceImpl();//기능을 다 가지고 있으므로 무조건 생성
		String ssn="";
		int i=0;
		int temp=0;
		while(true){
			switch(input("0.종료 1.회원등록 2.통장개설 3.입금 4.출금 5.조회 6.해지")){
				case "0":return;
				case "1":
					member = new MemberBean();
					char ch=0;
					while(true){
						ssn=input("주민등록번호?");
						ch=ssn.charAt(7);
						if(ch!='1'&&ch!='2'&&ch!='3'&&ch!='4'&&ch!='5'&&ch!='6'){
							showMsg("다시입력하세요.");
						}else{
							break;
						}
					}
					member.setSsn(ssn);
					member.setUid(input("ID?"));
					member.setName(input("이름?"));
					break;
				case "2":
					String uid="";
					while(true){
						uid=input("ID?");
						if(member.getUid().equals(uid)){
							break;
						}else{
							showMsg("ID를 다시 입력하세요.\n");
						}
					}
					String accountType=input("예금종류?");
					int money=Integer.parseInt(input("입금금액?"));
					account=service.createAccount(uid,accountType,money);
					showMsg(account.toString());
					break;
				case "3":
					showMsg(service.deposit(Integer.parseInt(input("입금할 금액을 입력하세요."))));
					break;
				case "4":
					showMsg(service.withdraw(Integer.parseInt(input("출금할 금액을 입력하세요."))));
					break;
				case "5":
					showMsg("잔액은"+String.valueOf(account.getMoney())+"원입니다.");
					break;
				case "6":break;
			}
		}
	}
	public String input(String str){
		return JOptionPane.showInputDialog(str);
	}
	public void showMsg(String str){
		JOptionPane.showMessageDialog(null, str);
	}
}

