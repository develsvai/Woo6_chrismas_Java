package christmas.Model;

import christmas.promotionEnum.Menu;
import java.util.AbstractMap.SimpleEntry;
import java.util.EnumMap;
import java.util.List;
import java.util.Map;

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


    public int getTotalOrderAmount() {
        return OrderMenu.entrySet().stream()
                .mapToInt(entry -> entry.getKey().getPrice() * entry.getValue())
                .sum();
    }

    public int getQuantityByCategory(Menu.Category category) {
        return OrderMenu.entrySet().stream()
                .filter(entry -> entry.getKey().getCategory() == category)
                .map(Map.Entry::getValue)
                .reduce(0, Integer::sum);
    }

    /**
     * 이외 모델 에 대한 검증 로직들
     */

}
