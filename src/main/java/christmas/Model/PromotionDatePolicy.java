package christmas.Model;

import java.time.DayOfWeek;
import java.time.LocalDate;

public class PromotionDatePolicy {
    private final LocalDate date;

    public PromotionDatePolicy(VisitDateModel dateModel) {
        this.date = dateModel.takeVisitDate();
    }

    public boolean isWeekDay() {
        // 요일이 일요일부터 목요일까지인지 확인
        DayOfWeek dayOfWeek = date.getDayOfWeek();
        return dayOfWeek != DayOfWeek.FRIDAY && dayOfWeek != DayOfWeek.SATURDAY;
    }

    public boolean isWeekend() {
        // 요일이 금요일 또는 토요일인지 확인
        DayOfWeek dayOfWeek = date.getDayOfWeek();
        return dayOfWeek == DayOfWeek.FRIDAY || dayOfWeek == DayOfWeek.SATURDAY;
    }

    public boolean isEventDateRange() {
        // 이벤트 날짜 범위에 속하는지 확인
        LocalDate startDate = LocalDate.of(2023, 12, 1);
        LocalDate endDate = LocalDate.of(2023, 12, 31);
        return date.isEqual(startDate) || date.isEqual(endDate) || (date.isAfter(startDate) && date.isBefore(endDate));
    }

    public boolean isDDayDateRange() {
        // D-Day 날짜 범위에 속하는지 확인
        LocalDate dDayDate = LocalDate.of(2023, 12, 25);
        return !date.isAfter(dDayDate);
    }

    public boolean isSpecialDate() {
        // 12월 25일 또는 일요일 이면서 25일이 아닌 일요일 인 경우
        return date.getMonth() == java.time.Month.DECEMBER &&
                (date.getDayOfMonth() == 25 || (isSunday() && date.getDayOfMonth() != 25));
    }

    private boolean isSunday() {
        return date.getDayOfWeek() == DayOfWeek.SUNDAY;
    }

}