package project01_board01;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import project01_common.DAO;


public class Board01DAO extends DAO{
	//싱글톤
	private static Board01DAO board01DAO = null;
	private Board01DAO() {}
	public static Board01DAO getInstance() {
		if(board01DAO == null) {
			board01DAO = new Board01DAO();
		}
		return board01DAO;
	}
	//등록
	public void insert(Board01 board01) {
		try {
			connect();
			String sql = "INSERT INTO board01(board01_num, "
					+ "board01_title, "
					+ "board01_content, "
					+ "name, "
					+ "board01_write_date, "
					+ "board01_pw) "
					
					+ "VALUES(board01_seq.nextval, "
					+ "?, "
					+ "?, "
					+ "?, "
					+ "sysdate, "
					+ "? )";
			
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, board01.getBoard01Title());
			pstmt.setString(2, board01.getBoard01Content());
			pstmt.setString(3, board01.getMemberName());
			pstmt.setString(4, board01.getBoard01Pw());

			
			int result = pstmt.executeUpdate();
			
			if(result > 0) {
				System.out.println("등록 완료");
			}else {
				System.out.println("등록 에러 : 다시 입력");
			}
					
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			disconnect();
		}
	}
	
	public void update(Board01 board01) {
		try {
			connect();
			String sql = "UPDATE board01 "
					+ "SET board01_title =?, "
					+ "board01_content =? "
					+ "WHERE board01_pw =?";
			
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, board01.getBoard01Title());
			pstmt.setString(2, board01.getBoard01Content());
			pstmt.setString(3, board01.getMemberName());

			
			int result = pstmt.executeUpdate();
			
			if(result > 0) {
				System.out.println("수정 완료");
			}else {
				System.out.println("수정 에러 : 다시 입력");
			}
					
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			disconnect();
		}
	}
	
	public void delete(Board01 board01) {
		try {
			connect();
			String sql = "DELETE FROM board01 "
					+ "WHERE board01_pw = ? ";
			
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, board01.getBoard01Pw());

			
			int result = pstmt.executeUpdate();
			
			if(result > 0) {
				System.out.println("삭제 완료");
			}else {
				System.out.println("삭제 에러");
			}
					
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			disconnect();
		}
	}
	
	public Board01 selectCheck(String Name,String board01Pw) {
		Board01 check = null;
		try {
			connect();
			String sql = "SELECT * FROM board01 WHERE name AND pw = ? ";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1,  Name);
			pstmt.setString(2,  board01Pw);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				check = new Board01();
				check.setMemberName(rs.getString("name"));
				check.setBoard01Pw(rs.getString("board01_pw"));
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			disconnect();
		}
		return check;
	}
	
	//전체조회
	public List<Board01> viewAll(){
		List<Board01> list = new ArrayList<>();
		try {
			connect();
			String sql = "SELECT * FROM board01 ORDER BY board01_num";
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);
			while(rs.next()) {
				Board01 view = new Board01();
				view.setBoard01Number(rs.getInt("board01_num"));
				view.setBoard01Title(rs.getString("board01_title"));
				view.setBoard01Content(rs.getString("board01_content"));
				view.setMemberName(rs.getString("name"));
				view.setBoard01WriterDate(rs.getDate("board01_write_date"));
				
				list.add(view);

			}
					
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			disconnect();
		}
		return list;
	}
	
	//단건
	public List<Board01> viewOne(int boardNum){
		List<Board01> list = new ArrayList<>();
		try {
			connect();
			String sql = "SELECT * FROM board01 WHERE board01_num = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, boardNum);
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				Board01 view = new Board01();
				view.setBoard01Number(rs.getInt("board01_num"));
				view.setBoard01Title(rs.getString("board01_title"));
				view.setBoard01Content(rs.getString("board01_content"));
				view.setMemberName(rs.getString("name"));
				view.setBoard01WriterDate(rs.getDate("board01_write_date"));
				
				list.add(view);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			disconnect();
		}
		return list;
	}
}
