package christmas.Service.promotionService;

import christmas.Model.OrderMenusModel;
import christmas.Model.PromotionDatePolicy;
import christmas.Model.VisitDateModel;
import christmas.promotionEnum.EventPolicyEnum;
import christmas.promotionEnum.Menu;
import java.util.AbstractMap.SimpleEntry;

public class GiveAwayEventService extends PromotionService {

    @Override
    public SimpleEntry<EventPolicyEnum, Integer> discountService(OrderMenusModel order, VisitDateModel Date, PromotionDatePolicy policy){

        if (order.getTotalOrderAmount() >= 120000 && policy.isEventDateRange()) {
            return new SimpleEntry<>(EventPolicyEnum.GIVEAWAY_DISCOUNT, Menu.CHAMPAGNE.getPrice());
        }
        return new SimpleEntry<>(EventPolicyEnum.GIVEAWAY_DISCOUNT, 0);
    }
}
