package christmas.Service.modelConstructor;

import christmas.Model.OrderMenusModel;
import christmas.Model.PromotionDatePolicy;
import christmas.Model.VisitDateModel;
import java.util.AbstractMap.SimpleEntry;
import java.util.Date;
import java.util.List;

public class Constructor {

    public OrderMenusModel createOrderMenusModel(List<SimpleEntry< String, Integer>> order) {
        return new OrderMenusModel(order);
    }


    public VisitDateModel createVisitDateModel( Integer Date) {
        return new VisitDateModel(Date);
    }


    public PromotionDatePolicy createpromotionDatePolicy ( VisitDateModel Date){
        return new PromotionDatePolicy(Date);
    }
}
