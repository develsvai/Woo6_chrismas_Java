package christmas.Service.discountService;

import christmas.Model.OrderMenusModel;
import christmas.Model.PromotionDatePolicy;
import christmas.Model.VisitDateModel;
import christmas.promotionEnum.EventPolicyEnum;
import christmas.promotionEnum.Menu;
import christmas.vo.Benefits;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.EnumMap;
import org.junit.jupiter.api.Order;
import org.mockito.internal.matchers.Or;


public class DiscountService {
    private final OrderMenusModel order;
    private final VisitDateModel date;
    private final PromotionDatePolicy promotionDatePolicy;
    private EnumMap<EventPolicyEnum, Integer> benefits;
    private Integer totalBenefitPrice;

    public DiscountService(OrderMenusModel order, VisitDateModel date) {
        this.order = order;
        this.date = date;
        this.promotionDatePolicy = new PromotionDatePolicy(date);
        this.benefits = new EnumMap<>(EventPolicyEnum.class);
        this.totalBenefitPrice = 0;
    }

    public void cal_christmas_D_Day_Discount_Amount(OrderMenusModel order, VisitDateModel Date) {
        LocalDate christmas = LocalDate.of(2023, 12, 25);
        long daysUntilChristmas = ChronoUnit.DAYS.between(date.takeVisitDate(), christmas);
        int startingAmount = 1000;
        int discountPerDay = 100;
        int discountAmount = startingAmount + (int) (daysUntilChristmas * discountPerDay);
        int actualDiscount = Math.min(order.getTotalOrderAmount(), discountAmount);

        // Apply discount to the benefits map
        benefits.put(EventPolicyEnum.D_DAY_DISCOUNT, actualDiscount); // Modify Menu.NONE as needed
        totalBenefitPrice += actualDiscount;
    }

    public void cal_WeekDay_Discount_Amount() {
        int dessertDiscount = order.getQuantityByCategory(Menu.Category.DESSERT) * 2023;
        if (promotionDatePolicy.isWeekDay()) {
            benefits.put(EventPolicyEnum.WEEKDAY_DISCOUNT, dessertDiscount); // Modify Menu.NONE as needed
            totalBenefitPrice += dessertDiscount;
        }
    }

    public void cal_Weekend_Discount_Amount() {
        int mainDiscount = order.getQuantityByCategory(Menu.Category.MAIN) * 2023;
        if (promotionDatePolicy.isWeekend()) {
            benefits.put(EventPolicyEnum.WEEKEND_DISCOUNT, mainDiscount); // Modify Menu.NONE as needed
            totalBenefitPrice += mainDiscount;
        }
    }

    public void cal_special_Discount_Amount() {
        if ( promotionDatePolicy.isSpecialDate()) {
            benefits.put(EventPolicyEnum.SPECIAL_DISCOUNT, EventPolicyEnum.SPECIAL_DISCOUNT.getDiscountAmount()); // Modify Menu.NONE as needed
            totalBenefitPrice += EventPolicyEnum.SPECIAL_DISCOUNT.getDiscountAmount();
        }
    }

    public void cal_GiveAwayEvent_Amount() {
        int giveawayDiscount = 1;
        if (order.getTotalOrderAmount() >= 120000) {
            benefits.put(EventPolicyEnum.GIVEAWAY_DISCOUNT, Menu.CHAMPAGNE.getPrice()); // Modify Menu.NONE as needed
            totalBenefitPrice += Menu.CHAMPAGNE.getPrice();
        }
    }

    public Integer get_Before_Discount_Total_price(){
        return order.getTotalOrderAmount();
    }
    public  Benefits getBenefits() {
        return new Benefits(benefits);
    }

    public Integer getTotalBenefitPrice() {
        return totalBenefitPrice;
    }
}
