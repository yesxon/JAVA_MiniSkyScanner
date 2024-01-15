package miniSkyScanner;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class SkyScannerMain {
	public static void main(String[] args) {
		// 각 국가에 대한 National 객체 생성
		Membership member = new Membership();
		ChooseTrip trip = new ChooseTrip();
		TripSummary tripInfo = new TripSummary();
		timetable timeto = new timetable();
		timetable2 timefrom  = new timetable2();
		member.membershipGuide();
		National chosenTripInfo = null;
		trip.selectWhat();

		DateTimeFormatter dateFormatter1=DateTimeFormatter.ofPattern("yyyyMMddHH:mm");
		String depDate = trip.depDate.substring(4);
		String arrDate = trip.arrDate.substring(4);
		String chosenNation = trip.setNation();
		while (chosenTripInfo == null) {
			switch(chosenNation) {
			case "미국":
				chosenTripInfo = new National(chosenNation, -14, 0.00076, 14);
				break;
			case "이탈리아":
				chosenTripInfo = new National(chosenNation, -8, 0.00069, 11);
				break;
			case "베트남":
				chosenTripInfo = new National(chosenNation, -2, 18.65, 5);
				break;
			default:
				System.out.println("유효하지 않은 국가 선택입니다.");
				break;
			}
			
//			if chosenNation == null)
			//chosenTripInfo.displayInformation();
			System.out.println(chosenNation+"(을)를 예약하시겠습니까? [y/n]");
			Scanner sc = new Scanner(System.in);
			String s = sc.next();

			if (s.toLowerCase().equals("y")) {
				System.out.println("최종 예약 내역입니다.");
				tripInfo.timeDif(chosenTripInfo, depDate, arrDate);
				tripInfo.currency(chosenTripInfo, 1000000);
			}
			else if (s.toLowerCase().equals("n")) {
				System.out.println("다시 국가를 선택하세요.");
				chosenTripInfo = null;
			}
			else {
				System.out.println("다시 입력해주세요.");
				chosenTripInfo = null;
			}
		}
	}
}
