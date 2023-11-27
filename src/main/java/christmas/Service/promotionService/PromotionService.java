package christmas.Service.promotionService;

import christmas.Model.OrderMenusModel;
import christmas.Model.VisitDateModel;
import java.util.AbstractMap.SimpleEntry;
import java.util.List;

public class PromotionService {
    private OrderMenusModel orderMenus;
    private VisitDateModel visitDate;
    public void createOrderMenusModel(List<SimpleEntry<String, Integer>> order){
        this.orderMenus = new OrderMenusModel(order);
    }

    public void createVisitDateModel(Integer Date) {
        this.visitDate =  new VisitDateModel(Date);
    }





    public void printMenu() {
        orderMenus.getOrderMenu().forEach((key, value) -> System.out.println(key + ": " + value));
    }




}
