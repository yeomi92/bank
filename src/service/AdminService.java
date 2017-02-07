package service;

import domain.MemberBean;
import java.util.*;

public interface AdminService {
	//create
	public void regist(MemberBean member);
	//read
	public MemberBean findById(String uid);
	public List<MemberBean> findByName(String name);//데이터전달은 Sequence개념이 있는 ArrayList로 보낸다.
	public Map<String,MemberBean> mapFindByName(String name);
	public List<MemberBean> memberList();//데이터전달은 Sequence개념이 있는 ArrayList로 보낸다.
	public List<MemberBean> keyList();
	public int count();
	//update
	public void update(MemberBean member);
	//remove
	//public void remove(String uid, String pw);//이렇게하면 PW가 노출된다.
	public void remove(String uid);
}