package christmas.Service.promotionService;

import christmas.Model.OrderMenusModel;
import christmas.Model.PromotionDatePolicy;
import christmas.Model.VisitDateModel;
import christmas.promotionEnum.EventPolicyEnum;
import java.util.AbstractMap.SimpleEntry;

public class SpecialDiscountService extends PromotionService{

    @Override
    public SimpleEntry<EventPolicyEnum, Integer> discountService(OrderMenusModel order, VisitDateModel Date, PromotionDatePolicy policy){
        if ( policy.isSpecialDate()  && policy.isEventDateRange()) {
            return new SimpleEntry<>(EventPolicyEnum.SPECIAL_DISCOUNT, EventPolicyEnum.SPECIAL_DISCOUNT.getDiscountAmount());
        }
        return new SimpleEntry<>(EventPolicyEnum.SPECIAL_DISCOUNT, 0);
    }
}
