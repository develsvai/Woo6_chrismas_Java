package christmas.Service.promotionService;

import christmas.Model.OrderMenusModel;
import christmas.Model.PromotionDatePolicy;
import christmas.Model.VisitDateModel;
import christmas.promotionEnum.EventPolicyEnum;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.AbstractMap.SimpleEntry;

public class DDayDiscountService extends PromotionService{

    @Override
    public SimpleEntry<EventPolicyEnum, Integer> discountService(OrderMenusModel order, VisitDateModel date, PromotionDatePolicy policy) {
        LocalDate christmas = LocalDate.of(2023, 12, 25);

        long daysUntilChristmas = ChronoUnit.DAYS.between(date.takeVisitDate(), christmas);
        int discountPerDay = 100;
        int discountAmount = EventPolicyEnum.D_DAY_DISCOUNT.getDiscountAmount() + (int) (daysUntilChristmas * discountPerDay);
        int actualDiscount = Math.min(order.getTotalOrderAmount(), discountAmount);

        return new SimpleEntry<>(EventPolicyEnum.D_DAY_DISCOUNT, actualDiscount);
    }
}
