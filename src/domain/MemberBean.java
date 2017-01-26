package domain;
/**
@FILE  : MemberBean.java
@DATE  : 2017. 1. 26.
@AUTHOR: Yeom Hye-Seon
@STORY :
 */
public class MemberBean {
	protected String ssn,name,uid,password,email,profileImg,phone,rank;
	public String getSsn() {
		return ssn;
	}
	public void setSsn(String ssn) {
		this.ssn = ssn;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getUid() {
		return uid;
	}
	public void setUid(String uid) {
		this.uid = uid;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getProfileImg() {
		return profileImg;
	}
	public void setProfileImg(String profileImg) {
		this.profileImg = profileImg;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getRank() {
		return rank;
	}
	public void setRank(String rank) {
		this.rank = rank;
	}
	/*//보안이 필요없는 method는 stand alone으로 작성해야한다.(종속성을 없애야 한다.)
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
	}*/
	@Override
	public String toString() {
		return String.format("%s(%s)[ %s | %s | **** | %s | %s | %s ]",name,ssn,uid,phone,email,profileImg);
	}
}
