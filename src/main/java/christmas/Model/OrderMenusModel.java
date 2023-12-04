package christmas.Model;

import christmas.promotionEnum.Menu;
import christmas.promotionEnum.Menu.Category;
import java.util.AbstractMap.SimpleEntry;
import java.util.EnumMap;
import java.util.List;
import java.util.Map;

public class OrderMenusModel {
    private final EnumMap<Menu, Integer> OrderMenu;

    private static final String ERROR_INVALID_QUANTITY = "[ERROR] 메뉴의 개수는 1 이상이어야 합니다. 다시 입력해 주세요.";
    private static final String ERROR_MAX_ORDER_LIMIT = "[ERROR] 한 번에 주문 가능한 메뉴의 최대 개수는 20개입니다. 다시 입력해 주세요.";
    private static final String ERROR_INVALID_MENU_FORMAT = "[ERROR] 메뉴의 형식이 올바르지 않습니다. 다시 입력해 주세요.";
    private static final String ERROR_DUPLICATE_MENU = "[ERROR] 중복된 메뉴는 주문할 수 없습니다. 다시 입력해 주세요.";
    private static final String ERROR_MINIMUM_ORDER_AMOUNT = "[ERROR] 총주문 금액이 10,000원 이상이어야 합니다.";
    private static final String ERROR_BEVERAGE_ONLY_ORDER = "[ERROR] 음료만 주문 시 주문이 불가능합니다.";
    private static final String ERROR_MENU_NOT_IN_MENU = "[ERROR] 메뉴 판에 없는 메뉴는 주문할 수 없습니다.";

    public OrderMenusModel(List<SimpleEntry<String, Integer>> Order) {
        OrderMenu = new EnumMap<>(Menu.class);

        for (SimpleEntry<String, Integer> entry : Order) {
            Menu menu = Menu.of(entry.getKey());
            validNotInMenu(menu);
            int quantity = entry.getValue();
            validateOrder(menu, quantity);
            OrderMenu.merge(menu, quantity, Integer::sum);
        }
        validMenuCountRange(OrderMenu);
//        validTotalAmount();
//        validOnlyDrink();
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

    private void validTotalAmount() {
        //주문금액 만원 이상
        if (getTotalOrderAmount() < 10000) {
            throw new IllegalArgumentException(ERROR_MINIMUM_ORDER_AMOUNT);
        }
    }

    private void validOnlyDrink() {
        int main = getQuantityByCategory(Category.MAIN);
        int dessert = getQuantityByCategory(Category.DESSERT);
        int drink = getQuantityByCategory(Category.DRINK);
        int APPETIZER = getQuantityByCategory(Category.APPETIZER);

        if (drink > 0 && main == 0 & dessert == 0 && APPETIZER == 0) {
            throw new IllegalArgumentException(ERROR_BEVERAGE_ONLY_ORDER);
        }

        if (drink < 1 || main < 1 || dessert < 1 || APPETIZER < 1) {
            throw new IllegalArgumentException(ERROR_INVALID_QUANTITY);
        }
    }

    private void validNotInMenu(Menu menu) {
        if (menu.getName().equals("잘못된메뉴")) {
            throw new IllegalArgumentException(ERROR_MENU_NOT_IN_MENU);
        }
    }

    private void validMenuCountRange(EnumMap<Menu, Integer> OrderMenu) {
        if (OrderMenu.size() > 20) {
            throw new IllegalArgumentException(ERROR_MAX_ORDER_LIMIT);
        }
    }

    private void validateOrder(Menu menu, int quantity) {
        // 중복된 메뉴는 주문할 수 없습니다.
        if (OrderMenu.containsKey(menu)) {
            throw new IllegalArgumentException(ERROR_DUPLICATE_MENU);
        }

    }

}
