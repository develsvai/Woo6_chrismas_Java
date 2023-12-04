package christmas.View.outputView;

import christmas.Service.AfterDiscountPaymentAmount;
import christmas.promotionEnum.EventPolicyEnum;
import christmas.promotionEnum.Menu;
import java.time.LocalDate;
import java.util.AbstractMap.SimpleEntry;
import java.util.EnumMap;
import java.util.Map;


public class ConsoleOutputView implements OutputView{

    public void print_Welcome_Message(){
        System.out.println(ViewMessage.WELCOME_MESSAGE.getMessage());
    }

    public void print_PreView_Benefit_Message(LocalDate date) {
        System.out.printf(ViewMessage.PREVIEW_BENEFIT_MESSAGE.getMessage()+ "%n", date.getDayOfMonth());
    }

    public void print_order_Menu(EnumMap<Menu, Integer> orderMenus) {
        System.out.println(ViewMessage.ORDER_MENU_MESSAGE.getMessage());
        for (Map.Entry<Menu, Integer> entry : orderMenus.entrySet()) {
            Menu key = entry.getKey();
            Integer value = entry.getValue();
            String formattedValue1 = String.format("%s %d개",key.getName(),value);
            System.out.println(formattedValue1);
        }
        System.out.println();
    }

    public void print_before_Discount_Total_Price( int amount ) {
        System.out.println(ViewMessage.BEFORE_DISCOUNT_TOTAL_PRICE_MESSAGE.getMessage());
        String formattedValue1 = String.format("%,d원" + "%n",amount );
        System.out.println(formattedValue1);
    }

    public void print_giveAway_Menu(SimpleEntry<EventPolicyEnum,Integer> giveawayMenu){
        System.out.println(ViewMessage.GIVEAWAY_MENU_MESSAGE.getMessage());

        if(giveawayMenu.getValue() == 0){
            System.out.println("없음");
        }
        if(giveawayMenu.getValue() > 0) {
            System.out.println( "샴페인 1개");
        }

        System.out.println();
    }

    public void benefits_history(EnumMap<EventPolicyEnum, Integer> benefits){
        System.out.println(ViewMessage.BENEFITS_MESSAGE.getMessage());

        boolean allZeros = true;
        for (Map.Entry<EventPolicyEnum, Integer> entry : benefits.entrySet()) {

            if(entry.getValue() > 0){
                String formattedValue1 = String.format("%s: -%,d원", entry.getKey().getDescription(), entry.getValue());
                System.out.println(formattedValue1);
                allZeros = false;
            }
        }

        if (allZeros) {
            System.out.println("없음");
        }

        System.out.println();
    }

    public void print_Total_Benefit_Price( Integer totalAmount){
        System.out.println(ViewMessage.TOTAL_BENEFIT_PRICE_MESSAGE.getMessage());
        String formattedValue1 = String.format("-" +"%,d원" + "%n", totalAmount );
        System.out.println(formattedValue1);
    }

    public void print_After_Discount_Payment_Amount(int amount){
        System.out.println(ViewMessage.AFTER_DISCOUNT_PAYMENT_AMOUNT_MESSAGE.getMessage());
        String formattedValue1 = String.format("%,d원" + "%n",amount );
        System.out.println(formattedValue1);
    }


    public void print_December_Event_Badge(int amount) {
        System.out.println(ViewMessage.DECEMBER_EVENT_BADGE_MESSAGE.getMessage());
        if (amount >= 20000) {
            System.out.println("산타");
        } else if (amount >= 10000) {
            System.out.println("트리");
        } else if (amount >= 5000) {
            System.out.println("별");
        }else{
            System.out.println("없음");
        }
    }
}
