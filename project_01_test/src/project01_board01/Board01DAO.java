package project01_board01;

import java.sql.SQLException;

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
			String sql = "INSERT INTO board01(board01_num, "
					+ "board01_title, "
					+ "name, "
					+ "board01_write_date, "
					+ "board01_view_number) "
					
					+ "VALUES(board01_seq, "
					+ "?, "
					+ "
					
			connect();
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			disconnect();
		}
	}
}
