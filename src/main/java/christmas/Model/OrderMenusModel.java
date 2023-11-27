package christmas.Model;

import christmas.PromotionEnum.Menu;
import java.util.AbstractMap.SimpleEntry;
import java.util.EnumMap;
import java.util.List;

public class OrderMenusModel {
    private final EnumMap<Menu, Integer> OrderMenu;

    public OrderMenusModel(List<SimpleEntry<String, Integer>> Order){
        OrderMenu = new EnumMap<>(Menu.class);

        Order.forEach(entry -> {
            Menu menu = Menu.of(entry.getKey());
            int quantity = entry.getValue();
            OrderMenu.merge(menu, quantity, Integer::sum);
        });

    }

    public EnumMap<Menu, Integer> getOrderMenu() {
        return OrderMenu;
    }

    /**
     * 이외 모델 에 대한 검증 로직들
     */

}
