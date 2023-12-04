package christmas.View.outputView;

import christmas.Service.AfterDiscountPaymentAmount;
import christmas.promotionEnum.EventPolicyEnum;
import christmas.promotionEnum.Menu;
import java.time.LocalDate;
import java.util.AbstractMap.SimpleEntry;
import java.util.EnumMap;

public interface OutputView {
    void print_Welcome_Message();

    void print_PreView_Benefit_Message(LocalDate date);

    void print_order_Menu(EnumMap<Menu, Integer> menuIntegerEnumMap);

    void print_before_Discount_Total_Price( int amount);

    void print_giveAway_Menu(SimpleEntry<EventPolicyEnum,Integer> giveawayMenu);

    void benefits_history(EnumMap<EventPolicyEnum, Integer> benefits);

    void print_Total_Benefit_Price( Integer totalAmount);

    void print_After_Discount_Payment_Amount(int amount);

    void print_December_Event_Badge( int amount);

}
