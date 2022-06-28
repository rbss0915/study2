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
				//회사소개
				introduce();
			}else if(menuNo == 2) {
				//근태관리
				new CheckSystem();
			}else if(menuNo == 3) {
				//공지사항
				new Board01System();
			}else if(menuNo == 4) {
				//정보포탈
				new InfoSystem();
			}else if(menuNo == 5) {
				//일정관리
				new CalendarSystem();
			}else if(menuNo == 6) {
				//사내게시판
				new Board02System();
			}else if(menuNo == 7) {
				//결재내역
				
			}else if(menuNo == 8) {
				//고객센터
				
			}else if(menuNo == 9) {
				break;
			}else {
			}
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
	
	public void introduce(){
		System.out.println("=========================================");
		System.out.println("ESG 경영으로 인류의 지속가능한 미래를 만들어 가는 SK이노베이션");
		System.out.println("=========================================");
		System.out.println("SK이노베이션은 대한민국 대표 에너지 기업인 SK에너지, 화학소재 사업 밸류 체인의 순환 경제를 만드는 SK지오센트릭,\r\n"
				+ "미래산업을 선도하는 배터리 생태계를 구축하는 SK온, 글로벌 윤활유 제품 시장의 역사를 써 나가는 SK루브리컨츠, 보다 안전하고 깨끗한 에너지로 지역사회와 상생하는 SK인천석유화학,\r\n"
				+ "전문 트레이딩 기업 SK트레이딩인터내셔널, 정보전자소재산업의 글로벌 리딩기업 SK아이이테크놀로지, 자원의 선순환까지 생각하는 E&P 기업 SK어스온과 함께\r\n"
				+ "Green Energy & Materials Company의 꿈을 향해 전진하고 있습니다.");
		System.out.println("=========================================");
	}
	
	
	//////////////////////////////////////////////////////////////레이아웃
	private void menuPrint() {
		System.out.println("=================");
		System.out.println("1.회사소개 2.근태관리 3.공지사항 4.정보포탈 5.일정관리 6.사내게시판 7.결재내역 8.고객센터 9.뒤로가기");
		System.out.println("=================");
	}
	


}
