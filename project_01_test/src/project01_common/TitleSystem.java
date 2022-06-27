package project01_common;

import java.util.Scanner;

import project01_calendar.CalendarSystem;
import project01_check.CheckSystem;

public class TitleSystem {
	private Scanner sc = new Scanner(System.in);
	
	public TitleSystem(){
		while(true) {
			menuPrint();
			int menuNo = menuSelect();
			if(menuNo == 1) {
				//공지사항
				new Board01System();
			}else if(menuNo == 2) {
				//정보포탈
				new InfoSystem();
			}else if(menuNo == 3) {
				//일정관리
				new CalendarSystem();
			}else if(menuNo == 4) {
				//근태관리
				new CheckSystem();
				
			}else if(menuNo == 5) {
				
			}else if(menuNo == 9) {
				break;
			}else {
			}
		}
	}
	
	private void menuPrint() {
		System.out.println("=================");
		System.out.println("1.정보포탈 2.공지사항 3.일정관리 4. 9.뒤로가기");
		System.out.println("=================");
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
	
	


}
