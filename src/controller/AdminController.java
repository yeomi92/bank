package controller;

import javax.swing.*;
import domain.MemberBean;
import service.AdminService;
import serviceImpl.AdminServiceImpl;

public class AdminController {
	public void start(){
		MemberBean member=null;
		AdminService service = new AdminServiceImpl();//기능을 다 가지고 있으므로 무조건 생성
		String ssn="";
		int i=0;
		int temp=0;
		while(true){
			switch(input("0.종료 1.회원등록 2.ID검색 3.이름검색 4.회원목록조회 5.회원등급조정 6.회원삭제")){
				case "0":return;
				case "1":
					member = new MemberBean();
					String[] memberInfoArr=input("아이디, 비밀번호, 이름, 주민등록번호, 이메일, 프로필사진, 휴대폰번호").split(" ");
					/*String memberInfo=input("아이디, 비밀번호, 이름, 주민등록번호, 이메일, 프로필사진, 휴대폰번호");
					String[] memberInfoArr= memberInfo.split(" ");*/
					member.setUid((memberInfoArr[0]));
					//member.setPassword((memberInfoArr[1]));
					member.setName((memberInfoArr[1]));
					/*member.setSsn((memberInfoArr[3]));
					member.setEmail((memberInfoArr[4]));
					member.setProfileImg((memberInfoArr[5]));
					member.setPhone((memberInfoArr[6]));*/
					/*member.setRank("C");*/
					service.regist(member);
					break;
				case "2":
					MemberBean memId = service.findById(input("검색할 아이디를 입력하세요."));
					showMsg(service.exist(memId.getUid())?"회원이 존재하지 않습니다.":memId.toString());
					break;
				case "3":
					MemberBean[] memName = service.findByName(input("검색할 이름을 입력하세요."));
					if(service.exist(memName[0].getName())){
						showMsg("회원이 존재하지 않습니다.");
					}else{
						String result="";
						for(i=0;i<memName.length;i++){
							result+=memName[i].toString()+"\n";
						}
						showMsg(result);
					}
					break;
				case "4":
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
