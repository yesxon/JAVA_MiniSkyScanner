package miniSkyScanner;


import java.text.DecimalFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.*;

public class TripSummary {
		DateTimeFormatter dateFormatter1=DateTimeFormatter.ofPattern("yyyyMMddHH:mm");
		DateTimeFormatter dateFormatter2=DateTimeFormatter.ofPattern("yyyy년 MM월 dd일 HH시 mm분");
		DecimalFormat decimalFormatter = new DecimalFormat("#.##");
		Map<String, String> currency = new HashMap<String, String>() {{
			put("미국","달러");
			put("이탈리아","유로");
			put("베트남","동");
		}};

		
	void timeDif(National na, String deptTime1, String deptTime2) { // deptTime1: 여행 출발날 비행기 타는 시간, deptTime2: 한국으로 돌아오는 날 여행지에서 비행기를 타는 시간
		LocalDateTime dateTime1 = LocalDateTime.parse(deptTime1, dateFormatter1);
		LocalDateTime dateTime2 = LocalDateTime.parse(deptTime2, dateFormatter1); // 스트링으로 받은 시간을 LocalDateTime으로 변환
		LocalDateTime arrtime1 = dateTime1.plusHours(na.getTimeDifference()+na.getFlightTime());
		LocalDateTime arrtime2 = dateTime2.plusHours(na.getFlightTime()-(na.getTimeDifference())); // 각자 시차와 비행 시간 계산 후 도착지의 시간을 LocalDateTime로 지정 
		System.out.println("비행 시간은 약 "+na.getFlightTime()+"시간 입니다");
		System.out.println(dateTime1.format(dateFormatter2)+"에 인천 공항에서 출발했을 때");
		System.out.println("여행지 도착 시 현지 시각은 "+arrtime1.format(dateFormatter2)+"입니다");
		System.out.println(dateTime2.format(dateFormatter2)+"에 현지 공항에서 출발했을 때");
		System.out.println("인천 공항 도착 시 시각은 "+arrtime2.format(dateFormatter2)+"입니다"); //LocalDateTime으로 된 도착지 시간을 다시 스트링으로 변환 후 출력
		System.out.println("----------------------------");
		
	}
	void currency(National na, float budget) {
		double exchangedBudget = budget*na.getExchangeRate();
		String formattedBudget = decimalFormatter.format(exchangedBudget); // 소수점 표기 두자리
		System.out.println("현지 환율은 1000원당 "+decimalFormatter.format(na.getExchangeRate()*1000)+currency.get(na.getNation())+"입니다.");
		System.out.println("예산을 전부 환전하면 "+formattedBudget+currency.get(na.getNation())+"입니다.");
		
	}
}