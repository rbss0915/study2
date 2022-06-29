package project01_calendar;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;
import java.util.Scanner;

public class Command {
	
	private Scanner sc = new Scanner(System.in);
	HashMap<Date, PlanItem> planSave;

	public Command() {
		planSave = new HashMap<>();
		File f = new File("plan.dat");
		if (!f.exists()) {
			return;
		}
		try {
			Scanner sc = new Scanner(f);
			while (sc.hasNext()) {
				String line = sc.nextLine();
				String[] words = line.split(",");
				Date date = fromStringtoDate(words[0]);
				String plan = words[1];
				String location = words[2];
				String[] strUser = Arrays.copyOfRange(words, 3, words.length);
				ArrayList<String> alGuests = fromStringtoArrayList(strUser);
				PlanItem p = new PlanItem(plan, location, alGuests);
				planSave.put(date, p);
			}
			sc.close();
		} catch (FileNotFoundException e) {
			System.out.println("파일 에러");
			e.printStackTrace();
		}
	}

	public ArrayList<String> fromStringtoArrayList(String[] strUser) {
		ArrayList<String> alUser = new ArrayList<>();
		for (String x : strUser) {
			String temp = x.replace("[", "").replace("]", "").replace(" ", "");
			alUser.add(temp);
			
		}
		return alUser;
	}

	public void cmdRegister() {

		System.out.println("날짜 입력형식(yyyy-MM-dd).");
		System.out.print("날짜입력> ");
		String strDate = sc.nextLine();
		Date date = null;
		try {
			date = new SimpleDateFormat("yyyy-MM-dd").parse(strDate);

		} catch (ParseException e) {
			e.printStackTrace();
		}

		PlanItem newplan = new PlanItem();
		System.out.println();
		newplan.planItem(sc, date);
		newplan.planPlace(sc);
		System.out.println();
		newplan.planUser(sc);

		planSave.put(date, newplan);

		try {
			FileWriter fw = new FileWriter("plan.dat", true);
			fw.write(newplan.format + "," + newplan.plan + "," + newplan.location + "," + newplan.user + "\n");
			fw.close();
		} catch (IOException e) {
			System.out.println("An error occured");
			e.printStackTrace();
		}

	}

	public Date fromStringtoDate(String strDate) {
		Date date = null;
		try {
			date = new SimpleDateFormat("yyyy-MM-dd").parse(strDate);

		} catch (ParseException e) {
			e.printStackTrace();
		}
		return date;
	}

	public void cmdSearch() {
		System.out.println("검색 - 입력형식 (yyyy-MM-dd).");
		System.out.print("DATE> ");
		String searchDate = sc.nextLine();
		Date sdate = fromStringtoDate(searchDate);
		PlanItem result = planSave.get(sdate);
		System.out.println("_______________________________________________________________________________________________________________________________");
		System.out.println("        일 정       |      "+result.plan);
		System.out.println("-------------------------------------------------------------------------------------------------------------------------------");
		System.out.println("      일정 내용      |      "+result.location);
		System.out.println("-------------------------------------------------------------------------------------------------------------------------------");
		//System.out.println("일정: " + result.plan);
		//System.out.println("일정 내용: " + result.location);
		int i = 1;
		System.out.println("   관련 부서 및 사원   |");
		System.out.println("-------------------------------------------------------------------------------------------------------------------------------");
		for (String x : result.user) {
			System.out.println("        소 속" + i + "      | " + x);
			i++;
			System.out.println("");
			System.out.println("");
			System.out.println("-------------------------------------------------------------------------------------------------------------------------------");
		}
		
		System.out.println();

	}
	/*public void cmdSearch() {
		System.out.println("검색 - 입력형식 (yyyy-MM-dd).");
		System.out.print("DATE> ");
		String searchDate = sc.nextLine();
		Date sdate = fromStringtoDate(searchDate);
		PlanItem result = planSave.get(sdate);
		System.out.println("일정: " + result.plan);
		System.out.println("일정 내용: " + result.location);
		int i = 1;
		System.out.println("관련 부서 및 사원");
		for (String x : result.user) {
			System.out.println("- 소속" + i + ": " + x);
			i++;
		}
		
		System.out.println();
		
	}*/

	public void cmdPrintCalendar() {

		System.out.println("연도 입력");
		System.out.print("YEAR> ");
		int year = sc.nextInt();

		System.out.println("월 입력");
		System.out.print("MONTH> ");
		int month = sc.nextInt();

		if (year < 0 || month > 12 || month < 1) {
			System.out.println("유효한 값이 아닙니다.");
			year = sc.nextInt();
			month = sc.nextInt();
		}

		Calendar.printCalendar(year, month);

	}

}