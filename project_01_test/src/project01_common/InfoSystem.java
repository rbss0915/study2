package project01_common;


import project01_member.Member;
import project01_member.MemberDAO;

public class InfoSystem extends MainSystem{
	
	public InfoSystem(){
		menuPrint();
		while(true) {
			int menuNo = menuSelect();
			if(menuNo == 1) {
				//정보포탈
				menuInfo();
				InfoPortal();
			}else if(menuNo == 2) {
				//게시판
				
			}else if(menuNo == 9) {
				//뒤로가기
				back();
				break;
			}else {
				showInputError();
			}
		}
	}
	
	private void InfoPortal() {
		while(true) {
			int menuNo = menuSelect();
			
			if(menuNo == 1) {
				//수정
				updateMemberTrue();
			}else if(menuNo == 2) {
				//탈퇴
				deleteMemberTrue();
			}else if(menuNo == 9) {
				//뒤로가기
				back();
				break;
			}else {
				showInputError();
			}
			
		}
	}
	@Override
	protected void menuPrint() {
		System.out.println("=================");
		System.out.println("1.정보포탈 2.게시판1 9.뒤로가기");
		System.out.println("=================");
	}
	protected void menuInfo() {
		System.out.println("====");
		System.out.println("정보:1.수정 2.탈퇴 9.뒤로가기");
		System.out.println("====");
	}
	private void back() {
		System.out.println("메인으로 돌아갑니다1.");
	}
	protected void showInputError() {
		System.out.println("메뉴 입력 에러3");
	}
	
	private void updateMemberTrue(){
		Member insertId = inputMember();
		Member inputId = MemberDAO.getInstance().selectCheck(insertId.getMemberId(), insertId.getMemberPw());
	
		if(inputId == null) {  
			System.out.println("비밀번호/아이디 불일치");
			updateMemberTrue();
		}else {
			System.out.println("확인완료 - 수정");
			updateMemberInfo(insertId.getMemberId());
		}
		
	}
	
	private void deleteMemberTrue(){
		Member insertId = inputMember();
		Member inputId = MemberDAO.getInstance().selectCheck(insertId.getMemberId(), insertId.getMemberPw());
		
		if(inputId == null) {  
			System.out.println("비밀번호/아이디 불일치");
			deleteMemberTrue();
		}else {
			System.out.println("본인확인 완료");
			deleteMemberInfo(insertId.getMemberId());
		}
		
	}
	
	@Override
	public Member inputMember() {
		Member info = new Member();
		System.out.println("기존아이디>");
		info.setMemberId(sc.nextLine());
		System.out.println("기존비밀번호>");
		info.setMemberPw(sc.nextLine());
		return info;
	}
	
	
	private void updateMemberInfo(String setId) {
		Member member = updateAll();
		member.setMemberId(setId);
		mDAO.updateMember(member);
	}
	private Member updateAll() {
		Member member = new Member();
		System.out.println("비밀번호>");
		member.setMemberPw(sc.nextLine());
		System.out.println("성명>");
		member.setMemberName(sc.nextLine());
		System.out.println("부서명>");
		member.setMemberDepartment(sc.nextLine());
		System.out.println("전화>");
		member.setMemberPhone(sc.nextLine());
		System.out.println("e-mail>");
		member.setMemberEmail(sc.nextLine());
		
		return member;
	}
	
	private void deleteMemberInfo(String setId) {
		Member member = deleteAll();
		member.setMemberId(setId);
		mDAO.deleteMember(member);
	}
	private Member deleteAll() {
		Member member = new Member();
		System.out.println("아이디재입력>");
		member.setMemberPw(sc.nextLine());
		System.out.println("비밀번호재입력>");
		member.setMemberName(sc.nextLine());
		
		return member;
	}

	
}
