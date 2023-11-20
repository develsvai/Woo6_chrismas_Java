package christmas.Service.SpecialDiscountService;

import java.time.DayOfWeek;
import java.time.LocalDate;

public class SpecialDiscountService {

    public int calculateTotalDiscount(int currentDayOfWeek) {
        LocalDate date = LocalDate.of(2023, 12, currentDayOfWeek);

        DayOfWeek dayOfWeek = date.getDayOfWeek();

        if (isWeekday(dayOfWeek,currentDayOfWeek)) {
            return 1000;
        }
        return 0;
    }

    private boolean isWeekday(DayOfWeek dayOfWeek, int date) {
        return dayOfWeek.getValue() <= 5 || date == 25;
    }
}
