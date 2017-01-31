package service;

import domain.MemberBean;

public interface AdminService {
	//create
	public void regist(MemberBean member);
	//read
	public MemberBean findById(String uid);
	public MemberBean[] findByName(String name);
	public int countByName(String name);
	public MemberBean[] list();
	public int count();
	//update
	public void changeRank(MemberBean member);
	//remove
	//public void remove(String uid, String pw);//이렇게하면 PW가 노출된다.
	public void remove(String uid);
	//util
	//validation
	public boolean exist(String keyword);
}