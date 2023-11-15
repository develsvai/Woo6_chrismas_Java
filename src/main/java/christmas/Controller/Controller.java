package christmas.Controller;

import christmas.Dto.ExpectedVisitDateDto;
import christmas.Dto.FoodChoiceDto;
import christmas.ValueObject.FoodChoice.FoodChoice;
import christmas.View.InputView.InputView;
import java.util.List;
import java.util.Map;

public class Controller {
    InputView inputView = new InputView();
    ExpectedVisitDateDto expectedVisitDateDto = new ExpectedVisitDateDto();
    FoodChoiceDto foodChoiceDto = new FoodChoiceDto();

    public void InputDate () {
        System.out.println(expectedVisitDateDto.ExpectedVisitDate(inputView.InputExpectedVisitDate()).getVisitDate());

    }


    public void InputMenu () {
        FoodChoice processedOrder = foodChoiceDto.foodListMap(inputView.InputMenu());

        processedOrder.print().forEach(categoryMap -> {
            categoryMap.forEach((category, menuList) -> {
                System.out.println(category + ":");
                menuList.forEach(menuMap ->
                        menuMap.forEach((menu, quantity) ->
                                System.out.println("  " + menu + " - " + quantity + "개")));
            });
        });
    }
}
