package project01_member;

import project01_common.MainSystem;

public class MemberSystem extends MainSystem{
	public MemberDAO mDAO = MemberDAO.getInstance();
	public MemberSystem() {
		menuPrint();
		while(true) {
			int menuNo = menuSelect();
			if(menuNo == 1) {
				//회원가입 등록
				insertMemberInfo();
			}else if(menuNo == 9) {
				//뒤로가기
				back();
				return;
			}else {
				//입력오류
				showInputError();
			}
			
		}
	}
	protected void menuPrint() {
		System.out.println("==============");
		System.out.println("1.회원 가입 9.뒤로가기");
		System.out.println("==============");
	}
	
	private void back() {
		System.out.println("메인으로 돌아갑니다.2");
	}
	
	private void insertMemberInfo() {
		//가입정보 입력
		Member member = inputAll();
		//DB에 저장
		mDAO.insertMember(member);
	}
	
	private Member inputAll() {
		Member member = new Member();
		System.out.println("ID>");
		member.setMemberId(sc.nextLine());
		System.out.println("PASSWORD>");
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
	
	protected void showInputError() {
		System.out.println("메뉴 입력 에러");
	}
	

}
