package project01_board04;

import java.sql.Date;

public class Board04Re {

	//댓글
	private String memberName;
	private String memberDepartment;
	private String recontent;
	private String PwRe;
	private int board04Number;
	private Date reDate;
	
	public int getBoard04Number() {
		return board04Number;
	}
	public void setBoard04Number(int board04Number) {
		this.board04Number = board04Number;
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
		return "             ㄴRE : " + recontent
					+ "                                                            " + memberDepartment
					+ "  "  + memberName
					+ "               " + reDate +""
					+ "\r\n_______________________________________________________________________________________________________________________________";
	}
}
