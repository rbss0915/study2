package project01_check;

import java.sql.Date;

public class Check {
	private String memberName;
	private String memberDepartment;
	private Date checkDate;
	private String checkIn;
	private String checkInfo;
	
	public String getCheckInfo() {
		return checkInfo;
	}
	public void setCheckInfo(String checkInfo) {
		this.checkInfo = checkInfo;
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
	public Date getCheckDate() {
		return checkDate;
	}
	public void setCheckDate(Date checkDate) {
		this.checkDate = checkDate;
	}
	public String getCheckIn() {
		return checkIn;
	}
	public void setCheckIn(String checkIn) {
		this.checkIn = checkIn;
	}
	
	@Override
	public String toString() {
		return " 사원명: " + checkIn
					+ " 근태정보: " + checkInfo
					+ " 출근일: " + checkDate;
	}


}
