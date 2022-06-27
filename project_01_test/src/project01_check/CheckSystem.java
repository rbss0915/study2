package project01_check;

import java.util.List;
import java.util.Scanner;






public class CheckSystem {
	private Scanner sc = new Scanner(System.in);
	private CheckDAO cDAO = CheckDAO.getInstance();
	
	public CheckSystem() {
		while(true) {
			menuPrint();
			int menuNo = menuSelect();
			if(menuNo == 1) {
				//출근 등록
				menuInfo();
				CheckIn();
			}else if(menuNo == 2) {
				//전체 출근부
				selectAll();
			}else if(menuNo == 3) {
				//출근자 검색
				searchCheck();
			
			}else if(menuNo == 4) {
				//결근자 검색
				
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
		System.out.println("1.출근등록 2.전체출근부 3.출근자검색 9.뒤로가기");
		System.out.println("=================");
	}
	
	private void CheckIn() {
		Check check = inputCheck();
		cDAO.insertCheck(check);
	}
	
	private Check inputCheck() {
		Check check = new Check();
		System.out.println("사원명>");
		check.setMemberName(sc.nextLine());
		System.out.println("근태처리>");
		check.setCheckIn(sc.nextLine());
		
		return check;
	}
	
	private void selectAll() {
		List<Check> list = cDAO.selectAll();
		for(Check check : list) {
			System.out.println(check.toString() );
		}
	}
	
	private void searchCheck() {
		String searchName = intputName();
		List<Check> list = cDAO.searchCheck(searchName);
		for(Check check : list) {
			System.out.println(check.toString());
		}
	}
	private String intputName() {
		System.out.println("검색 - 사원명 : ");
		return sc.nextLine();
	}
	
	private void searchCheckNon() {
		String searchInfo = intputName();
		List<Check> list = cDAO.searchCheck(searchInfo);
		for(Check check : list) {
			System.out.println("금일 결근자"+check);
		}
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
	private void menuInfo(){
		System.out.println("1.출근 2.지각 9.퇴근");
		System.out.println("입력>");
	}
	protected void showInputError() {
		System.out.println("메뉴 입력 에러");
	}
	private void back() {
		System.out.println("뒤로 돌아갑니다");
	}
	

}