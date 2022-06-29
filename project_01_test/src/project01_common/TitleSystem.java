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
				introduceMenu();
				continue;
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
				new Board03System();
			}else if(menuNo == 8) {
				//고객센터
				new Board04System();
				
			}else if(menuNo == 9) {
				break;
			}else {
				showInputError();
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
	

	
	
	//////////////////////////////////////////////////////////////레이아웃
	private void menuPrint() {
		//System.out.println("1.회사소개 2.근태관리 3.공지사항 4.정보포탈 5.일정관리 6.사내게시판 7.결재내역 8.고객센터 9.뒤로가기");
		String art ="_______________________________________________________________________________________________________________________________\r\n"
				+ "                                                                                                          |                   \r\n"
				+ "                                                                                                          |1.회사소개            \r\n"
				+ "      .oooooo..o oooo    oooo                                                                             |                   \r\n"
				+ "     d8P'    `Y8 `888   .8P'                                                                              |                   \r\n"
				+ "     Y88bo.       888  d8'                                                                                |2.근태관리            \r\n"
				+ "      `\"Y8888o.   88888[                                                                                  |                   \r\n"
				+ "        `\"Y88b  888`88b.                                                                                  |                   \r\n"
				+ "     oo     .d8P  888  `88b.                                                                              |3.공지사항            \r\n"
				+ "     8\"\"88888P'  o888o  o888o                                                                             |                   \r\n"
				+ "                    ooooo                                                 .    o8o                        |                   \r\n"
				+ "                    `888'                                               .o8    `\"'                        |4.종합정보포탈         \r\n"
				+ "                     888  ooo. .oo.    .ooooo.  oooo    ooo  .oooo.   .o888oo oooo   .ooooo.  ooo. .oo.   |                   \r\n"
				+ "                     888  `888P\"Y88b  d88' `88b  `88.  .8'  `P  )88b    888   `888  d88' `88b `888P\"Y88b  |                   \r\n"
				+ "                     888   888   888  888   888   `88..8'    .oP\"888    888    888  888   888  888   888  |5.일정관리            \r\n"
				+ "                     888   888   888  888   888    `888'    d8(  888    888 .  888  888   888  888   888  |                   \r\n"
				+ "                    o888o o888o o888o `Y8bod8P'     `8'     `Y888\"\"8o   \"888\" o888o `Y8bod8P' o888o o888o |                   ";
		
		String art2 ="   ___  _  _ ____ _ _  _ ____ ____ ____    ___  ____ ____ ___ ____ _       ____ _   _ ____ ___ ____ _  _  |6.사내게시판          \r\n"
				+ "   |__] |  | [__  | |\\ | |___ [__  [__     |__] |  | |__/  |  |__| |       [__   \\_/  [__   |  |___ |\\/|  |                   \r\n"
				+ "   |__] |__| ___] | | \\| |___ ___] ___]    |    |__| |  \\  |  |  | |___    ___]   |   ___]  |  |___ |  |  |                  \r\n"
				+ "           _______________________________________________________________________________________________|7.결재 승인           ";
		String art3 ="                                                                                                          |                   \r\n"
				+ "      SK Innovation, SK Group’s intermediate holding company, operates energy, petrochemical, e-mobility |                    \r\n"
				+ "             electronic materials businesses, along with 8 major subsidiaries including SK energy, SK geo |8.고객센터           \r\n"
				+ "                           trading international, SK ie technology, and SK earthon. We have established a |___________________\r\n"
				+ "          hain in our businesses with a vertical integration from E&P to producing petrochemical products |                   \r\n"
				+ "              expanded the green portfolio through continues investment in battery and materials sectors. |9.BACK             \r\n"
				+ "__________________________________________________________________________________________________________|___________________\r\n";
		
		System.out.println(art);
		System.out.println(art2);
		System.out.println(art3);
		System.out.println("SELECT MENU NUMBER>");
	}
	
	//회사 소개 호출
	public void introduceMenu() {
		while(true) {
			introduce();
			int menuNo = menuSelect();
			if(menuNo == 9) {
				//뒤로가기
				break;
			}else {
				showInputError();
			}
		}
	}
	
	public void introduce(){
		String art ="_______________________________________________________________________________________________________________________________\r\n"
				+ "                                                                                                                                \r\n"
				+ "                                                                                                                                \r\n"
				+ "      .oooooo..o oooo    oooo                                                                                                   \r\n"
				+ "     d8P'    `Y8 `888   .8P'                                                                                                    \r\n"
				+ "     Y88bo.       888  d8'                                                                                                                \r\n"
				+ "      `\"Y8888o.   88888[                                                                                                     \r\n"
				+ "        `\"Y88b  888`88b.                                                                                                     \r\n"
				+ "     oo     .d8P  888  `88b.                                                                                                \r\n"
				+ "     8\"\"88888P'  o888o  o888o                                                                                               \r\n"
				+ "                    ooooo                                                 .    o8o                                           \r\n"
				+ "                    `888'                                               .o8    `\"'                                         \r\n"
				+ "                     888  ooo. .oo.    .ooooo.  oooo    ooo  .oooo.   .o888oo oooo   .ooooo.  ooo. .oo.                      \r\n"
				+ "                     888  `888P\"Y88b  d88' `88b  `88.  .8'  `P  )88b    888   `888  d88' `88b `888P\"Y88b                     \r\n"
				+ "                     888   888   888  888   888   `88..8'    .oP\"888    888    888  888   888  888   888                    \r\n"
				+ "                     888   888   888  888   888    `888'    d8(  888    888 .  888  888   888  888   888                     \r\n"
				+ "                    o888o o888o o888o `Y8bod8P'     `8'     `Y888\"\"8o   \"888\" o888o `Y8bod8P' o888o o888o ";
		
		String art2 ="   ___  _  _ ____ _ _  _ ____ ____ ____    ___  ____ ____ ___ ____ _       ____ _   _ ____ ___ ____ _  _  \r\n"
				+ "   |__] |  | [__  | |\\ | |___ [__  [__     |__] |  | |__/  |  |__| |       [__   \\_/  [__   |  |___ |\\/|  \r\n"
				+ "   |__] |__| ___] | | \\| |___ ___] ___]    |    |__| |  \\  |  |  | |___    ___]   |   ___]  |  |___ |  |  \r\n"
				+ "           _______________________________________________________________________________________________";
		String art3 ="                                                                                                       \r\n"
				+ "                                        SK ESG 경영으로 인류의 지속가능한 미래를 만들어 가는 SK이노베이션\r\n"
				+ "       대한민국 산업을 최선두에서 이끌며 경제발전의 견인차 역할을 해 온 SK이노베이션은 ESG 경영을 기반으로 모두가 행복한\r\n"
				+ "            미래, 지속가능한 세상을 만들기 위해 세계 곳곳의 현장에서 오늘도 쉼없이 한 걸음 한 걸음을 내딛고 있습니다\r\n"
				+ "         K이노베이션은 대한민국 대표 에너지 기업인 SK에너지, 화학소재 사업 밸류 체인의 순환 경제를 만드는 SK지오센트릭\r\n"
				+ "           미래산업을 선도하는 배터리 생태계를 구축하는 SK온, 글로벌 윤활유 제품 시장의 역사를 써 나가는 SK루브리컨츠\r\n"
				+ "               보다 안전하고 깨끗한 에너지로 지역사회와 상생하는 SK인천석유화학,전문 트레이딩 기업 SK트레이딩인터내셔널 _________________\r\n"
				+ "                        정보전자소재산업의 글로벌 리딩기업 SK아이이테크놀로지 자원 순환까지 생각하는 E&P 기업 SK어스온과 함께 |\r\n"
				+ "                                                     Green Energy & Material Company  꿈을 향해 전진하고 있습니다 |    9.BACK      \r\n"
				+ "___________________________________________________________________________________________________________|_________________\r\n";
		
		System.out.println(art);
		System.out.println(art2);
		System.out.println(art3);
		System.out.println("SELECT MENU NUMBER>");
	}
	
	protected void showInputError() {
		System.out.println("메뉴 입력 에러");
	}


}
