package christmas.Service.promotionService;

import christmas.Model.OrderMenusModel;
import christmas.Model.PromotionDatePolicy;
import christmas.Model.VisitDateModel;
import christmas.promotionEnum.EventPolicyEnum;
import christmas.promotionEnum.Menu;
import java.util.AbstractMap.SimpleEntry;

public class WeekDayDiscountService extends PromotionService{
    @Override
    public SimpleEntry<EventPolicyEnum, Integer> discountService(OrderMenusModel order, VisitDateModel Date, PromotionDatePolicy policy){
        int dessertDiscount = order.getQuantityByCategory(Menu.Category.DESSERT) * EventPolicyEnum.WEEKDAY_DISCOUNT.getDiscountAmount();
        if (policy.isWeekDay()) {
            return new SimpleEntry<>(EventPolicyEnum.WEEKDAY_DISCOUNT, dessertDiscount);
        }
        return new SimpleEntry<>(EventPolicyEnum.WEEKDAY_DISCOUNT, 0);
    }
}
