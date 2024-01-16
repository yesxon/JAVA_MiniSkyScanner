package miniSkyScanner;

import java.util.*;


public class ChooseTrip extends Membership {
	private String nation = null;
	String USA = "미국"; 
	String Italy = "이탈리아"; 
	String Vietnam = "베트남"; 
	String depDate;        // 이름
    String arrDate;  // 태어난 년도
    String depNation;  // 태어난 월
    String arrNation;  // 태어난 일
    Scanner sc = new Scanner(System.in);
	public ChooseTrip(){
	}
	
public void selectWhat() {
    	
    	System.out.println("\n[INFO] 안녕하세요. 스카이스캐너 입니다.\n"
                + "날짜와 국가 중 무엇을 우선으로 선택하시겠습니까?\n"
                + "[1] 날짜\t[2] 국가");
    	String answer = "";
        for (; ; ) {
            System.out.print("\n입력 : ");
            answer = sc.next();
            if (answer.equals("1") || answer.equals("예")) {
                chooseDate();
                setNation();
                chooseSpcific();
                break;
            } else if (answer.equals("2") || answer.equals("아니요")) {
                setNation();
                chooseDate();
                chooseSpcific();
            	break;
           } else {
                System.out.println("\n[ERROR] 잘못된 입력입니다. 다시 입력해주세요.");
            }
        }
    }

	public void chooseDate() {
		System.out.println("\n[INFO] 안녕하세요. 스카이스캐너 입니다.\n");
		// 스캐너 열기
		// 자바의 Calendar 클래스를 이름을 정해서 생성
		userCalendar cal = new userCalendar();
		int year = 2022;
		int month = 1;
		int depday;
		int arrday;
		// 횟수가 사라지지 않는 반복 - while문에 true를 사용하여 무한루프
		while (true) {
			// 년도를 입력하라는 문구와 프롬프트 문자 및 커서 출력, year라는 변수로 년도에 해당하는 숫자를 입력받음
			System.out.println("년도를 입력하세요");
			System.out.print("YEAR> ");
			year = sc.nextInt();
			depDate = Integer.toString(year);
			arrDate = Integer.toString(year);
			// 달을 입력하라는 문구와 프롬프트 문자 및 커서 출력, month라는 변수로 달에 해당하는 숫자를 입력받음
			System.out.println("달을 입력하세요");
			System.out.print("MONTH> ");
			month = sc.nextInt();
			// month에 -1을 입력할경우 프로그램 종료
			if (month == -1) {
				break;
			}
			// month가 12보다 클 경우 프로그램 다시 실행 (루프의 처음으로 돌아감)
			if (month > 12) {
				continue;
			}
			if (Integer.toString(month).length() == 1) {
			depDate += "0";
			depDate +=	Integer.toString(month);
			arrDate += "0";
			arrDate += Integer.toString(month);
			
			}
			else {
				depDate += Integer.toString(month);
				arrDate += Integer.toString(month);
			}
			// 메인 메소드에서 Calendar 클래스인 cal 뒤에, void 메소드 printCalendar를 호출하여 가상 달력 출력
			cal.showCal(year,month);
			System.out.println();
			System.out.println("출발 날짜를 입력하세요");
			System.out.print("DEPART DAY> ");
			depday = sc.nextInt();
			if (Integer.toString(depday).length() == 1) {
				depDate += "0";
				depDate +=	Integer.toString(depday);
			}
			else {
				depDate += Integer.toString(depday);
			}
			cal.showCal(year, month, depday);
			
			System.out.println();
			System.out.println("도착 날짜를 입력하세요");
			System.out.print("ARRIAL DAY> ");
			
			arrday = sc.nextInt();
			if (Integer.toString(arrday).length() == 1) {
				arrDate += "0";
				arrDate +=	Integer.toString(arrday);
			}
			else {
				arrDate += Integer.toString(arrday);
			}
			System.out.println();
			cal.showCal(year, month, depday, arrday);
			System.out.println("출발 날짜 : " + year +"년"+ month+"월" + depday+"일");
			System.out.println("도착 날짜 : " + year +"년"+ month+"월" + arrday+"일");
	    	System.out.println("선택하신 날짜가 맞습니까?\n"
	                + "[1] 네\t[2] 아니요");
			System.out.println();
			String answer = "";
			answer = sc.next();
			if (answer.equals("1") || answer.equals("네")) {
				
				break;
	        } else if (answer.equals("2") || answer.equals("아니요")) {
	        	continue;
	            //chooseCountry();
	        } else {
	            System.out.println("\n[ERROR] 잘못된 입력입니다. 다시 입력해주세요.");
	            System.out.println();
	        }
			
			
		}
		
		
	}
	public String getNation() {
		return this.nation;	
	}
	
	public String setNation() {
		//국가 받아오기
		System.out.println("여행하길 원하는 국가를 선택하세요(1. 미국, 2. 이탈리아, 3. 베트남)");
		Scanner sc = new Scanner(System.in);
		int a = sc.nextInt();
		switch(a) {
		case 1: // 미국
			this.nation  = USA;
			System.out.println(this.nation + "(을)를 선택하셨습니다.");
			break;
		case 2: // 이탈리아
			this.nation = Italy;
			System.out.println(this.nation + "(을)를 선택하셨습니다.");
			break;
		case 3: //베트남
			this.nation = Vietnam;
			System.out.println(this.nation + "(을)를 선택하셨습니다.");
			break;
		default:
			System.out.println("유효하지 않은 국가 선택입니다.");
			break;
		}
		return this.nation;

	}
	
	public void chooseSpcific() {
    	timetable dep = new timetable();
    	timetable2 arr = new timetable2();
    	System.out.println("선택하신 날짜에 대한 " + nation + "시간표:");
    	dep.showTimetableWithLabelsSeatsAndPrices(nation);
    	System.out.println("원하시는 일정의 번호를 선택해 주세요");
    	int answer = sc.nextInt();
    	System.out.println("선택하신 일정은");
        System.out.printf("%-5s %-6s %-7s %4s\n", "번호", "시간", "잔여좌석", "가격");
    	System.out.printf("%-5d %-6s %5d %8d원\n", answer, dep.getTimetable(nation)[answer-1], dep.getRemainingSeats(nation)[answer-1], dep.getPrices(nation)[answer-1]);
    	
    	depDate += dep.getTimetable(nation)[answer-1];
    	System.out.println();
    	arr.showTimetableWithLabelsSeatsAndPrices(nation);
    	System.out.println("돌아오는 비행기를 선택해주세요");
    	int answer2 = sc.nextInt();
    	System.out.println("선택하신 일정은");
        System.out.printf("%-5s %-6s %-7s %4s\n", "번호", "시간", "잔여좌석", "가격");
    	System.out.printf("%-5d %-6s %5d %8d원\n", answer, dep.getTimetable(nation)[answer-1], dep.getRemainingSeats(nation)[answer-1], dep.getPrices(nation)[answer-1]);
    	arrDate += arr.getTimetable(nation)[answer-1];

    	
    }
	

	
}
