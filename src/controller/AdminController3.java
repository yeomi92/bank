package controller;

import javax.swing.*;
import domain.MemberBean;
import enums.Butt;
import service.AdminService2;
import serviceImpl.AdminServiceImpl2;

public class AdminController3 {
	public void start(){
		MemberBean member=null;
		AdminService2 service = new AdminServiceImpl2();//����� �� ������ �����Ƿ� ������ ����
		int i=0;
		Butt[] buttons ={Butt.CLOSE,Butt.MEMBER_ADD,Butt.FIND_BY_ID,Butt.FIND_BY_NAME,Butt.LIST,Butt.RANK,Butt.DELETE};
		while(true){
			Butt select=(Butt)JOptionPane.showInputDialog(
					null, //frame
					"ADMIN PAGE", //frame title
					"SELECT ADMIN MENU", //order
					JOptionPane.QUESTION_MESSAGE, //type
					null, //icon
					buttons, //Array of choices
					buttons[1] //default
					);
			switch(select){
				case CLOSE:JOptionPane.showConfirmDialog(null, "EXIT Ok??");return;
				case MEMBER_ADD:
					member = new MemberBean();
					String[] memberInfoArr=input("���̵�, ��й�ȣ, �̸�, �ֹε�Ϲ�ȣ, �̸���, �����ʻ���, �޴�����ȣ").split(" ");
					member.setUid((memberInfoArr[0]));
					member.setPassword((memberInfoArr[1]));
					member.setName((memberInfoArr[2]));
					member.setSsn((memberInfoArr[3]));
					member.setEmail((memberInfoArr[4]));
					member.setProfileImg((memberInfoArr[5]));
					member.setPhone((memberInfoArr[6]));
					member.setRank("C");
					service.regist(member);
					break;
				case FIND_BY_ID:
					MemberBean memId = service.findById(input("�˻��� ���̵� �Է��ϼ���."));
					showMsg(service.exist(memId.getUid())?"ȸ���� �������� �ʽ��ϴ�.":memId.toString());
					break;
				case FIND_BY_NAME:
					String nameResult=input("�˻��� �̸��� �Է��ϼ���.");
					if(service.countByName(nameResult)==0){
						showMsg("ȸ���� �������� �ʽ��ϴ�.");
					}else{
						MemberBean[] memName = service.findByName(nameResult);
						for(i=0;i<memName.length;i++){
							nameResult+=memName[i].toString()+"\n";
						}
						showMsg(nameResult);
					}
					break;
				case LIST:
					if(service.count()==0){
						JOptionPane.showMessageDialog(null,
								"ȸ���� �������� �ʽ��ϴ�");
					}else{
						MemberBean[] arr = service.list();
						String result = "";
						for(i=0;i<service.count();i++){
							result += arr[i].toString()+"\n";
						}
						JOptionPane.showMessageDialog(null,result);
					}
					break;
				case RANK:
					String[] memberRank=input("���̵�, ������ rank�� �Է��ϼ���.").split(" ");
					member.setUid(memberRank[0]);
					member.setRank(memberRank[1]);
					service.changeRank(member);
					break;
				case DELETE:
					service.remove(input("���� �� ���̵� �Է��ϼ���."));
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
