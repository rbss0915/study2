package project01_board01;

import java.sql.Date;

public class Board01 {
	private String memberName;
	private String memberDepartment;
	private int board01Number;
	private String board01Title;
	private String board01Content;
	private Date board01WriterDate;
	private int board01ViewCount;
	private	int board01ReCount;
	private	String board01Pw;
	

	public String getBoard01Pw() {
		return board01Pw;
	}
	public void setBoard01Pw(String board01Pw) {
		this.board01Pw = board01Pw;
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
	public int getBoard01Number() {
		return board01Number;
	}
	public void setBoard01Number(int board01Number) {
		this.board01Number = board01Number;
	}
	public String getBoard01Title() {
		return board01Title;
	}
	public void setBoard01Title(String board01Title) {
		this.board01Title = board01Title;
	}
	public String getBoard01Content() {
		return board01Content;
	}
	public void setBoard01Content(String board01Content) {
		this.board01Content = board01Content;
	}
	public Date getBoard01WriterDate() {
		return board01WriterDate;
	}
	public void setBoard01WriterDate(Date board01WriterDate) {
		this.board01WriterDate = board01WriterDate;
	}
	public int getBoard01ViewCount() {
		return board01ViewCount;
	}
	public void setBoard01ViewCount(int board01ViewCount) {
		this.board01ViewCount = board01ViewCount;
	}
	public int getBoard01ReCount() {
		return board01ReCount;
	}
	public void setBoard01ReCount(int board01ReCount) {
		this.board01ReCount = board01ReCount;
	}


	@Override
	public String toString() {
		return "_______________________________________________________________________________________________________________________________\r\n"
			+ "   글번호                          TITLE                                     작성자              작성일            조회수   댓글수 \r\n"
			+ "    "+board01Number+"         "+board01Title
			+"\r\n                                                                           "+memberDepartment+" "+memberName+"        "+board01WriterDate
			+ "           " +board01ViewCount+"      "+board01ReCount
			+ "\r\n_______________________________________________________________________________________________________________________________\r\n"
			+ "\r\n         " + board01Content
			+ "\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n"
		    + "\r\n";
		//+ "글번호: " + 
	}
	
	public String selectBoardInfo() {
		return "    "+board01Number+"     "+board01Title
			+"\r\n                                                                           "+memberDepartment
			+" "+memberName+"          "+board01WriterDate+"      "+board01ViewCount+"      "+board01ReCount
			+"\r\n-------------------------------------------------------------------------------------------------------------------------------";
	}

}
