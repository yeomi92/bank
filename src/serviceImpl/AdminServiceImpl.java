package serviceImpl;

import domain.MemberBean;
import service.AdminService;

public class AdminServiceImpl implements AdminService{
	private MemberBean member;
	private MemberBean[] arr;
	private int count;
	public AdminServiceImpl() {
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
		int num=0;
		for(int i=0;i<count;i++){
			if(name.equals(arr[i].getName())){
				member[num]=arr[i];
				num++;
			}
		}
		return member;
	}
	@Override
	public int countByName(String name) {
		int num=0;
		for(int i=0;i<count;i++){
			if(name.equals(arr[i].getName())){
				num++;
			}
		}		
		return num;
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
		// TODO Auto-generated method stub
		
	}
	@Override
	public void remove(MemberBean member) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public boolean exist(String keyword) {
		return keyword==null;
	}
}
