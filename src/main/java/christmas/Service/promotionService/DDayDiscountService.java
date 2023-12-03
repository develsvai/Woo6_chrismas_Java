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

        int actualDiscount = 1000 + (date.takeVisitDate().getDayOfMonth()-1)*100;

        return new SimpleEntry<>(EventPolicyEnum.D_DAY_DISCOUNT, actualDiscount);
    }
}
