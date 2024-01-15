package miniSkyScanner;

public class timetable {
    private String[] usTimetable;
    private int[] usRemainingSeats;
    private int[] usPrices;
    private String[] vietnamTimetable;
    private int[] vietnamRemainingSeats;
    private int[] vietnamPrices;
    private String[] italyTimetable;
    private int[] italyRemainingSeats;
    private int[] italyPrices;
    public timetable() {
        // 한국발 미국행 시간표 초기화
        usTimetable = new String[]{"09:15", "10:20", "12:00", "14:25", "17:30", "20:20", "23:50"  /* 추가 시간표들 */};
        usRemainingSeats = new int[]{50, 100, 112, 55, 120, 44, 80 /* 추가 좌석 수들 */};
        usPrices = new int[]{50000, 60000, 70000, 80000, 90000, 100000, 110000 /* 추가 가격들 */};
        // 한국발 베트남행 시간표 초기화
        vietnamTimetable = new String[]{"08:35", "10:30", "12:10", "13:25", "16:40", "19:20", "22:20"  /* 추가 시간표들 */};
        vietnamRemainingSeats = new int[]{82, 170, 132, 155, 115, 77, 30 /* 추가 좌석 수들 */};
        vietnamPrices = new int[]{45000, 55000, 65000, 75000, 85000, 95000, 105000 /* 추가 가격들 */};
        // 한국발 이탈리아행 시간표 초기화
        italyTimetable = new String[]{"08:50", "11:30", "14:40", "15:55", "18:30", "19:50", "21:20"  /* 추가 시간표들 */};
        italyRemainingSeats = new int[]{40, 0, 142, 200, 140, 24, 15 /* 추가 좌석 수들 */};
        italyPrices = new int[]{70000, 80000, 90000, 100000, 110000, 120000, 130000 /* 추가 가격들 */};
    }
    public String[] getTimetable(String country) {
        switch (country) {
            case "미국":
                return usTimetable;
            case "베트남":
                return vietnamTimetable;
            case "이탈리아":
                return italyTimetable;
            default:
                throw new IllegalArgumentException("유효하지 않은 국가입니다.");
        }
    }
    public int[] getRemainingSeats(String country) {
        switch (country) {
            case "미국":
                return usRemainingSeats;
            case "베트남":
                return vietnamRemainingSeats;
            case "이탈리아":
                return italyRemainingSeats;
            default:
                throw new IllegalArgumentException("유효하지 않은 국가입니다.");
        }
    }
    public int[] getPrices(String country) {
        switch (country) {
            case "미국":
                return usPrices;
            case "베트남":
                return vietnamPrices;
            case "이탈리아":
                return italyPrices;
            default:
                throw new IllegalArgumentException("유효하지 않은 국가입니다.");
        }
    }
    public void showTimetableWithLabelsSeatsAndPrices(String country) {
        String[] timetable = getTimetable(country);
        int[] remainingSeats = getRemainingSeats(country);
        int[] prices = getPrices(country);
        System.out.printf("%-5s %-6s %-7s %4s\n", "번호", "시간", "잔여좌석", "가격");
        System.out.println("----------------------------------");
        for (int i = 0; i < timetable.length; i++) {
            System.out.printf("%-5d %-6s %5d %8d원\n", i + 1, timetable[i], remainingSeats[i], prices[i]);
        }
    }
}