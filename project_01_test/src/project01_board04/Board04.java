package project01_board04;

import java.sql.Date;

public class Board04 {
	private String memberName;
	private String memberDepartment;
	private int board04Number;
	private String board04Title;
	private String board04Content;
	private Date board04WriterDate;
	private int board04ViewCount;
	private	int board04ReCount;
	private	String board04Pw;
	

	public String getBoard04Pw() {
		return board04Pw;
	}
	public void setBoard04Pw(String board04Pw) {
		this.board04Pw = board04Pw;
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
	public int getBoard04Number() {
		return board04Number;
	}
	public void setBoard04Number(int board04Number) {
		this.board04Number = board04Number;
	}
	public String getBoard04Title() {
		return board04Title;
	}
	public void setBoard04Title(String board04Title) {
		this.board04Title = board04Title;
	}
	public String getBoard04Content() {
		return board04Content;
	}
	public void setBoard04Content(String board04Content) {
		this.board04Content = board04Content;
	}
	public Date getBoard04WriterDate() {
		return board04WriterDate;
	}
	public void setBoard04WriterDate(Date board04WriterDate) {
		this.board04WriterDate = board04WriterDate;
	}
	public int getBoard04ViewCount() {
		return board04ViewCount;
	}
	public void setBoard04ViewCount(int board04ViewCount) {
		this.board04ViewCount = board04ViewCount;
	}
	public int getBoard04ReCount() {
		return board04ReCount;
	}
	public void setBoard04ReCount(int board04ReCount) {
		this.board04ReCount = board04ReCount;
	}


	@Override
	public String toString() {
		return "_______________________________________________________________________________________________________________________________\r\n"
			+ "   글번호                          TITLE                                     작성자              작성일            조회수   댓글수 \r\n"
			+ "    "+board04Number+"         "+board04Title
			+"\r\n                                                                           "+memberDepartment+" "+memberName+"        "+board04WriterDate
			+ "           " +board04ViewCount+"      "+board04ReCount
			+ "\r\n_______________________________________________________________________________________________________________________________\r\n"
			+ "\r\n         " + board04Content
			+ "\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n"
		    + "\r\n";
		//+ "글번호: " + 
	}
	
	public String selectBoardInfo() {
		return "    "+board04Number+"     "+board04Title
			+"\r\n                                                                           "+memberDepartment
			+" "+memberName+"          "+board04WriterDate+"      "+board04ViewCount+"      "+board04ReCount
			+"\r\n-------------------------------------------------------------------------------------------------------------------------------";
	}

}
