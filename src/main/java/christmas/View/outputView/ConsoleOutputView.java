package christmas.View.outputView;

import christmas.promotionEnum.Menu;
import java.util.EnumMap;


public class ConsoleOutputView implements OutputView{

    public void print_Welcome_Message(){
        System.out.println(ViewMessage.WELCOME_MESSAGE.getMessage());
    }

    public void print_PreView_Benefit_Message() {
        System.out.println(ViewMessage.PREVIEW_BENEFIT_MESSAGE.getMessage());
    }

    public void print_order_Menu(EnumMap<Menu, Integer> orderMenus) {
        System.out.println(ViewMessage.ORDER_MENU_MESSAGE.getMessage());
        orderMenus.forEach((key, value) -> System.out.println(key.getName() + ": " + value + "개"));
    }

    public void print_before_Discount_Total_Price() {
        System.out.println(ViewMessage.BEFORE_DISCOUNT_TOTAL_PRICE_MESSAGE.getMessage());

    }

    public void print_giveAway_Menu(){
        System.out.println(ViewMessage.GIVEAWAY_MENU_MESSAGE.getMessage());
    }

    public void benefits_history(){

    }

    public void print_Total_Benefit_Price(){
        System.out.println(ViewMessage.TOTAL_BENEFIT_PRICE_MESSAGE.getMessage());

    }

    public void print_After_Discount_Payment_Amount(){
        System.out.println(ViewMessage.AFTER_DISCOUNT_PAYMENT_AMOUNT_MESSAGE.getMessage());

    }


    public void print_December_Event_Badge() {
        System.out.println(ViewMessage.DECEMBER_EVENT_BADGE_MESSAGE.getMessage());

    }
}
