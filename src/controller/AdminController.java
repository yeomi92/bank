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
			MemberBean[] arr=service.list();
			switch(input("0.종료 1.회원등록 2.ID검색 3.이름검색 4.회원목록조회 5.회원등급조정 6.회원삭제")){
				case "0":return;
				case "1":
					member = new MemberBean();
					String[] memberInfoArr=input("아이디, 비밀번호, 이름, 주민등록번호, 이메일, 프로필사진, 휴대폰번호").split(" ");
					/*String memberInfo=input("아이디, 비밀번호, 이름, 주민등록번호, 이메일, 프로필사진, 휴대폰번호");
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
						showMsg("회원이 존재하지 않습니다.");
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
