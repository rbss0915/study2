package project01_common;


import java.util.Scanner;

import project01_board01.Board01DAO;
import project01_member.Member;
import project01_member.MemberDAO;
import project01_member.MemberSystem;

public class MainSystem {
	
	protected Scanner sc = new Scanner(System.in);
	protected MemberDAO mDAO = MemberDAO.getInstance();
	protected Board01DAO bDAO = Board01DAO.getInstance();
	public static Member loginInfo = null;
	public static Member getLogingInfo() {
		return loginInfo;
	}

	public MainSystem() {
		menuPrint();
		while(true) {
			int menuNo = menuSelect();
			
			if(menuNo == 1) {
				//로그인
				login();
			}else if(menuNo == 2) {
				//회원가입
				new MemberSystem();
				
			}else if(menuNo == 9){
				//종료
				exit();
			}else {
				//입력오류
				showInputError();
			}
		}
	}
	
	//메소드
	protected void menuPrint() {
		System.out.println("============================");
		System.out.println("1.로그인 2.회원가입 9.종료");
		System.out.println("============================");
	}
	
	protected int menuSelect() {
		int menuNo = 0;
		try {
			menuNo = Integer.parseInt(sc.nextLine());
		}catch(NumberFormatException e) {
			System.out.println("숫자 입력 오류");
		}
		return menuNo;
	}
	
	protected void exit() {
		System.out.println("exit");
	}
	
	protected void showInputError() {
		System.out.println("메뉴 입력 에러2");
	}
	
	private void login() {
		//아이디와 비밀번호 입력
		Member inputInfo = inputMember();
		//로그인 시도
		loginInfo = MemberDAO.getInstance().selectLogin(inputInfo);
		//실패할 경우 그대로 메소드 종료
		if(loginInfo == null) return;
		
		//성공할 경우 프로그램을 실행
		new InfoSystem();
	}
	
	protected Member inputMember() {
		Member info = new Member();
		System.out.println("아이디>");
		info.setMemberId(sc.nextLine());
		System.out.println("비밀번호>");
		info.setMemberPw(sc.nextLine());
		return info;
	}
	

}
