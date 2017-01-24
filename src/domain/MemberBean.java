package domain;

public class MemberBean {
	private String ssn,name,uid;
	public void setSsn(String ssn){
		this.ssn=ssn;
	}
	public void setName(String name){
		
		this.name=name;
	}
	public void setId(String uid){
		this.uid= uid;
	}
	public String getSsn(){
		return ssn;
	}
	public String getName(){
		return name;
	}
	public String getUid(){
		return uid;
	}
	//보안이 필요없는 method는 stand alone으로 작성해야한다.(종속성을 없애야 한다.)
	public String calcGender(String ssn){
		String gender="";
		switch(ssn.charAt(7)){
			case '1':case '3':
				gender="남자";
				break;
			case '2':case '4':
				gender="여자";
				break;
			case '5':case '6':
				gender="외국인";
				break;
		}
			return gender;
	}
}
