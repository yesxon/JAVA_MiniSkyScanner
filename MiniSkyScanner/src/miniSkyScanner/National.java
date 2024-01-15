package miniSkyScanner;
import java.security.DrbgParameters.NextBytes;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.*;

public class National extends ChooseTrip {
	private String nation; // 국가 이름
	private int timeDifference; // 시차 (시간)
	private double exchangeRate; // 원화 기준 환율
	private int flightTime; // 비행 시간 (시간)
	// 생성자: 국가 정보 초기화
	public National(String nation, int timeDifference, double exchangeRate, int flightTime) {
		this.nation = nation;
		this.timeDifference = timeDifference;
		this.exchangeRate = exchangeRate;
		this.flightTime = flightTime;
	}
    public String getNation() {
        return nation;
    }
    public void setNation(String nation) {
        this.nation = nation;
    }
    public int getTimeDifference() {
        return timeDifference;
    }
    public void setTimeDifference(int timeDifference) {
        this.timeDifference = timeDifference;
    }
    public double getExchangeRate() {
        return exchangeRate;
    }
    public void setExchangeRate(double exchangeRate) {
        this.exchangeRate = exchangeRate;
    }
    public int getFlightTime() {
        return flightTime;
    }
    public void setFlightTime(int flightTime) {
        this.flightTime = flightTime;
    }
    
	public void displayInformation() {
		// 현재 시간에 시차를 더하여 국가별 시간을 계산
		LocalDateTime localDateTime = LocalDateTime.now().plusHours(timeDifference);
		// 날짜 및 시간 형식 지정을 위한 포매터
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
		// 국가 정보 출력
		System.out.println("국가: " + nation);
		System.out.println("날짜와 시간: " + localDateTime.format(formatter));
		System.out.println("시차: " + timeDifference + " 시간");
		System.out.println("인천공항에서의 비행 시간: " + flightTime + " 시간");
		System.out.println("원화 기준 환율: " + exchangeRate);
		System.out.println("----------------------------");
	}
	// 실행 메소드
}
