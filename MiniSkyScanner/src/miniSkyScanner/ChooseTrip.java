package miniSkyScanner;

import java.util.Calendar;
import java.util.Date;

public class ChooseTrip {
	
	public ChooseTrip(){
		
	}
	
	public void chooseDate() {
		Date deptTime = new Date();
		System.out.println(deptTime);
		Calendar deptDate = Calendar.getInstance();
		System.out.println(deptDate);
	}
	
	
	//여행 선택 - 
	//chooseDate(dept, arr), 
	//chooseNation(출발지, 도착지) 
}
