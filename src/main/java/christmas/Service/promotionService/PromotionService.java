package christmas.Service.promotionService;

import christmas.Model.OrderMenusModel;
import christmas.Model.PromotionDatePolicy;
import christmas.Model.VisitDateModel;
import christmas.promotionEnum.EventPolicyEnum;
import java.util.AbstractMap.SimpleEntry;


public abstract class PromotionService {
   abstract SimpleEntry<EventPolicyEnum, Integer> discountService(OrderMenusModel order, VisitDateModel Date, PromotionDatePolicy policy);

}
