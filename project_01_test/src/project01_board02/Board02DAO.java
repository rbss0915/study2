package project01_board02;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import project01_common.DAO;


public class Board02DAO extends DAO{
	//싱글톤
	private static Board02DAO board02DAO = null;
	private Board02DAO() {}
	public static Board02DAO getInstance() {
		if(board02DAO == null) {
			board02DAO = new Board02DAO();
		}
		return board02DAO;
	}
	
	//등록
	public void insert(Board02 board02) {
		try {
			connect();
			String sql = "INSERT INTO board02(board02_num, "
					+ "board02_title, "
					+ "board02_content, "
					+ "name, "
					+ "board02_write_date, "
					+ "board02_pw) "
					
					+ "VALUES(board02_seq.nextval, "
					+ "?, "
					+ "?, "
					+ "?, "
					+ "sysdate, "
					+ "? )";
			
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, board02.getBoard02Title());
			pstmt.setString(2, board02.getBoard02Content());
			pstmt.setString(3, board02.getMemberName());
			pstmt.setString(4, board02.getBoard02Pw());

			
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
	
	public void update(Board02 board02) {
		try {
			connect();
			String sql = "UPDATE board02 "
					+ "SET board02_title =?, "
					+ "board02_content =? "
					+ "WHERE board02_pw =?";
			
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, board02.getBoard02Title());
			pstmt.setString(2, board02.getBoard02Content());
			pstmt.setString(3, board02.getBoard02Pw());

			
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
	
	public void delete(Board02 board02) {
		try {
			connect();
			String sql = "DELETE FROM board02 "
					+ "WHERE board02_pw = ?";
			
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, board02.getBoard02Pw());
			
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
	
	public Board02 selectCheck(String Name,String board02Pw) {
		Board02 check = null;
		try {
			connect();
			String sql = "SELECT * FROM board02 WHERE name AND pw = ? ";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1,  Name);
			pstmt.setString(2,  board02Pw);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				check = new Board02();
				check.setMemberName(rs.getString("name"));
				check.setBoard02Pw(rs.getString("board02_pw"));
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			disconnect();
		}
		return check;
	}
	
	//전체조회
	public List<Board02> viewAll(){
		List<Board02> list = new ArrayList<>();
		try {
			connect();
			String sql = "SELECT board02_num, board02_title, board02_content, name, board02_write_date, board02_view_number, department "
					+ "FROM board02 JOIN member "
					+ "USING (name) ORDER BY board02_num desc";
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);
			while(rs.next()) {
				Board02 view = new Board02();
				view.setBoard02Number(rs.getInt("board02_num"));
				view.setBoard02Title(rs.getString("board02_title"));
				view.setBoard02Content(rs.getString("board02_content"));
				view.setMemberName(rs.getString("name"));
				view.setBoard02WriterDate(rs.getDate("board02_write_date"));
				//view.setBoard02Pw(rs.getString("board02_pw"));
				view.setMemberDepartment(rs.getString("department"));
				
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
	public List<Board02> viewOne(int boardNum){
		List<Board02> list = new ArrayList<>();
		try {
			connect();
			String sql = "SELECT board02_num, board02_title, board02_content, name, board02_write_date, board02_view_number, board02_pw, department "
					+ "FROM board02 JOIN member "
					+ "USING (name) WHERE board02_num = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, boardNum);
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				Board02 view = new Board02();
				view.setBoard02Number(rs.getInt("board02_num"));
				view.setBoard02Title(rs.getString("board02_title"));
				view.setBoard02Content(rs.getString("board02_content"));
				view.setMemberName(rs.getString("name"));
				view.setMemberDepartment(rs.getString("department"));
				view.setBoard02WriterDate(rs.getDate("board02_write_date"));
				
				list.add(view);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			disconnect();
		}
		return list;
	}
	//검색글
	public List<Board02> viewSearch(String keyword){
		List<Board02> list = new ArrayList<>();
		try {
			connect();
			String sql = " SELECT board02_num, board02_title, board02_content, name, board02_write_date, board02_view_number, board02_pw, department "
					+ "FROM board02 JOIN member "
					+ "USING (name) WHERE board02_title LIKE '%" + keyword + "%'";
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);
			
			while(rs.next()) {
				Board02 view = new Board02();
				view.setBoard02Number(rs.getInt("board02_num"));
				view.setBoard02Title(rs.getString("board02_title"));
				view.setBoard02Content(rs.getString("board02_content"));
				view.setMemberName(rs.getString("name"));
				view.setBoard02WriterDate(rs.getDate("board02_write_date"));
				view.setBoard02Pw(rs.getString("board02_pw"));
				view.setMemberDepartment(rs.getString("department"));
				
				list.add(view);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			disconnect();
		}
		return list;
	}
	//댓글보기
	public List<Board02Re> viewRe(int boardNum){
			List<Board02Re> list = new ArrayList<>();
			try {
				connect();
				String sql = "SELECT board02_num, recontent02_content, name, recontent02_date, recontent02_pw, department FROM recontent02 JOIN member USING (name) WHERE board02_num = ? ORDER BY recontent02_date desc";
				pstmt = conn.prepareStatement(sql);
				pstmt.setInt(1, boardNum);
				rs = pstmt.executeQuery();
				while(rs.next()) {
					Board02Re view = new Board02Re();
					view.setBoard02Number(rs.getInt("board02_num"));
					view.setRecontent(rs.getString("recontent02_content"));
					view.setMemberName(rs.getString("name"));
					view.setReDate(rs.getDate("recontent02_date"));
					view.setMemberDepartment(rs.getString("department"));
					list.add(view);
				}
			}catch(SQLException e) {
				e.printStackTrace();
			}finally {
				disconnect();
			}
			return list;
		}
	/*//검색한글의 댓글
	public List<Board02Re> viewRe2(String keyword, int board02Num){
		List<Board02Re> list = new ArrayList<>();
		try {
			connect();
			String sql = "SELECT board02_num, recontent02_content, name, recontent02_date, recontent02_pw, department FROM recontent02 JOIN member USING (name) WHERE board02_num = ? AND recontent02_content like '%'||?||'%'ORDER BY recontent02_date desc";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, board02Num);
			pstmt.setString(2, keyword);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				Board02Re view = new Board02Re();
				view.setBoard02Number(rs.getInt("board02_num"));
				view.setRecontent(rs.getString("recontent02_content"));
				view.setMemberName(rs.getString("name"));
				view.setReDate(rs.getDate("recontent02_date"));
				view.setMemberDepartment(rs.getString("department"));
				list.add(view);
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			disconnect();
		}
		return list;
	}*/
	
	//댓글입력
	public void insertRe(Board02Re board02re) {
		try {
			connect();
			String sql = "INSERT INTO recontent02(board02_num, "
					+ "recontent02_content, "
					+ "name, "
					+ "recontent02_date, "
					+ "recontent02_pw) "
					
					+ "VALUES(?, ?, ?, sysdate, ?)";
			
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, board02re.getBoard02Number());
			pstmt.setString(2, board02re.getRecontent());
			pstmt.setString(3, board02re.getMemberName());
			//pstmt.setDate(4, board02re.getReDate());
			pstmt.setString(4, board02re.getPwRe());

			
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
	//댓글삭제
	public void deleteRe(Board02Re board02Re) {
		try {
			connect();
			String sql = "DELETE FROM recontent02 "
					+ "WHERE recontent02_pw = ? ";
			
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, board02Re.getPwRe());

			
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
}
