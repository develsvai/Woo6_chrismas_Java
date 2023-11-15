package christmas.Dto;

import christmas.MenuValue.Menuvalue;
import christmas.Util.TypeConverter;
import christmas.ValueObject.FoodChoice.FoodChoice;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class FoodChoiceDto {

    public FoodChoice foodListMap (String foodList){
        List<Map<String, Integer>> StringToMap =  convertStringToList(foodList);
        return new FoodChoice(processOrders(StringToMap));
    }

    private  Map<String, Integer> convertOrderStringToMap(String orderString) {
        return Arrays.stream(orderString.split(","))
                .map(item -> item.split("-"))
                .filter(parts -> parts.length == 2)
                .collect(Collectors.toMap(
                        parts -> parts[0].trim(),
                        parts -> Integer.parseInt(parts[1].trim())
                ));
    }

    // 문자열을 List<Map<음식 이름, 개수>>로 변환하는 메서드
    private  List<Map<String, Integer>> convertStringToList(String orderString) {
        return List.of(convertOrderStringToMap(orderString));
    }

    private  String getMenuCategory(Map<String, Integer> orderItem) {
        String foodName = orderItem.keySet().iterator().next();
        try {
            Menuvalue menuValue = Menuvalue.valueOf(foodName);
            return menuValue.getCategory();
        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException("");
        }
    }


    private  List<Map<String, List<Map<String, Integer>>>> processOrders(List<Map<String, Integer>> orderList) {
        return orderList.stream()
                .collect(Collectors.groupingBy(
                        item -> getMenuCategory(item),
                        Collectors.toList() // 그룹화된 항목을 리스트로 저장
                ))
                .entrySet().stream()
                .map(entry -> Map.of(entry.getKey(), entry.getValue()))
                .collect(Collectors.toList());
    }


}
