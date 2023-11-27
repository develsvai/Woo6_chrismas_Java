package christmas.Service.promotionService;

import christmas.Model.OrderMenusModel;
import christmas.Model.VisitDateModel;
import christmas.Service.discountService.DiscountService;
import christmas.vo.Benefits;
import java.util.AbstractMap.SimpleEntry;
import java.util.List;

public class PromotionService {
    private OrderMenusModel orderMenus;
    private VisitDateModel visitDate;

    private DiscountService discountService ;

    public PromotionService(){
        this.discountService = new DiscountService(orderMenus,visitDate);
    }

    public void createOrderMenusModel(List<SimpleEntry<String, Integer>> order) {
        this.orderMenus = new OrderMenusModel(order);
    }

    public void createVisitDateModel(Integer Date) {
        this.visitDate = new VisitDateModel(Date);
    }

    public OrderMenusModel getOrderMenus() {
        return orderMenus;
    }

    public void promotion() {
        discountService.cal_christmas_D_Day_Discount_Amount();
        discountService.cal_Weekend_Discount_Amount();
        discountService.cal_Weekend_Discount_Amount();
        discountService.cal_special_Discount_Amount();
        discountService.cal_GiveAwayEvent_Amount();

    }

    public Integer get_Before_Discount_Total_price(){
        return discountService.get_Before_Discount_Total_price();
    }
    public Benefits getBenefits() {
        return discountService.getBenefits();
    }

    public Integer getTotalBenefitPrice() {
        return discountService.getTotalBenefitPrice();
    }


}
