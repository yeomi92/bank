package serviceImpl;

import domain.MemberBean;
import service.AdminService2;

public class AdminServiceImpl2 implements AdminService2{
	private MemberBean member;
	private MemberBean[] arr;
	private int count;
	public AdminServiceImpl2() {
		member = new MemberBean();
		count=0;
		arr = new MemberBean[count];
	}
	//회원정보를 입력한 후 배열에 저장하기
	@Override
	public void regist(MemberBean member) {
		if(count==arr.length){
			MemberBean[] temp = new MemberBean[count+10];
			for(int i=0;i<count;i++){
				temp[i]=arr[i];
			}
			arr=temp;
		}
		arr[count++]=member;
	}
	@Override
	public MemberBean findById(String uid) {
		MemberBean member = new MemberBean();
		for(int i=0;i<count;i++){
			if(uid.equals(arr[i].getUid())){
				member=arr[i];
				break;
			}
		}
		return member;
	}
	@Override
	public MemberBean[] findByName(String name) {
		MemberBean[] member = new MemberBean[countByName(name)];
		int nameCount=0;
		for(int i=0;i<count;i++){
			if(name.equals(arr[i].getName())){
				member[nameCount]=arr[i];
				nameCount++;
			}
		}
		return member;
	}
	@Override
	public int countByName(String name) {
		int nameCount=0;
		for(int i=0;i<count;i++){
			if(name.equals(arr[i].getName())){
				nameCount++;
			}
		}		
		return nameCount;
	}
	//전체목록출력
	@Override
	public MemberBean[] list() {
		return arr;
	}
	@Override
	public int count() {
		return count;
	}
	@Override
	public void changeRank(MemberBean member) {
		for(int i=0;i<count;i++){
			if(member.getUid().equals(arr[i].getUid())){
				arr[i].setRank(member.getRank());
				return;
			}
		}
	}
	@Override
	public void remove(String uid) {
		for(int i=0;i<count;i++){
			if(uid.equals(arr[i].getUid())){
				arr[i]=arr[count-1];
				count--;
				return;
			}
		}		
	}
	@Override
	public boolean exist(String keyword) {
		return keyword==null;
	}
}
