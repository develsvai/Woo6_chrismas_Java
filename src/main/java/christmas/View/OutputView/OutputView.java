package christmas.View.OutputView;

import christmas.ValueObject.TotalDiscount.TotalDiscount;
import java.util.List;
import java.util.Map;

public class OutputView {

    public void orderMenu(List<Map<String, Integer>> foodList) {
        System.out.println("<주문 메뉴>");

        for (Map<String, Integer> itemMap : foodList) {
            String itemName = itemMap.keySet().iterator().next();
            int quantity = itemMap.values().iterator().next();

            System.out.println(itemName + " " + quantity + "개");
        }
        System.out.println();
    }

    public void beforeDiscountTotalPrice(int totalPrice) {
        System.out.println("<할인 전 총주문 금액>");
        System.out.printf("%,d원\n", totalPrice);
        System.out.println();
    }


    public void BonusEvent(){
        System.out.println("<증정메뉴>");
        System.out.println("샴페인 1개");
        System.out.println();
    }


    public void profitList(TotalDiscount totalDiscount){
        System.out.println("<혜택 내역>");
        System.out.println("크리스마스 디데이 할인 : -" + totalDiscount.getDdayDiscount() + "원");
        System.out.println("평일 할인 : -" + totalDiscount.getWeekdayDiscount() + "원");
        System.out.println("주말 할인 : -" + totalDiscount.getWeekendDiscount() + "원");
        System.out.println("특별 할인 : -" + totalDiscount.getSpecialDiscount() + "원");
        System.out.println("증정 이벤트 : -" + totalDiscount.getBonusEvent() + "원");
        System.out.println();

        System.out.println("<총 혜택 금액>");
        System.out.println("-" + totalDiscount.TotalDiscountPrice() + "원" + "\n");

    }



}
