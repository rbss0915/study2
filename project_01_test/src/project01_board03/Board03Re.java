package project01_board03;

import java.sql.Date;

public class Board03Re {

	//댓글
	private String memberName;
	private String memberDepartment;
	private String recontent;
	private String PwRe;
	private int board03Number;
	private Date reDate;
	
	public int getBoard03Number() {
		return board03Number;
	}
	public void setBoard03Number(int board03Number) {
		this.board03Number = board03Number;
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
