package project01_board02;

import java.sql.Date;

public class Board02 {
	private String memberName;
	private String memberDepartment;
	private int board02Number;
	private String board02Title;
	private String board02Content;
	private Date board02WriterDate;
	private int board02ViewCount;
	private	int board02ReCount;
	private	String board02Pw;
	

	public String getBoard02Pw() {
		return board02Pw;
	}
	public void setBoard02Pw(String board02Pw) {
		this.board02Pw = board02Pw;
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
	public int getBoard02Number() {
		return board02Number;
	}
	public void setBoard02Number(int board02Number) {
		this.board02Number = board02Number;
	}
	public String getBoard02Title() {
		return board02Title;
	}
	public void setBoard02Title(String board02Title) {
		this.board02Title = board02Title;
	}
	public String getBoard02Content() {
		return board02Content;
	}
	public void setBoard02Content(String board02Content) {
		this.board02Content = board02Content;
	}
	public Date getBoard02WriterDate() {
		return board02WriterDate;
	}
	public void setBoard02WriterDate(Date board02WriterDate) {
		this.board02WriterDate = board02WriterDate;
	}
	public int getBoard02ViewCount() {
		return board02ViewCount;
	}
	public void setBoard02ViewCount(int board02ViewCount) {
		this.board02ViewCount = board02ViewCount;
	}
	public int getBoard02ReCount() {
		return board02ReCount;
	}
	public void setBoard02ReCount(int board02ReCount) {
		this.board02ReCount = board02ReCount;
	}


	@Override
	public String toString() {
		return "글번호: " + board02Number
					+ "제목: " + board02Title
					+ "내용: " + board02Content
					+ "성명:"  + memberName
					+ "부서명: " + memberDepartment 
					+ "작성일: " + board02WriterDate
					+ "조회수: " + board02ViewCount
					+ "댓글수: " + board02ReCount;
	}

}
