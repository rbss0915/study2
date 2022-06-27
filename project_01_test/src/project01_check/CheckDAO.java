package project01_check;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import project01_common.DAO;

public class CheckDAO extends DAO{
	private static CheckDAO checkDAO = null;
	private CheckDAO() {}
	public static CheckDAO getInstance() {
		if(checkDAO == null) {
			checkDAO = new CheckDAO();
		}
		return checkDAO;
	}
	
	public void insertCheck(Check check) {
		try {
			connect();
			String sql = "INSERT INTO checks "
						+ "VALUES(?, sysdate, ? )";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, check.getMemberName());
			pstmt.setDate(2, check.getCheckDate());
			pstmt.setString(3, check.getCheckIn());

			
			int result = pstmt.executeUpdate();
			
			if(result > 0) {
				System.out.println("근태처리 완료");
			}else {
				System.out.println("에러 : 다시 입력");
			}
					
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			disconnect();
		}
	}
	
	public List<Check> selectAll(){
		List<Check> list = new ArrayList<>();
		try {
			connect();
			String sql = "select name check_in, case when check_in=1 then '출근' when check_in=2 then '지각' when check_in=9 then '퇴근' else '결근' end \"check_info\" from checks";
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);
			while(rs.next()) {
				Check check = new Check();
				//check.setMemberName(rs.getString("name"));
				check.setCheckInfo(rs.getString("check_info"));
				check.setCheckIn(rs.getString("CHECK_IN"));
				//check.setMemberDepartment(rs.getString("department"));
				
				list.add(check);

			}
					
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			disconnect();
		}
		return list;
	}
	
	//검색-사원명
	public List<Check> searchCheck(String memberName){
		List<Check> list = new ArrayList<>();
		try {
			connect();
			String sql = "select * from (select name check_in, case when check_in=1 then '출근' when check_in=2 then '지각' when check_in=9 then '퇴근' else '결근' end \"check_info\" from checks) where check_in = 'aaa'";
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);
			
			while(rs.next()) {
				Check check = new Check();
				
				check.setCheckInfo(rs.getString("check_info"));
				check.setCheckIn(rs.getString("CHECK_IN"));
				
				list.add(check);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			disconnect();
		}
		return list;
	}

	public List<Check> searchCheckNon(String memberName){
		List<Check> list = new ArrayList<>();
		try {
			connect();
			String sql = "select name from checks WHERE CHECK_IN = 0;";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, memberName);
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				Check check = new Check();
				
				check.setCheckInfo(rs.getString("check_info"));
				check.setCheckIn(rs.getString("CHECK_IN"));
				
				list.add(check);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			disconnect();
		}
		return list;
	}



}
