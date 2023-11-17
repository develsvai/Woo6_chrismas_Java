package christmas.Dto;

import christmas.MenuValue.Menuvalue;
import christmas.ValueObject.FoodChoice.FoodChoice;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.stream.Collectors;

public class FoodChoiceDto {

    public FoodChoice foodListMap(String orderList) {
        Map<String, Integer> stringToMap = convertStringToList(orderList);
        List<Map<String, List<Map<String, Integer>>>> processedOrder = processOrder(stringToMap);
        return new FoodChoice(processedOrder);
    }

    private static List<Map<String, List<Map<String, Integer>>>> processOrder(Map<String, Integer> order) {
        return order.entrySet().stream()
                .map(orderEntry -> {
                    String menuName = orderEntry.getKey();
                    int quantity = orderEntry.getValue();

                    return Arrays.stream(Menuvalue.values())
                            .filter(menu -> menu.name().equals(menuName))
                            .findFirst()
                            .map(menu -> {
                                String category = menu.getCategory();

                                return Map.of(category, List.of(Map.of(menuName, quantity)));
                            })
                            .orElse(null);
                })
                .filter(Objects::nonNull)
                .collect(Collectors.groupingBy(
                        categoryMap -> categoryMap.keySet().iterator().next(),
                        Collectors.mapping(categoryMap -> categoryMap.values().iterator().next().get(0),
                                Collectors.toList())
                ))
                .entrySet().stream()
                .map(entry -> Map.of(entry.getKey(), entry.getValue()))
                .collect(Collectors.toList());
    }

    private static Map<String, Integer> convertStringToList(String orderString) {
        return Arrays.stream(orderString.split(","))
                .map(item -> item.split("-"))
                .filter(parts -> parts.length == 2)
                .collect(Collectors.toMap(
                        parts -> parts[0],
                        parts -> Integer.parseInt(parts[1])
                ));
    }

}