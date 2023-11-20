package christmas.Service.WeekendDiscountService;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.util.List;
import java.util.Map;

public class WeekendDiscountService {

    public int calculateTotalDiscount(List<Map<String, Integer>> itemList, int currentDayOfWeek) {
        LocalDate date = LocalDate.of(2023, 12, currentDayOfWeek);

        DayOfWeek dayOfWeek = date.getDayOfWeek();

        if (isWeekday(dayOfWeek)) {
            return itemList.stream()
                    .map(itemMap -> {
                        int itemPrice = itemMap.values().iterator().next();
                        int discountedPrice = itemPrice - 2023;

                        // 할인된 가격이 음수가 되지 않도록 조정
                        discountedPrice = Math.max(discountedPrice, 0);

                        return discountedPrice;
                    })
                    .mapToInt(Integer::intValue)
                    .sum();
        }
        return 0;
    }

    private boolean isWeekday(DayOfWeek dayOfWeek) {
        // 일요일(7)부터 목요일(4)까지가 평일로 간주
        return dayOfWeek == DayOfWeek.FRIDAY || dayOfWeek == DayOfWeek.SATURDAY;
    }
}
