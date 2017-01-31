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
	//public void remove(String uid, String pw);//�̷����ϸ� PW�� ����ȴ�.
	public void remove(MemberBean member);
	//util
	//validation
	public boolean exist(String keyword);
}