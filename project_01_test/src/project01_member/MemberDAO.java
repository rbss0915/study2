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
			String sql = "INSERT INTO member(id, pw, name, department, phone, email, member_date, member_num) "
						+ "VALUES(?, ?, ?, ?, ?, ?, sysdate, member_seq.nextval)";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, member.getMemberId());
			pstmt.setString(2, member.getMemberPw());
			pstmt.setString(3, member.getMemberName());
			pstmt.setString(4, member.getMemberDepartment());
			pstmt.setString(5, member.getMemberPhone());
			pstmt.setString(6, member.getMemberEmail());

			
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
						+ "SET pw = ?, "
						+ "name = ?, "
						+ "department = ?, "
						+ "phone = ?, " 
						+ "email = ? "
						+ "WHERE id = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, member.getMemberPw());
			pstmt.setString(2, member.getMemberName());
			pstmt.setString(3, member.getMemberDepartment());
			pstmt.setString(4, member.getMemberPhone());
			pstmt.setString(5, member.getMemberEmail());
			pstmt.setString(6, member.getMemberId());
			
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
	public void deleteMember(Member member) {
		try {
			connect();
			String sql = "DELETE FROM member "
						+ "WHERE id = ? AND pw = ? ";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, member.getMemberId());
			pstmt.setString(2, member.getMemberPw());
			
			int result = pstmt.executeUpdate();
			
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
	
	public Member selectCheck(String memberId, String memberPw) {
		Member member = null;
		try {
			connect();
			String sql = "SELECT * FROM member WHERE id = ? AND pw = ? ";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1,  memberId);
			pstmt.setString(2,  memberPw);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				member = new Member();
				member.setMemberId(rs.getString("id"));
				member.setMemberPw(rs.getString("pw"));
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
			String sql = "SELECT * FROM member ORDER BY department";
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);
			while(rs.next()) {
				Member member = new Member();
				member.setMemberId(rs.getString("id"));
				member.setMemberName(rs.getString("name"));
				member.setMemberDepartment(rs.getString("department"));
				member.setMemberPhone(rs.getString("phone"));
				member.setMemberEmail(rs.getString("email"));
				member.setMemberNumber(rs.getInt("member_num"));
				member.setMemberDate(rs.getDate("member_date"));
				
				list.add(member);

			}
					
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			disconnect();
		}
		return list;
	}
	//검색-사원명
	public List<Member> searchMember(String memberName){
		List<Member> list = new ArrayList<>();
		try {
			connect();
			String sql = "SELECT * FROM member WHERE name = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, memberName);
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				Member member = new Member();
				
				member.setMemberId(rs.getString("id"));
				member.setMemberName(rs.getString("name"));
				member.setMemberDepartment(rs.getString("department"));
				member.setMemberPhone(rs.getString("phone"));
				member.setMemberEmail(rs.getString("email"));
				member.setMemberNumber(rs.getInt("member_num"));
				member.setMemberDate(rs.getDate("member_date"));
				
				list.add(member);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			disconnect();
		}
		return list;
	}
	//검색-부서별
	public List<Member> searchDeparement(String memberGroup){
		List<Member> list = new ArrayList<>();
		try {
			connect();
			String sql = "SELECT * FROM member WHERE department = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, memberGroup);
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				Member member = new Member();
				member.setMemberId(rs.getString("id"));
				member.setMemberName(rs.getString("name"));
				member.setMemberDepartment(rs.getString("department"));
				member.setMemberPhone(rs.getString("phone"));
				member.setMemberEmail(rs.getString("email"));
				member.setMemberNumber(rs.getInt("member_num"));
				member.setMemberDate(rs.getDate("member_date"));
				
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
	public Member selectLogin(Member member) {
		Member loginInfo = null;
		try {
			connect();
			String sql = "SELECT * FROM member WHERE id = ?";
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1,  member.getMemberId());
			System.out.println(member.getMemberId());
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				//아이디는 존재한다는말-존재할경우
				if(rs.getString("pw").equals(member.getMemberPw())){ //입력받은거랑 같은지
						//비밀번호 일치 - >로그인 성공
						//같을경우에만
						loginInfo = new Member();
						loginInfo.setMemberId(rs.getString("id"));
						loginInfo.setMemberPw(rs.getString("pw"));
				}else {
				System.out.println("비밀번호가 일치하지 않습니다.");
				}
			}else {
				System.out.println("아이디가 존재하지 않습니다.");
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			disconnect();
		}
		
		return loginInfo;
		
	}

}



/*//단건조회 - 이름
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
				member.setMemberPhone(rs.getString("phone"));
				member.setMemberEmail(rs.getString("email"));
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			disconnect();
		}
		return member;
	}*/