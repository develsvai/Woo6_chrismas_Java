package christmas.ValueObject.FoodChoice;

import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.stream.Collectors;

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

    public List<Map<String, Integer>> getAllFoodNamesWithQuantity() {
        return FoodList.stream()
                .flatMap(categoryMap -> categoryMap.values().stream())
                .flatMap(foodMaps -> foodMaps.stream()
                        .flatMap(foodMap -> foodMap.entrySet().stream()))
                .collect(Collectors.groupingBy(Map.Entry::getKey, Collectors.summingInt(Map.Entry::getValue)))
                .entrySet().stream()
                .map(entry -> Map.of(entry.getKey(), entry.getValue()))
                .collect(Collectors.toList());
    }


    public List<Map<String, List<Map<String, Integer>>>> print () {
        return FoodList;
    }

    public List<Map<String, Integer>> getAppetizer () {
        return getCategory("에피타이저");
    }

    public List<Map<String, Integer>> getMain () {
        return getCategory("메인");
    }

    public List<Map<String, Integer>> getDessert () {
        return getCategory("디저트");
    }

    public List<Map<String, Integer>> getJuice () {
        return getCategory("음료");
    }


}
