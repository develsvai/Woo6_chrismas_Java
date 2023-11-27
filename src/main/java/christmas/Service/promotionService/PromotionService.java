package christmas.Service.promotionService;

import christmas.Model.OrderMenusModel;
import christmas.Model.VisitDateModel;
import christmas.vo.DiscountAmount;
import java.util.AbstractMap.SimpleEntry;
import java.util.List;

public class PromotionService {
    private OrderMenusModel orderMenus;
    private VisitDateModel visitDate;

    public void createOrderMenusModel(List<SimpleEntry<String, Integer>> order) {
        this.orderMenus = new OrderMenusModel(order);
    }

    public void createVisitDateModel(Integer Date) {
        this.visitDate = new VisitDateModel(Date);
    }

    public OrderMenusModel getOrderMenus() {
        return orderMenus;
    }

    public DiscountAmount get_chrisMas_D_Day_Discount_Amount() {

    }

    public DiscountAmount get_WeekDay_Discount_Amount(){

    }

    public DiscountAmount get_Weekend_Discount_Amount(){

    }

    public DiscountAmount get_special_Discount_Amount(){

    }

    public DiscountAmount get_GiveAwayEvent_Amount(){

    }

}
