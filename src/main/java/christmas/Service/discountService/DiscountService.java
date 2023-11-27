package christmas.Service.discountService;

import christmas.Model.OrderMenusModel;
import christmas.Model.PromotionDatePolicy;
import christmas.Model.VisitDateModel;
import christmas.promotionEnum.Menu;
import christmas.vo.DiscountAmount;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class DiscountService {
    private final OrderMenusModel order ;
    private final VisitDateModel Date;
    private final PromotionDatePolicy promotionDatePolicy;


    public DiscountService(OrderMenusModel order , VisitDateModel Date )  {
        this.order = order;
        this.Date = Date;
        this.promotionDatePolicy = new PromotionDatePolicy(Date);
    }

    public DiscountAmount cal_christmas_D_Day_Discount_Amount() {
        LocalDate christmas = LocalDate.of(2023, 12, 25);
        long daysUntilChristmas = ChronoUnit.DAYS.between(Date.takeVisitDate(), christmas);
        int startingAmount = 1000;
        int discountPerDay = 100;
        int discountAmount = startingAmount + (int) (daysUntilChristmas * discountPerDay);
        return new DiscountAmount(Math.min(order.getTotalOrderAmount(), discountAmount));
    }

    public DiscountAmount cal_WeekDay_Discount_Amount() {
        int dessertDiscount = order.getQuantityByCategory(Menu.Category.DESSERT) * 2023;
        if(promotionDatePolicy.isWeekDay()) {
            return new DiscountAmount(dessertDiscount);
        }
    }

    public DiscountAmount cal_Weekend_Discount_Amount() {
        int mainDiscount = order.getQuantityByCategory(Menu.Category.MAIN) * 2023;
        if(promotionDatePolicy.isWeekend()) {
            return new DiscountAmount(mainDiscount);
        }
    }

    public DiscountAmount cal_special_Discount_Amount() {
        int specialDiscount = promotionDatePolicy.isSpecialDate();
        if(promotionDatePolicy.isSpecialDate()){

        }
        return new DiscountAmount(Math.min(order.getTotalOrderAmount(), specialDiscount));
    }

    public DiscountAmount cal_GiveAwayEvent_Amount() {
        int giveawayDiscount = (order.getTotalOrderAmount() >= 120000) ? 1 : 0;
        return new DiscountAmount(giveawayDiscount);
    }

}
