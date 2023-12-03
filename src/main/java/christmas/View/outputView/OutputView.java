package christmas.View.outputView;

import christmas.promotionEnum.EventPolicyEnum;
import christmas.promotionEnum.Menu;
import java.util.AbstractMap.SimpleEntry;
import java.util.EnumMap;

public interface OutputView {
    void print_Welcome_Message();

    void print_PreView_Benefit_Message();

    void print_order_Menu(EnumMap<Menu, Integer> menuIntegerEnumMap);

    void print_before_Discount_Total_Price( int amount);

    void print_giveAway_Menu(SimpleEntry<EventPolicyEnum,Integer> giveawayMenu);

    void benefits_history(EnumMap<EventPolicyEnum, Integer> benefits);

    void print_Total_Benefit_Price();

    void print_After_Discount_Payment_Amount();

    void print_December_Event_Badge();

}
