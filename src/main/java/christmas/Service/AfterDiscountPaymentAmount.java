package christmas.Service;

import christmas.Model.OrderMenusModel;
import christmas.promotionEnum.EventPolicyEnum;
import java.util.AbstractMap.SimpleEntry;
import java.util.EnumMap;
import java.util.Map;

public class AfterDiscountPaymentAmount {
    private final OrderMenusModel order;
    private final EnumMap<EventPolicyEnum, Integer> benefits;

    public AfterDiscountPaymentAmount(OrderMenusModel order, EnumMap<EventPolicyEnum, Integer> benefits ){
        this.order = order;
        this.benefits = benefits;
    }

    public int getAfterDiscountPaymentAmount() {

        int totalBenefitsExcludingGiveaway = benefits.entrySet().stream()
                .filter(entry -> entry.getKey() != EventPolicyEnum.GIVEAWAY_DISCOUNT)
                .mapToInt(Map.Entry::getValue)
                .sum();

        return order.getTotalOrderAmount() - totalBenefitsExcludingGiveaway;
    }
}
