package christmas.Service.TotalPriceService;

import christmas.MenuValue.Menuvalue;
import christmas.ValueObject.FoodChoice.FoodChoice;


public class TotalPrice {

    private final FoodChoice foodChoice;

    public TotalPrice( FoodChoice foodChoice) {
        this.foodChoice = foodChoice;
    }
    public int calculateTotalPrice() {

        return foodChoice.getAllFoodNamesWithQuantity().stream()
                .mapToInt(orderEntry -> {
                    String foodName = orderEntry.keySet().iterator().next();
                    int quantity = orderEntry.get(foodName);

                    Menuvalue menuvalue = Menuvalue.valueOf(foodName);
                    int price = menuvalue.getPrice();

                    return quantity * price;
                })
                .sum();
    }

}
