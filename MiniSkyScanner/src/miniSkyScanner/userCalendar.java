package miniSkyScanner;

import java.util.Scanner;
import java.util.Calendar;
public class userCalendar {
    public void showCal(int year, int month) {
        System.out.printf("    <<%4d년 %2d월>>\n", year, month);
        System.out.println("  일   월  화  수   목   금  토");
        Calendar cal = Calendar.getInstance();
        cal.set(year, month - 1, 1);
        int firstDayOfWeek = cal.get(Calendar.DAY_OF_WEEK);
        int lastDay = cal.getActualMaximum(Calendar.DAY_OF_MONTH);
        int dayOfMonth = 1;
        // 첫 주 시작 전까지는 공백 출력
        for (int i = 1; i < firstDayOfWeek; i++) {
            System.out.print("    ");
        }
        // 날짜 출력
        while (dayOfMonth <= lastDay) {
            System.out.printf("%3d ", dayOfMonth);
            cal.set(year, month - 1, dayOfMonth);
            int dayOfWeek = cal.get(Calendar.DAY_OF_WEEK);
            if (dayOfWeek == Calendar.SATURDAY) {
                System.out.println();
            }
            dayOfMonth++;
        }
    }
    public void showCal(int year, int month, int highlightDay) {
        System.out.printf("    <<%4d년 %2d월>>\n", year, month);
        System.out.println("  일   월  화  수   목   금  토");
        Calendar cal = Calendar.getInstance();
        cal.set(year, month - 1, 1);
        int firstDayOfWeek = cal.get(Calendar.DAY_OF_WEEK);
        int lastDay = cal.getActualMaximum(Calendar.DAY_OF_MONTH);
        int dayOfMonth = 1;
        // 첫 주 시작 전까지는 공백 출력
        for (int i = 1; i < firstDayOfWeek; i++) {
            System.out.print("    ");
        }
        // 날짜 출력
        while (dayOfMonth <= lastDay) {
            boolean isHighlighted = (year == cal.get(Calendar.YEAR) &&
                    month == cal.get(Calendar.MONTH) + 1 &&
                    dayOfMonth == highlightDay);
            if (isHighlighted) {
                // ANSI Escape 코드로 글자를 빨간색으로 변경
                System.out.print("\u001B[31m");
            }
            System.out.printf("%3d ", dayOfMonth);
            if (isHighlighted) {
                // ANSI Escape 코드로 글자 색상을 원래 색상(검은색)으로 변경
                System.out.print("\u001B[0m");
            }
            cal.set(year, month - 1, dayOfMonth);
            int dayOfWeek = cal.get(Calendar.DAY_OF_WEEK);
            if (dayOfWeek == Calendar.SATURDAY) {
                System.out.println();
            }
            dayOfMonth++;
        }
    }
    public void showCal(int year, int month, int highlightDay1, int highlightDay2) {
        System.out.printf("    <<%4d년 %2d월>>\n", year, month);
        System.out.println(" 일  월  화  수  목  금  토");
        Calendar cal = Calendar.getInstance();
        cal.set(year, month - 1, 1);
        int firstDayOfWeek = cal.get(Calendar.DAY_OF_WEEK);
        int lastDay = cal.getActualMaximum(Calendar.DAY_OF_MONTH);
        int dayOfMonth = 1;
        // 첫 주 시작 전까지는 공백 출력
        for (int i = 1; i < firstDayOfWeek; i++) {
            System.out.print("    ");
        }
        // 날짜 출력
        while (dayOfMonth <= lastDay) {
        	boolean isHighlighted = (year == cal.get(Calendar.YEAR) &&
                    month == cal.get(Calendar.MONTH) + 1 &&
                    dayOfMonth >= highlightDay1 &&
                    dayOfMonth <= highlightDay2);
        	if (isHighlighted) {
                // ANSI Escape 코드로 글자를 빨간색으로 변경
                System.out.print("\u001B[31m");
            }
            System.out.printf("%3d ", dayOfMonth);
            if (isHighlighted) {
                // ANSI Escape 코드로 글자 색상을 원래 색상(검은색)으로 변경
                System.out.print("\u001B[0m");
            }
            cal.set(year, month - 1, dayOfMonth);
            int dayOfWeek = cal.get(Calendar.DAY_OF_WEEK);
            if (dayOfWeek == Calendar.SATURDAY) {
                System.out.println();
            }
            dayOfMonth++;
        }
        System.out.println();
    }
}














