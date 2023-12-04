package christmas.Service.promotionService;

import christmas.Model.OrderMenusModel;
import christmas.Model.PromotionDatePolicy;
import christmas.Model.VisitDateModel;
import christmas.promotionEnum.EventPolicyEnum;
import christmas.promotionEnum.Menu;
import java.util.AbstractMap.SimpleEntry;


public class WeekendDiscountService  extends PromotionService {
    public SimpleEntry<EventPolicyEnum, Integer> discountService(OrderMenusModel order, VisitDateModel Date, PromotionDatePolicy policy){
        int mainDiscount = order.getQuantityByCategory(Menu.Category.MAIN) * 2023;
        if (policy.isWeekend()  &&  policy.isEventDateRange()) {
            return new SimpleEntry<>(EventPolicyEnum.WEEKEND_DISCOUNT, mainDiscount); // Modify Menu.NONE as needed
        }
        return new SimpleEntry<>(EventPolicyEnum.WEEKEND_DISCOUNT,0); // Modify Menu.NONE as needed
    }
}
