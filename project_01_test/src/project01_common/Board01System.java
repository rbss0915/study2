package project01_common;

import java.util.List;
import java.util.Scanner;

import project01_board01.Board01;
import project01_board01.Board01DAO;
import project01_member.Member;
import project01_member.MemberDAO;

public class Board01System {
	
	private Scanner sc = new Scanner(System.in);
	private Board01DAO b1DAO = Board01DAO.getInstance();
	public static Board01 Board01Info = null;

	public Board01System() {
		while(true) {
			menuPrint();
			viewBoard();
			int menuNo = menuSelect();
			if(menuNo == 1) {
				//조회
				inBoard();
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
			  }else if(menuNo == 9){
				  	//뒤로
				  	back();
					break;
			  }else {
				  showInputError();
			  }
		  }
	}
	////////////////////////////////////////////////////
	private void deleteBoardTrue(){
		Member insertId = inputMember();
		Member inputId = MemberDAO.getInstance().selectCheck(insertId.getMemberId(), insertId.getMemberPw());
		while(true) {
			if(inputId == null) {  
				System.out.println("비밀번호/아이디 불일치");
				break;
			}else {
				System.out.println("본인확인완료 - 삭제?");
				deleteBoardInfo(insertId.getMemberId());
				break;
			}
		}
	}	
	private void deleteBoardInfo(String setPw) {
		Board01 board01 = deleteAll();
		board01.setBoard01Pw(setPw);
		b1DAO.delete(board01);
	}
	private Board01 deleteAll() {
		Board01 board01 = new Board01();
		System.out.println("글비번>");
		board01.setBoard01Title(sc.nextLine());
		
		return board01;
	}
	private void updateBoardTrue(){
		Member insertId = inputMember();
		Member inputId = MemberDAO.getInstance().selectCheck(insertId.getMemberId(), insertId.getMemberPw());
		while(true) {
			if(inputId == null) {  
				System.out.println("비밀번호/아이디 불일치");
				break;
			}else {
				System.out.println("확인완료 - 수정");
				updateBoardInfo(insertId.getMemberId());
				break;
			}
		}
		
	}
	public Member inputMember() {
		Member info = new Member();
		System.out.println("확인아이디>");
		info.setMemberId(sc.nextLine());
		System.out.println("확인비밀번호>");
		info.setMemberPw(sc.nextLine());
		return info;
	}
	private void updateBoardInfo(String setName) {
		Board01 board01 = updateAll();
		board01.setMemberName(setName);
		b1DAO.update(board01);
	}
	private Board01 updateAll() {
		Board01 board01 = new Board01();
		System.out.println("제목>");
		board01.setBoard01Title(sc.nextLine());
		System.out.println("내용>");
		board01.setBoard01Content(sc.nextLine());
		
		return board01;
	}
	
	private void insertBoardInfo() {
		//가입정보 입력
		Board01 board = inputAll();
		//DB에 저장
		b1DAO.insert(board);
	}
	
	private Board01 inputAll() {
		Board01 board01 = new Board01();
		System.out.println("제목>");
		board01.setBoard01Title(sc.nextLine());
		System.out.println("내용>");
		board01.setBoard01Content(sc.nextLine());
		System.out.println("성명>");
		board01.setMemberName(sc.nextLine());
		System.out.println("비밀번호>");
		board01.setBoard01Pw(sc.nextLine());
		
		return board01;
	}

	
	private void menuPrint() {
		System.out.println("=================");
		System.out.println("1.글조회 5.등록 /***************/ 9.뒤로가기");
		System.out.println("=================");
	}
	
	private void viewBoard() {
		List<Board01> list = b1DAO.viewAll();
		for(Board01 view : list) {
			System.out.println(view);
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
		int select = intputNum();
		List<Board01> list = b1DAO.viewOne(select);
		for(Board01 view : list) {
			System.out.println(view);
		}
	}
	/*private void insertBoardNum() {
		//아이디와 비밀번호 입력
		int num = intputNum();
		//로그인 시도
		Board01Info = Board01DAO.getInstance().selectLogin(num);
		//실패할 경우 그대로 메소드 종료
		if(Board01Info == null) return;
		
		//성공할 경우 프로그램을 실행
		new selectBoard();
	}*/
	private int intputNum() {
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
		System.out.println("1.수정 2.삭제 9.뒤로");
		
	}


}
