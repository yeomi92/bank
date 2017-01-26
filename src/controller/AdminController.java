package controller;

import javax.swing.*;
import domain.MemberBean;
import service.AdminService;
import serviceImpl.AdminServiceImpl;

public class AdminController {
	public void start(){
		MemberBean member=null;
		AdminService service = new AdminServiceImpl();//����� �� ������ �����Ƿ� ������ ����
		String ssn="";
		int i=0;
		int temp=0;
		while(true){
			MemberBean[] arr=service.list();
			switch(input("0.���� 1.ȸ����� 2.ID�˻� 3.�̸��˻� 4.ȸ�������ȸ 5.ȸ��������� 6.ȸ������")){
				case "0":return;
				case "1":
					member = new MemberBean();
					String[] memberInfoArr=input("���̵�, ��й�ȣ, �̸�, �ֹε�Ϲ�ȣ, �̸���, �����ʻ���, �޴�����ȣ").split(" ");
					/*String memberInfo=input("���̵�, ��й�ȣ, �̸�, �ֹε�Ϲ�ȣ, �̸���, �����ʻ���, �޴�����ȣ");
					String[] memberInfoArr= memberInfo.split(" ");*/
					member.setName((memberInfoArr[0]));
					member.setPassword((memberInfoArr[1]));/*
					member.setName((memberInfoArr[2]));
					member.setSsn((memberInfoArr[3]));
					member.setEmail((memberInfoArr[4]));
					member.setProfileImg((memberInfoArr[5]));
					member.setPhone((memberInfoArr[6]));*/
					/*member.setRank("C");*/
					service.regist(member);
					break;
				case "2":
					break;
				case "3":
					break;
				case "4":
					if(service.count()==0){
						showMsg("ȸ���� �������� �ʽ��ϴ�.");
					}else{
						String result="";
						for(;i<arr.length;i++){
							result += arr[i].toString()+"\n";
						}
						showMsg(result);
					}
					break;
				case "5":
					break;
				case "6":
					break;
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
