package project01_calendar;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

public class PlanItem {
	String format;
	String plan;
	String location;
	ArrayList<String> user;

	public PlanItem() {
		user = new ArrayList<>();
	}
	
	
	
	public PlanItem(String plan, String location, ArrayList<String> user) {
		this.plan = plan;
		this.location = location;
		this.user = user;
	}

	public void planItem(Scanner sc, Date date) {
		System.out.println("일정등록");
		System.out.print("일정사항> ");
		plan = sc.nextLine();

		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
		format = formatter.format(date);
		System.out.println(format + " : " + plan + "\n" + "일정 등록 완료\n");
	}

	public void planPlace(Scanner sc) {
		System.out.println("일정 비고");
		System.out.print("내용> ");
		location = sc.nextLine();

	}

	public void planUser(Scanner sc) {

		System.out.println("관련부서 및 사원 (press q to quit)");

		while (true) {
			System.out.print("소속 입력> ");
			String name = sc.nextLine();

			if (name.equals("q")) {
				System.out.println("소속 : " + user);
				System.out.println();
				break;
			}
			user.add(name);
		}

	}
}