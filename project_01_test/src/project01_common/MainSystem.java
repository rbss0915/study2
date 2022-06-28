package project01_common;



import java.util.Scanner;

import project01_board01.Board01DAO;
import project01_member.Member;
import project01_member.MemberDAO;

public class MainSystem {
	
	protected Scanner sc = new Scanner(System.in);
	protected MemberDAO mDAO = MemberDAO.getInstance();
	protected Board01DAO bDAO = Board01DAO.getInstance();
	public static Member loginInfo = null;
	public static Member getLogingInfo() {
		return loginInfo;
	}

	public MainSystem() {
		while(true) {
			menuPrint();
			int menuNo = menuSelect();
			
			if(menuNo == 1) {
				//로그인
				login();
			}else if(menuNo == 2) {
				//회원가입
				menuPrintIn();
				insertMemberInfo();
				continue;
			}else if(menuNo == 9){
				//종료
				exitProgram();
				break;
			}else {
				//입력오류
				showInputError();
			}
		}
	}
	
	//메소드

	
	private int menuSelect() {
		int menuNo = 0;
		try {
			menuNo = Integer.parseInt(sc.nextLine());
		}catch(NumberFormatException e) {
			System.out.println("숫자 입력 오류");
		}
		return menuNo;
	}
	
	protected void exitProgram() {
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
		new TitleSystem();
	}
	
	protected Member inputMember() {
		Member info = new Member();
		System.out.println("ID>");
		info.setMemberId(sc.nextLine());
		System.out.println("PASSWORD>");
		info.setMemberPw(sc.nextLine());
		return info;
	}
	
	
	
	protected void menuPrintIn() {
		System.out.println("==============");
		System.out.println("회원 가입");
		System.out.println("==============");
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
	
	//////////////////////////////////////레이아웃////////////////////////////////////////////
	
	
	private void menuPrint() {
		System.out.println("========================================================================================================================================================================================================");
		System.out.println("|                                                                                                                                                                                                      |");
		System.out.println("|                                                                                                                                                                                                      |");
		System.out.println("========================================================================================================================================================================================================");
		System.out.println("|                                                                                                                                                                                                      |");
		System.out.println("|                                                                                                                                                                                                      |");
		System.out.println("|                                                                                                                                                                                                      |");
		System.out.println("|                                                                                                                                                                                                      |");
		System.out.println("|                                                                                                                                                                                                      |");
		System.out.println("|                                                                                                                                                                                                      |");
		System.out.println("|                                                                                                                                                                                                      |");
		System.out.println("|                                                                                                                                                                                                      |");
		System.out.println("|                                                                                                                                                                                                      |");
		System.out.println("|                                                                                                                                                                                                      |");
		System.out.println("|                                                                                                                                                                                                      |");
		System.out.println("|                                                                                                                                                                                                      |");
		System.out.println("|                                                                                                                                                                                                      |");
		System.out.println("|                                                                                                                                                                                                      |");
		System.out.println("|                                                                                                                                                                                                      |");
		System.out.println("|                                                                                                                                                                                                      |");
		System.out.println("|                                                                                                                                                                                                      |");
		System.out.println("|                                                                                                                                                                                                      |");
		System.out.println("|                                                                                                                                                                                                      |");
		System.out.println("|                                                                                                                                                                                                      |");
		System.out.println("|                                                                                                                                                                                                      |");
		System.out.println("|                                                                                                                                                                                                      |");
		System.out.println("|                                                                                                                                                                                                      |");
		System.out.println("|                                                                                                                                                                                                      |");
		System.out.println("|                                                                                                                                                                                                      |");
		System.out.println("|                                                                                                                                                                                                      |");
		System.out.println("|                                                                                                                                                                                                      |");
		System.out.println("|                                                                                                                                                                                                      |");
		System.out.println("|                                                                                                                                                                                                      |");
		System.out.println("|                                                                                                                                                                                                      |");
		System.out.println("|                                                                                                                                                                                                      |");
		System.out.println("|                                                                                                                                                                                                      |");
		System.out.println("|                                                                                                                                                                                                      |");
		System.out.println("|                                                                                                                                                                                                      |");
		System.out.println("|                                                                                                                                                                                                      |");
		System.out.println("|                                                                                                                                                                                                      |");
		System.out.println("|                                                                                                                                                                                                      |");
		System.out.println("========================================================================================================================================================================================================");
		System.out.println("|           1             ||------------------------------------------------------------------------------------------------------------------------------------------||        2         |       9      |");
		System.out.println("|         LOGIN           ||------------------------------------------------------------------------------------------------------------------------------------------||       가입       |     EXIT    |");
		System.out.println("========================================================================================================================================================================================================");
	}

}
