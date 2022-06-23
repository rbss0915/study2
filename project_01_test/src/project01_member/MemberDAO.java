package project01_member;


import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
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
	public void insertMember(Member member) {
		try {
			connect();
			String sql = "INSERT INTO member(id,pw,name,department,email,member_date,member_num) "
						+ "VALUES(?,?,?,?,?,sysdate,member_seq.nextval)";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, member.getMemberId());
			pstmt.setString(2, member.getMemberPw());
			pstmt.setString(3, member.getMemberName());
			pstmt.setString(4, member.getMemberDepartment());
			pstmt.setString(5, member.getMemberEmail());
			pstmt.setDate(6, member.getMemberDate());
			pstmt.setInt(7, member.getMemberNumber());
			
			int result = pstmt.executeUpdate();
			
			if(result > 0) {
				System.out.println("가입 완료");
			}else {
				System.out.println("가입 에러 : 다시 입력");
			}
					
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			disconnect();
		}
	}
	
	//수정
	public void updateMember(Member member) {
		try {
			connect();
			String sql = "UPDATE member "
						+ "SET id = ? "
						+ "pw = ? "
						+ "name = ? "
						+ "department = ? "
						+ "email = ?" ;
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, member.getMemberPw());
			pstmt.setString(2, member.getMemberName());
			pstmt.setString(3, member.getMemberDepartment());
			pstmt.setString(4, member.getMemberEmail());
			
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
	
	//삭제
	public void deleteMember(int memberId) {
		try {
			connect();
			String sql = "DELETE FROM member "
						+ "WHERE id =  " + memberId;
			stmt = conn.createStatement();
			int result = stmt.executeUpdate(sql);
			
			if(result > 0) {
				System.out.println("삭제 완료");
			}else {
				System.out.println("삭제 에러 : 다시 입력");
			}
					
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			disconnect();
		}
	}
	
	//단건조회 - 이름
	public Member selectOne(String memberName) {
		Member member = null;
		try {
			connect();
			String sql = "SELECT * FROM member WHERE name = ? ";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1,  memberName);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				member = new Member();
				member.setMemberId(rs.getString("Id"));
				member.setMemberName(rs.getString("name"));
				member.setMemberDepartment(rs.getString("department"));
				member.setMemberPhone(rs.getInt("phone"));
				member.setMemberEmail(rs.getString("email"));
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			disconnect();
		}
		return member;
	}
	//전체조회
	public List<Member> selectAll(){
		List<Member> list = new ArrayList<>();
		try {
			connect();
			String sql = "SELECT * FROM member GROUP BY department";
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);
			while(rs.next()) {
				Member member = new Member();
				member.setMemberId(rs.getString("Id"));
				member.setMemberName(rs.getString("name"));
				member.setMemberDepartment(rs.getString("department"));
				member.setMemberPhone(rs.getInt("phone"));
				member.setMemberEmail(rs.getString("email"));
			}
					
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			disconnect();
		}
		return list;
	}
	//검색
	public List<Member> getList(String memberName){
		List<Member> list = new ArrayList<>();
		try {
			connect();
			String sql = "SELECT * FROM member WHERE name = ?";
			pstmt = conn.prepareStatement(sql);			
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				Member member = new Member();
				member.setMemberId(rs.getString("Id"));
				member.setMemberName(rs.getString("name"));
				member.setMemberDepartment(rs.getString("department"));
				member.setMemberPhone(rs.getInt("phone"));
				member.setMemberEmail(rs.getString("email"));
				
				list.add(member);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			disconnect();
		}
		return list;
	}
	
	//로그인
	public int login(String memberId, String memberPw) {
		String SQL = "SELECT pw FROM USER WHERE id = ?";
		try {
			pstmt = conn.prepareStatement(SQL);
			pstmt.setString(1,  memberId);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				if (rs.getString(1).contentEquals(memberPw)) {
					return 1; // 로그인 성공
				}
				else {
					return 0; // 비밀번호 불일치
				}
			}
			return -1; // 아이디가 없음
		} catch (Exception e) {
			e.printStackTrace();
		}
		return -2; // DB 오류 
	}

}
