package project01_board03;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import project01_common.DAO;


public class Board03DAO extends DAO{
	//싱글톤
	private static Board03DAO board03DAO = null;
	private Board03DAO() {}
	public static Board03DAO getInstance() {
		if(board03DAO == null) {
			board03DAO = new Board03DAO();
		}
		return board03DAO;
	}
	
	//등록
	public void insert(Board03 board03) {
		try {
			connect();
			String sql = "INSERT INTO board03(board03_num, "
					+ "board03_title, "
					+ "board03_content, "
					+ "name, "
					+ "board03_write_date, "
					+ "board03_pw) "
					
					+ "VALUES(board03_seq.nextval, "
					+ "?, "
					+ "?, "
					+ "?, "
					+ "sysdate, "
					+ "? )";
			
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, board03.getBoard03Title());
			pstmt.setString(2, board03.getBoard03Content());
			pstmt.setString(3, board03.getMemberName());
			pstmt.setString(4, board03.getBoard03Pw());

			
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
	
	public void update(Board03 board03) {
		try {
			connect();
			String sql = "UPDATE board03 "
					+ "SET board03_title =?, "
					+ "board03_content =? "
					+ "WHERE board03_pw =?";
			
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, board03.getBoard03Title());
			pstmt.setString(2, board03.getBoard03Content());
			pstmt.setString(3, board03.getBoard03Pw());

			
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
	
	public void delete(Board03 board03) {
		try {
			connect();
			String sql = "DELETE FROM board03 "
					+ "WHERE board03_pw = ?";
			
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, board03.getBoard03Pw());
			
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
	
	public Board03 selectCheck(String Name,String board03Pw) {
		Board03 check = null;
		try {
			connect();
			String sql = "SELECT * FROM board03 WHERE name AND pw = ? ";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1,  Name);
			pstmt.setString(2,  board03Pw);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				check = new Board03();
				check.setMemberName(rs.getString("name"));
				check.setBoard03Pw(rs.getString("board03_pw"));
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			disconnect();
		}
		return check;
	}
	
	//전체조회
	public List<Board03> viewAll(){
		List<Board03> list = new ArrayList<>();
		try {
			connect();
			String sql = "SELECT board03_num, board03_title, board03_content, name, board03_write_date, board03_view_number, department "
					+ "FROM board03 JOIN member "
					+ "USING (name) ORDER BY board03_num desc";
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);
			while(rs.next()) {
				Board03 view = new Board03();
				view.setBoard03Number(rs.getInt("board03_num"));
				view.setBoard03Title(rs.getString("board03_title"));
				view.setBoard03Content(rs.getString("board03_content"));
				view.setMemberName(rs.getString("name"));
				view.setBoard03WriterDate(rs.getDate("board03_write_date"));
				//view.setBoard03Pw(rs.getString("board03_pw"));
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
	public List<Board03> viewOne(int boardNum){
		List<Board03> list = new ArrayList<>();
		try {
			connect();
			String sql = "SELECT board03_num, board03_title, board03_content, name, board03_write_date, board03_view_number, board03_pw, department "
					+ "FROM board03 JOIN member "
					+ "USING (name) WHERE board03_num = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, boardNum);
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				Board03 view = new Board03();
				view.setBoard03Number(rs.getInt("board03_num"));
				view.setBoard03Title(rs.getString("board03_title"));
				view.setBoard03Content(rs.getString("board03_content"));
				view.setMemberName(rs.getString("name"));
				view.setMemberDepartment(rs.getString("department"));
				view.setBoard03WriterDate(rs.getDate("board03_write_date"));
				
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
	public List<Board03> viewSearch(String keyword){
		List<Board03> list = new ArrayList<>();
		try {
			connect();
			String sql = " SELECT board03_num, board03_title, board03_content, name, board03_write_date, board03_view_number, board03_pw, department "
					+ "FROM board03 JOIN member "
					+ "USING (name) WHERE board03_title LIKE '%" + keyword + "%'";
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);
			
			while(rs.next()) {
				Board03 view = new Board03();
				view.setBoard03Number(rs.getInt("board03_num"));
				view.setBoard03Title(rs.getString("board03_title"));
				view.setBoard03Content(rs.getString("board03_content"));
				view.setMemberName(rs.getString("name"));
				view.setBoard03WriterDate(rs.getDate("board03_write_date"));
				view.setBoard03Pw(rs.getString("board03_pw"));
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
	public List<Board03Re> viewRe(int boardNum){
			List<Board03Re> list = new ArrayList<>();
			try {
				connect();
				String sql = "SELECT board03_num, recontent03_content, name, recontent03_date, recontent03_pw, department FROM recontent03 JOIN member USING (name) WHERE board03_num = ? ORDER BY recontent03_date desc";
				pstmt = conn.prepareStatement(sql);
				pstmt.setInt(1, boardNum);
				rs = pstmt.executeQuery();
				while(rs.next()) {
					Board03Re view = new Board03Re();
					view.setBoard03Number(rs.getInt("board03_num"));
					view.setRecontent(rs.getString("recontent03_content"));
					view.setMemberName(rs.getString("name"));
					view.setReDate(rs.getDate("recontent03_date"));
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
	public List<Board03Re> viewRe2(String keyword, int board03Num){
		List<Board03Re> list = new ArrayList<>();
		try {
			connect();
			String sql = "SELECT board03_num, recontent03_content, name, recontent03_date, recontent03_pw, department FROM recontent03 JOIN member USING (name) WHERE board03_num = ? AND recontent03_content like '%'||?||'%'ORDER BY recontent03_date desc";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, board03Num);
			pstmt.setString(2, keyword);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				Board03Re view = new Board03Re();
				view.setBoard03Number(rs.getInt("board03_num"));
				view.setRecontent(rs.getString("recontent03_content"));
				view.setMemberName(rs.getString("name"));
				view.setReDate(rs.getDate("recontent03_date"));
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
	public void insertRe(Board03Re board03re) {
		try {
			connect();
			String sql = "INSERT INTO recontent03(board03_num, "
					+ "recontent03_content, "
					+ "name, "
					+ "recontent03_date, "
					+ "recontent03_pw) "
					
					+ "VALUES(?, ?, ?, sysdate, ?)";
			
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, board03re.getBoard03Number());
			pstmt.setString(2, board03re.getRecontent());
			pstmt.setString(3, board03re.getMemberName());
			//pstmt.setDate(4, board03re.getReDate());
			pstmt.setString(4, board03re.getPwRe());

			
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
	public void deleteRe(Board03Re board03Re) {
		try {
			connect();
			String sql = "DELETE FROM recontent03 "
					+ "WHERE recontent03_pw = ? ";
			
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, board03Re.getPwRe());

			
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
