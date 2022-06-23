package project01_member;

import java.sql.SQLException;

import project01_common.DAO;


public class MemberDAO extends DAO{
	//싱글톤
	private static MemberDAO memberDAO = null;
	private MemberDAO() {}
	public static MemberDAO getInstance() {
		if(memberDAO == null) {
			memberDAO = new MemberDAO();
		}
		return memberDAO;
	}
	
	//등록
	public void insert(Member member) {
		try {
			String sql = "INSERT INTO board01(board01_num, "
					
			connect();
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			disconnect();
		}
	}

}
