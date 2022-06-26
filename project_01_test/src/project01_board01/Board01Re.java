package project01_board01;

import java.sql.Date;

public class Board01Re {

	//댓글
	private String memberName;
	private String memberDepartment;
	private String recontent;
	private String PwRe;
	private int board01Number;
	private Date reDate;
	
	public int getBoard01Number() {
		return board01Number;
	}
	public void setBoard01Number(int board01Number) {
		this.board01Number = board01Number;
	}
	public String getPwRe() {
		return PwRe;
	}
	public void setPwRe(String pwRe) {
		PwRe = pwRe;
	}
	public String getMemberDepartment() {
		return memberDepartment;
	}
	public void setMemberDepartment(String memberDepartment) {
		this.memberDepartment = memberDepartment;
	}
	public String getMemberName() {
		return memberName;
	}
	public void setMemberName(String memberName) {
		this.memberName = memberName;
	}
	public String getRecontent() {
		return recontent;
	}
	public void setRecontent(String recontent) {
		this.recontent = recontent;
	}
	public Date getReDate() {
		return reDate;
	}
	public void setReDate(Date reDate) {
		this.reDate = reDate;
	}
	
	@Override
	public String toString() {
		return "RE : " + recontent
					+ " 부서명 : " + memberDepartment
					+ " 성명:"  + memberName
					+ " 작성일 : " + reDate;
	}
}
