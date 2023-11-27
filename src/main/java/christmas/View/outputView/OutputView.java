package christmas.View.outputView;

import christmas.PromotionEnum.Menu;
import christmas.vo.TotalDiscount.TotalDiscount;
import java.util.EnumMap;

public interface OutputView {
    void print_Welcome_Message();

    void print_PreView_Benefit_Message();

    void print_order_Menu(EnumMap<Menu, Integer> menuIntegerEnumMap);

    void print_before_Discount_Total_Price();

    void print_giveAway_Menu();

    void benefits_history(TotalDiscount totalDiscount);

    void print_Total_Benefit_Price();

    void print_After_Discount_Payment_Amount();

    void print_December_Event_Badge();

}
