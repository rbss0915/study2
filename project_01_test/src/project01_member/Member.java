package project01_member;

import java.sql.Date;

public class Member {
	private String memberId;
	private String memberName;
	private String memberDepartment;
	private int memberPhone;
	private String memberEmail;
	private Date memberDate;
	private int memberNumber;
	
	
	public String getMemberId() {
		return memberId;
	}
	public void setMemberId(String memberId) {
		this.memberId = memberId;
	}
	public String getMemberName() {
		return memberName;
	}
	public void setMemberName(String memberName) {
		this.memberName = memberName;
	}
	public String getMemberDepartment() {
		return memberDepartment;
	}
	public void setMemberDepartment(String memberDepartment) {
		this.memberDepartment = memberDepartment;
	}
	public int getMemberPhone() {
		return memberPhone;
	}
	public void setMemberPhone(int memberPhone) {
		this.memberPhone = memberPhone;
	}
	public String getMemberEmail() {
		return memberEmail;
	}
	public void setMemberEmail(String memberEmail) {
		this.memberEmail = memberEmail;
	}
	public Date getMemberDate() {
		return memberDate;
	}
	public void setMemberDate(Date memberDate) {
		this.memberDate = memberDate;
	}
	public int getMemberNumber() {
		return memberNumber;
	}
	public void setMemberNumber(int memberNumber) {
		this.memberNumber = memberNumber;
	}
	
	

}
