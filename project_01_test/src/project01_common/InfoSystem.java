package project01_common;


import java.util.List;
import java.util.Scanner;

import project01_member.Member;
import project01_member.MemberDAO;

public class InfoSystem{
	
	private Scanner sc = new Scanner(System.in);
	private MemberDAO mDAO = MemberDAO.getInstance();

	public InfoSystem(){
		while(true) {
			menuPrint();
			int menuNo = menuSelect();
			if(menuNo == 1) {
				//인사관리-수정-탈퇴
				menuInfo();
				InfoPortal();
			}else if(menuNo == 2) {
				//사원검색
				searchMember();
			}else if(menuNo == 3) {
				//부서검색
				searchDeparement();
			}else if(menuNo == 4) {
				//전체사원
				selectAll();
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
				break;
			}else if(menuNo == 2) {
				//탈퇴
				deleteMemberTrue();
				break;
			}else if(menuNo == 9) {
				//뒤로가기
				back();
				break;
			}else {
				showInputError();
			}
			
		}
	}
	private void menuPrint() {
		System.out.println("=================");
		System.out.println("1.인사관리 2.사원검색 3.부서검색 4.전체사원 9.뒤로가기");
		System.out.println("=================");
	}
	private void menuInfo() {
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
		while(true) {
			if(inputId == null) {  
				System.out.println("비밀번호/아이디 불일치");
				break;
			}else {
				System.out.println("확인완료 - 수정");
				updateMemberInfo(insertId.getMemberId());
				break;
			}
		}
		
	}
	
	private void deleteMemberTrue(){
		Member insertId = inputMember();
		Member inputId = MemberDAO.getInstance().selectCheck(insertId.getMemberId(), insertId.getMemberPw());
		while(true) {
			if(inputId == null) {  
				System.out.println("비밀번호/아이디 불일치");
				break;
			}else {
				System.out.println("본인확인 완료");
				deleteMemberInfo(insertId.getMemberId());
				break;
			}
		}
		
	}
	
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
	
	private int menuSelect() {
		int menuNo = 0;
		try {
			menuNo = Integer.parseInt(sc.nextLine());
		}catch(NumberFormatException e) {
			System.out.println("숫자 입력 오류");
		}
		return menuNo;
	}
	
	private void searchMember() {
		String searchName = intputName();
		List<Member> list = mDAO.searchMember(searchName);
		for(Member member : list) {
			System.out.println(member);
		}
	}
	private void searchDeparement() {
		String searchGroup = intputDepartment();
		List<Member> list = mDAO.searchDeparement(searchGroup);
		for(Member member : list) {
			System.out.println(member);
		}
	}
	
	private String intputName() {
		System.out.println("검색 - 사원명 : ");
		return sc.nextLine();
	}
	private String intputDepartment() {
		System.out.println("검색 - 부서명 : ");
		return sc.nextLine();
	}
	
	private void selectAll() {
		List<Member> list = mDAO.selectAll();
		for(Member member : list) {
			System.out.println(member);
		}
		
	}

	
}
