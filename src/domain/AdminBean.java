package domain;

public class AdminBean extends MemberBean{
	private String permission;
	public String getPermission() {
		return permission;
	}
	public void setPermission(String permission) {
		this.permission = permission;
	}
	@Override
	public String toString() {
		return String.format("%s(%s)[ %s | %s | **** | %s | %s | °ü¸®ÀÚ ]",name,ssn,uid,phone,email);
	}
}
