package project01_board03;

import java.sql.Date;

public class Board03 {
	private String memberName;
	private String memberDepartment;
	private int board03Number;
	private String board03Title;
	private String board03Content;
	private Date board03WriterDate;
	private int board03ViewCount;
	private	int board03ReCount;
	private	String board03Pw;
	

	public String getBoard03Pw() {
		return board03Pw;
	}
	public void setBoard03Pw(String board03Pw) {
		this.board03Pw = board03Pw;
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
	public int getBoard03Number() {
		return board03Number;
	}
	public void setBoard03Number(int board03Number) {
		this.board03Number = board03Number;
	}
	public String getBoard03Title() {
		return board03Title;
	}
	public void setBoard03Title(String board03Title) {
		this.board03Title = board03Title;
	}
	public String getBoard03Content() {
		return board03Content;
	}
	public void setBoard03Content(String board03Content) {
		this.board03Content = board03Content;
	}
	public Date getBoard03WriterDate() {
		return board03WriterDate;
	}
	public void setBoard03WriterDate(Date board03WriterDate) {
		this.board03WriterDate = board03WriterDate;
	}
	public int getBoard03ViewCount() {
		return board03ViewCount;
	}
	public void setBoard03ViewCount(int board03ViewCount) {
		this.board03ViewCount = board03ViewCount;
	}
	public int getBoard03ReCount() {
		return board03ReCount;
	}
	public void setBoard03ReCount(int board03ReCount) {
		this.board03ReCount = board03ReCount;
	}


	@Override
	public String toString() {
		return "_______________________________________________________________________________________________________________________________\r\n"
			+ "   글번호                          TITLE                                     작성자              작성일            조회수   댓글수 \r\n"
			+ "     "+board03Number
			+ "        " + board03Title
			+ "                                               " + memberDepartment+" "+ memberName
			+ "          " + board03WriterDate
			+ "            " + board03ViewCount
			+ "      " + board03ReCount
			+ "\r\n_______________________________________________________________________________________________________________________________\r\n"
			+ "\r\n         " + board03Content
			+ "\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n"
		    + "\r\n";
		//+ "글번호: " + 
	}
	
	public String selectBoardInfo() {
		return "    "+ board03Number+"     " + board03Title+"                                                    "  + memberDepartment
			+" " +memberName+"            " + board03WriterDate+"        " + board03ViewCount+"        " + board03ReCount
			+"\r\n_______________________________________________________________________________________________________________________________";
	}

}
