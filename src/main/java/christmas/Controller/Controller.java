package christmas.Controller;

import christmas.Dto.ExpectedVisitDateDto;
import christmas.Dto.FoodChoiceDto;
import christmas.View.InputView.InputView;

public class Controller {
    InputView inputView = new InputView();
    ExpectedVisitDateDto expectedVisitDateDto = new ExpectedVisitDateDto();
    FoodChoiceDto foodChoiceDto = new FoodChoiceDto();

    public void InputDate () {
        System.out.println(expectedVisitDateDto.ExpectedVisitDate(inputView.InputExpectedVisitDate()).getVisitDate());

    }


    public void InputMenu () {
        inputView.InputMenu();

    }
}
