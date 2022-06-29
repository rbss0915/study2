package project01_common;

import java.util.List;
import java.util.Scanner;

import project01_board04.Board04;
import project01_board04.Board04DAO;
import project01_board04.Board04Re;
import project01_member.Member;
import project01_member.MemberDAO;

public class Board04System {
	
	private Scanner sc = new Scanner(System.in);
	private Board04DAO b1DAO = Board04DAO.getInstance();
	public static Board04 Board04Info = null;

	public Board04System() {
		while(true) {
			menuPrint();
			viewBoard();
			int menuNo = menuSelect();
			if(menuNo == 1) {
				//조회
				inBoard();
			}else if(menuNo == 2) {
				//검색
				searchBoard();
			}else if(menuNo == 5) {
				//등록
				insertBoardInfo();
			}else if(menuNo == 9){
				//뒤로가기
				back();
				break;
			}else {
				showInputError();
			}
		}
	}
	
	private void inBoard() {
		selectBoard();
		
		inBoardMenu();
		int menuNo = menuSelect();
		  while(true) {
			  if(menuNo == 1) {
					//글수정
				  	updateBoardTrue();
				  	break;
			  }else if(menuNo == 2) {
					//글삭제
				  	deleteBoardTrue();
				  	break;
			  }else if(menuNo == 3) {
					//댓글달기
				  insertReInfo();
				  	break;
			  }else if(menuNo == 4) {
					//댓글삭제
				  deleteReInfo();
				  	break;
			  }else if(menuNo == 9){
				  	//뒤로
				  	back();
					break;
			  }else {
				  showInputError();
			  }
		  }
	}
	
	/*private void inBoardRe() {
		System.out.println("@@@@@@@");
		inBoardReMenu();
		int menuNo = menuSelect();
			while(true){
				if(menuNo == 1) {
					//댓수정
					
					break;
				}else if(menuNo == 2) {
					//댓삭제
					
					break;
				}else if(menuNo == 9) {
					//뒤로
					back();
					break;
				}else {
					showInputError();
				}
			}
	}*/
	////////////////////////////////////////////////////


	private void deleteReInfo() {
		Board04Re board04re = deleteRe();
		b1DAO.deleteRe(board04re);
	}
	
	private Board04Re deleteRe() {
		Board04Re board04re = new Board04Re();
		System.out.println("댓비번확인>");
		board04re.setPwRe(sc.nextLine());
		
		return board04re;
	}
	
	
	private void insertReInfo() {
		Board04Re board04re = inputRe();
		b1DAO.insertRe(board04re);
	}
	
	private Board04Re inputRe() {
		Board04Re board04re = new Board04Re();
		System.out.println("현재 글번호>");
		board04re.setBoard04Number(Integer.parseInt(sc.nextLine()));
		System.out.println("내용>");
		board04re.setRecontent(sc.nextLine());
		System.out.println("성명>");
		board04re.setMemberName(sc.nextLine());
		System.out.println("댓글패스워드>");
		board04re.setPwRe(sc.nextLine());
		
		return board04re;
	}
	


	private void deleteBoardTrue(){
		Member insertId = inputMember();
		Member inputId = MemberDAO.getInstance().selectCheck(insertId.getMemberId(), insertId.getMemberPw());
		while(true) {
			if(inputId == null) {  
				System.out.println("비밀번호/아이디 불일치");
				break;
			}else {
				System.out.println("본인확인완료");
				System.out.println("삭제 하시겠습니까?");
				deleteBoardInfo(insertId.getMemberId());
				break;
			}
		}
	}	
	private void deleteBoardInfo(String setPw) {
		Board04 board04 = deleteAll();
		//board04.setBoard04Pw(setPw);
		b1DAO.delete(board04);
	}
	private Board04 deleteAll() {
		Board04 board04 = new Board04();
		System.out.println("게사굴 패스워드>");
		board04.setBoard04Pw(sc.nextLine());
		
		return board04;
	}
	private void updateBoardTrue(){
		Member insertId = inputMember();
		Member inputId = MemberDAO.getInstance().selectCheck(insertId.getMemberId(), insertId.getMemberPw());
		while(true) {
			if(inputId == null) {  
				System.out.println("패스워드/아이디 불일치");
				break;
			}else {
				System.out.println("본인 확인완료");
				updateBoardInfo(insertId.getMemberId());
				break;
			}
		}
		
	}
	public Member inputMember() {
		Member info = new Member();
		System.out.println("확인 아이디>");
		info.setMemberId(sc.nextLine());
		System.out.println("확인 비밀번호>");
		info.setMemberPw(sc.nextLine());
		return info;
	}
	private void updateBoardInfo(String setName) {
		Board04 board04 = updateAll();
		board04.setMemberName(setName);
		b1DAO.update(board04);
	}
	private Board04 updateAll() {
		Board04 board04 = new Board04();
		System.out.println("제목>");
		board04.setBoard04Title(sc.nextLine());
		System.out.println("내용>");
		board04.setBoard04Content(sc.nextLine());
		System.out.println("게시글 패스워드>");
		board04.setBoard04Pw(sc.nextLine());
		
		return board04;
	}
	
	private void insertBoardInfo() {
		Board04 board = inputAll();
		b1DAO.insert(board);
	}
	
	private Board04 inputAll() {
		Board04 board04 = new Board04();
		System.out.println("제목>");
		board04.setBoard04Title(sc.nextLine());
		System.out.println("내용>");
		board04.setBoard04Content(sc.nextLine());
		System.out.println("성명>");
		board04.setMemberName(sc.nextLine());
		System.out.println("패스워드>");
		board04.setBoard04Pw(sc.nextLine());
		
		return board04;
	}

	

	
	private void viewBoard() {
		List<Board04> list = b1DAO.viewAll();
		for(Board04 view : list) {
			System.out.println(view.selectBoardInfo());
		}
		
	}
	
	private int menuSelect() {
		int menuNo = 0;
		try {
			menuNo = Integer.parseInt(sc.nextLine());
		}catch(NumberFormatException e) {
			System.out.println("입력 오류");
		}
		return menuNo;
	}

	private void selectBoard() {
		int select = inputNum();
		List<Board04> list = b1DAO.viewOne(select);
		for(Board04 view : list) {
			System.out.println(view);
			//댓글보기
			ViewRe(select);
		}
	}
	private void ViewRe(int select) {
		List<Board04Re> list = b1DAO.viewRe(select);
		for(Board04Re view : list) {
			System.out.println(view);
		}
	}
	
	
	private void searchBoard() {
		String keyword = intputSearch();
		//int select = inputNum();
		List<Board04> list = b1DAO.viewSearch(keyword);
		for(Board04 view : list) {
			System.out.println(view);
			//댓글보기
			//ViewRe2(keyword, select);
		}
	}
	/*
	private void ViewRe2(String keword, int select) {
		List<Board04Re> list = b1DAO.viewRe2(keword, select);
		for(Board04Re view : list) {
			System.out.println(view);
			
		}
	}*/
	
	private String intputSearch() {
		System.out.println("검색키워드 입력: ");
		return sc.nextLine();
	}
	/*private void insertBoardNum() {
		//아이디와 비밀번호 입력
		int num = intputNum();
		//로그인 시도
		Board04Info = Board04DAO.getInstance().selectLogin(num);
		//실패할 경우 그대로 메소드 종료
		if(Board04Info == null) return;
		
		//성공할 경우 프로그램을 실행
		new selectBoard();
	}*/
	private int inputNum() {
		System.out.println("글번호 입력: ");
		return Integer.parseInt(sc.nextLine());
	}
	
	
	private void back() {
		System.out.println("뒤로가기");
	}
	
	protected void showInputError() {
		System.out.println("메뉴 입력 에러");
	}
	
	private void inBoardMenu(){
		System.out.println("|  1.게시글 수정  |  2.게시글 삭제                                               |    3.댓글     |    4.댓글 삭제     |    9.뒤로 |");
		System.out.println("_______________________________________________________________________________________________________________________________");
		
	}
	/////////////////////////레이아웃/////////////////////////레이아웃/////////////////////////레이아웃/////////////////////////레이아웃
	private void menuPrint() {
		System.out.println("_______________________________________________________________________________________________________________________________");
		System.out.println("");
		System.out.println("                                                       고 객 센 터");
		System.out.println("_______________________________________________________________________________________________________________________________");
		System.out.println("           1.글조회            |              2.글검색            |            5.등록             |          9.뒤로가기");
		//System.out.println("");
		//System.out.println("_______________________________________________________________________________________________________________________________");
		System.out.println("_______________________________________________________________________________________________________________________________\r\n"
			+  "  글번호  |                        TITLE                                 |       작성자       |      작성일      | 조회수 | 댓글수\r\n");
		System.out.println("_______________________________________________________________________________________________________________________________");
	}


}
