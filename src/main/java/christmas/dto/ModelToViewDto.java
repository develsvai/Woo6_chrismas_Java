package christmas.dto;

import christmas.Model.OrderMenusModel;
import christmas.promotionEnum.Menu;
import java.util.EnumMap;

public class ModelToViewDto {
    private OrderMenusModel orderMenusModel;
    public ModelToViewDto(OrderMenusModel orderMenusModel){
        this.orderMenusModel = orderMenusModel;
    }

    public EnumMap<Menu, Integer> orderMenuTransferModelToView(){
        return orderMenusModel.getOrderMenu();
    }

    public int TransferModelToViewTotalAmount(){
        return orderMenusModel.getTotalOrderAmount();
    }

}
