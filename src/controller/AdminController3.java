package controller;

import javax.swing.*;
import domain.MemberBean;
import enums.Butt;
import service.AdminService2;
import serviceImpl.AdminServiceImpl2;

public class AdminController3 {
	public void start(){
		MemberBean member=null;
		AdminService2 service = new AdminServiceImpl2();//기능을 다 가지고 있으므로 무조건 생성
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
					String[] memberInfoArr=input("아이디, 비밀번호, 이름, 주민등록번호, 이메일, 프로필사진, 휴대폰번호").split(" ");
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
					MemberBean memId = service.findById(input("검색할 아이디를 입력하세요."));
					showMsg(service.exist(memId.getUid())?"회원이 존재하지 않습니다.":memId.toString());
					break;
				case FIND_BY_NAME:
					String nameResult=input("검색할 이름을 입력하세요.");
					if(service.countByName(nameResult)==0){
						showMsg("회원이 존재하지 않습니다.");
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
								"회원이 존재하지 않습니다");
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
					String[] memberRank=input("아이디, 변경할 rank를 입력하세요.").split(" ");
					member.setUid(memberRank[0]);
					member.setRank(memberRank[1]);
					service.changeRank(member);
					break;
				case DELETE:
					service.remove(input("삭제 할 아이디를 입력하세요."));
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
