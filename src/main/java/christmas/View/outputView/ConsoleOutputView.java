package christmas.View.outputView;

import christmas.vo.TotalDiscount.TotalDiscount;
import java.util.List;
import java.util.Map;

public class ConsoleOutputView implements OutputView{

    public void print_order_Menu(List<Map<String, Integer>> foodList) {
        System.out.println(ViewMessage.ORDER_MENU_MESSAGE.getMessage());

    }

    public void print_before_Discount_Total_Price(int totalPrice) {
        System.out.println(ViewMessage.BEFORE_DISCOUNT_TOTAL_PRICE_MESSAGE.getMessage());

    }

    public void print_giveAway_Menu(){
        System.out.println(ViewMessage.GIVEAWAY_MENU_MESSAGE.getMessage());
    }

    public void benefits_history(TotalDiscount totalDiscount){
        System.out.println(ViewMessage.BENEFITS_MESSAGE.getMessage());
        if(totalDiscount.getDdayDiscount() != 0) {
            System.out.println("크리스마스 디데이 할인 : -" + totalDiscount.getDdayDiscount() + "원");
        }

        if( totalDiscount.getWeekdayDiscount() != 0) {
            System.out.println("평일 할인 : -" + totalDiscount.getWeekdayDiscount() + "원");
        }

        if( totalDiscount.getWeekendDiscount() != 0) {
            System.out.println("주말 할인 : -" + totalDiscount.getWeekendDiscount() + "원");
        }

        if( totalDiscount.getSpecialDiscount() !=0 ) {
            System.out.println("특별 할인 : -" + totalDiscount.getSpecialDiscount() + "원");
        }


        System.out.println("증정 이벤트 : -" + totalDiscount.getBonusEvent() + "원");
        System.out.println();

        System.out.println("<총 혜택 금액>");
        System.out.println("-" + totalDiscount.TotalDiscountPrice() + "원" + "\n");

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
