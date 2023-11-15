package christmas.ValueObject.FoodChoice;

import java.util.List;
import java.util.Map;

public class FoodChoice {

    private final List<Map<String,List<Map< String, Integer>>>> FoodList;


    public FoodChoice(  List<Map<String,List<Map< String, Integer>>>> foodList ) {
        this.FoodList = foodList;
    }

    private List<Map<String, Integer>> getCategory(String categoryName) {
        return FoodList.stream()
                .filter(categoryMap -> categoryMap.containsKey(categoryName))
                .findFirst()
                .map(categoryMap -> categoryMap.get(categoryName))
                .orElse(null);
    }



    public List<Map<String, Integer>> getAppetizer () {
        return getCategory("Appetizer");
    }

    public List<Map<String, Integer>> getMain () {
        return getCategory("Main");
    }

    public List<Map<String, Integer>> getDessert () {
        return getCategory("Dessert");
    }

    public List<Map<String, Integer>> getJuice () {
        return getCategory("Juice");
    }


}
