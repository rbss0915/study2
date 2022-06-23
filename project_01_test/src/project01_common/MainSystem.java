package project01_common;


import java.util.Scanner;


import project01_board01.Board01DAO;
import project01_member.MemberDAO;
import project01_member.MemberSystem;

public class MainSystem {
	
	protected Scanner sc = new Scanner(System.in);
	protected MemberDAO mDAO = MemberDAO.getInstance();
	protected Board01DAO bDAO = Board01DAO.getInstance();
	
	public void run() {
		while(true) {
			menuPrint();
			int menuNo = menuSelect();
			
			if(menuNo == 1) {
				//로그인
				
			}else if(menuNo == 2) {
				//회원가입
				new MemberSystem();
			}else if(menuNo == 9){
				//종료
				exit();
				break;
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
		System.out.println("프로그램 종료");
	}
	
	protected void showInputError() {
		System.out.println("메뉴 입력 에러2");
	}
	

}
