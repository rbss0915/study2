package project01_calendar;

import java.util.Scanner;

public class CalendarSystem {
		private Scanner sc = new Scanner(System.in);
		Command cal = new Command();
		
	public CalendarSystem() {
	
		while(true) {
			menuPrint();
			int menuNo = menuSelect();
			if(menuNo == 1) {
				cal.cmdRegister();
			}else if(menuNo == 2) {
				cal.cmdSearch();
			}else if(menuNo == 3) {
				cal.cmdPrintCalendar();
			}else if(menuNo == 9) {
				//뒤로가기
				break;
			}else {
				showInputError();
			}
		}
	}
	private void showInputError() {
		System.out.println("메뉴 입력 에러");
	}
	private void menuPrint() {
		System.out.println("| 1. 일정 등록 2. 일정 검색 3. 달력 보기 9.종료");
		System.out.print("SELECT> ");
	}
	//public void menuInfo() {
	//	System.out.println("1.등록 2.검색 3.보기 9.종료");
	//}
	private int menuSelect() {
		int menuNo = 0;
		try {
			menuNo = Integer.parseInt(sc.nextLine());
		}catch(NumberFormatException e) {
			System.out.println("숫자 입력 오류");
		}
		return menuNo;
	}

	/*public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Prompt prompt = new Prompt();
		prompt.runPrompt(sc);
		sc.close();
	}*/
}