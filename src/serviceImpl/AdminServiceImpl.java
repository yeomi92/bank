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
			//System.arraycopy(arr, 0, temp, 0, count);
			arr=temp;
		}
		arr[count++]=member;
	}
	@Override
	public MemberBean findById(String uid) {
		return null;
	}
	@Override
	public MemberBean[] findByName(String name) {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public int countByName(String name) {
		// TODO Auto-generated method stub
		return 0;
	}
	//전체목록출력
	@Override
	public MemberBean[] list() {
		arr = new MemberBean[count];
		return arr;
	}
	@Override
	public int count() {
		return arr.length;
	}
	@Override
	public void changeRank(MemberBean member) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void remove(MemberBean member) {
		// TODO Auto-generated method stub
		
	}//Business Logic
}
