package project01_board04;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import project01_common.DAO;


public class Board04DAO extends DAO{
	//싱글톤
	private static Board04DAO board04DAO = null;
	private Board04DAO() {}
	public static Board04DAO getInstance() {
		if(board04DAO == null) {
			board04DAO = new Board04DAO();
		}
		return board04DAO;
	}
	
	//등록
	public void insert(Board04 board04) {
		try {
			connect();
			String sql = "INSERT INTO board04(board04_num, "
					+ "board04_title, "
					+ "board04_content, "
					+ "name, "
					+ "board04_write_date, "
					+ "board04_pw) "
					
					+ "VALUES(board04_seq.nextval, "
					+ "?, "
					+ "?, "
					+ "?, "
					+ "sysdate, "
					+ "? )";
			
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, board04.getBoard04Title());
			pstmt.setString(2, board04.getBoard04Content());
			pstmt.setString(3, board04.getMemberName());
			pstmt.setString(4, board04.getBoard04Pw());

			
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
	
	public void update(Board04 board04) {
		try {
			connect();
			String sql = "UPDATE board04 "
					+ "SET board04_title =?, "
					+ "board04_content =? "
					+ "WHERE board04_pw =?";
			
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, board04.getBoard04Title());
			pstmt.setString(2, board04.getBoard04Content());
			pstmt.setString(3, board04.getBoard04Pw());

			
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
	
	public void delete(Board04 board04) {
		try {
			connect();
			String sql = "DELETE FROM board04 "
					+ "WHERE board04_pw = ?";
			
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, board04.getBoard04Pw());
			
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
	
	public Board04 selectCheck(String Name,String board04Pw) {
		Board04 check = null;
		try {
			connect();
			String sql = "SELECT * FROM board04 WHERE name AND pw = ? ";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1,  Name);
			pstmt.setString(2,  board04Pw);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				check = new Board04();
				check.setMemberName(rs.getString("name"));
				check.setBoard04Pw(rs.getString("board04_pw"));
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			disconnect();
		}
		return check;
	}
	
	//전체조회
	public List<Board04> viewAll(){
		List<Board04> list = new ArrayList<>();
		try {
			connect();
			String sql = "SELECT board04_num, board04_title, board04_content, name, board04_write_date, board04_view_number, department "
					+ "FROM board04 JOIN member "
					+ "USING (name) ORDER BY board04_num desc";
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);
			while(rs.next()) {
				Board04 view = new Board04();
				view.setBoard04Number(rs.getInt("board04_num"));
				view.setBoard04Title(rs.getString("board04_title"));
				view.setBoard04Content(rs.getString("board04_content"));
				view.setMemberName(rs.getString("name"));
				view.setBoard04WriterDate(rs.getDate("board04_write_date"));
				//view.setBoard04Pw(rs.getString("board04_pw"));
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
	public List<Board04> viewOne(int boardNum){
		List<Board04> list = new ArrayList<>();
		try {
			connect();
			String sql = "SELECT board04_num, board04_title, board04_content, name, board04_write_date, board04_view_number, board04_pw, department "
					+ "FROM board04 JOIN member "
					+ "USING (name) WHERE board04_num = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, boardNum);
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				Board04 view = new Board04();
				view.setBoard04Number(rs.getInt("board04_num"));
				view.setBoard04Title(rs.getString("board04_title"));
				view.setBoard04Content(rs.getString("board04_content"));
				view.setMemberName(rs.getString("name"));
				view.setMemberDepartment(rs.getString("department"));
				view.setBoard04WriterDate(rs.getDate("board04_write_date"));
				
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
	public List<Board04> viewSearch(String keyword){
		List<Board04> list = new ArrayList<>();
		try {
			connect();
			String sql = " SELECT board04_num, board04_title, board04_content, name, board04_write_date, board04_view_number, board04_pw, department "
					+ "FROM board04 JOIN member "
					+ "USING (name) WHERE board04_title LIKE '%" + keyword + "%'";
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);
			
			while(rs.next()) {
				Board04 view = new Board04();
				view.setBoard04Number(rs.getInt("board04_num"));
				view.setBoard04Title(rs.getString("board04_title"));
				view.setBoard04Content(rs.getString("board04_content"));
				view.setMemberName(rs.getString("name"));
				view.setBoard04WriterDate(rs.getDate("board04_write_date"));
				view.setBoard04Pw(rs.getString("board04_pw"));
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
	public List<Board04Re> viewRe(int boardNum){
			List<Board04Re> list = new ArrayList<>();
			try {
				connect();
				String sql = "SELECT board04_num, recontent04_content, name, recontent04_date, recontent04_pw, department FROM recontent04 JOIN member USING (name) WHERE board04_num = ? ORDER BY recontent04_date desc";
				pstmt = conn.prepareStatement(sql);
				pstmt.setInt(1, boardNum);
				rs = pstmt.executeQuery();
				while(rs.next()) {
					Board04Re view = new Board04Re();
					view.setBoard04Number(rs.getInt("board04_num"));
					view.setRecontent(rs.getString("recontent04_content"));
					view.setMemberName(rs.getString("name"));
					view.setReDate(rs.getDate("recontent04_date"));
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
	public List<Board04Re> viewRe2(String keyword, int board04Num){
		List<Board04Re> list = new ArrayList<>();
		try {
			connect();
			String sql = "SELECT board04_num, recontent04_content, name, recontent04_date, recontent04_pw, department FROM recontent04 JOIN member USING (name) WHERE board04_num = ? AND recontent04_content like '%'||?||'%'ORDER BY recontent04_date desc";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, board04Num);
			pstmt.setString(2, keyword);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				Board04Re view = new Board04Re();
				view.setBoard04Number(rs.getInt("board04_num"));
				view.setRecontent(rs.getString("recontent04_content"));
				view.setMemberName(rs.getString("name"));
				view.setReDate(rs.getDate("recontent04_date"));
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
	public void insertRe(Board04Re board04re) {
		try {
			connect();
			String sql = "INSERT INTO recontent04(board04_num, "
					+ "recontent04_content, "
					+ "name, "
					+ "recontent04_date, "
					+ "recontent04_pw) "
					
					+ "VALUES(?, ?, ?, sysdate, ?)";
			
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, board04re.getBoard04Number());
			pstmt.setString(2, board04re.getRecontent());
			pstmt.setString(3, board04re.getMemberName());
			//pstmt.setDate(4, board04re.getReDate());
			pstmt.setString(4, board04re.getPwRe());

			
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
	public void deleteRe(Board04Re board04Re) {
		try {
			connect();
			String sql = "DELETE FROM recontent04 "
					+ "WHERE recontent04_pw = ? ";
			
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, board04Re.getPwRe());

			
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
