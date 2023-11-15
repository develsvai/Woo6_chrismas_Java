package christmas.Controller;

import christmas.Dto.ExpectedVisitDateDto;
import christmas.Dto.FoodChoiceDto;
import christmas.Service.DdayDiscountService.DdayDiscountService;
import christmas.ValueObject.FoodChoice.FoodChoice;
import christmas.Service.TotalPriceService.TotalPrice;
import christmas.View.InputView.InputView;


public class Controller {
    InputView inputView = new InputView();
    ExpectedVisitDateDto expectedVisitDateDto = new ExpectedVisitDateDto();
    FoodChoiceDto foodChoiceDto = new FoodChoiceDto();
    DdayDiscountService ddayDiscountService = new DdayDiscountService();




    public void InputDate () {
        Integer VisitDate = expectedVisitDateDto.ExpectedVisitDate(inputView.InputExpectedVisitDate()).getVisitDate();

        System.out.println(" 크리스 마스 할인" + ddayDiscountService.calculateDiscount(VisitDate));

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

        TotalPrice totalPrice = new TotalPrice(processedOrder);

        System.out.println( "할인전 총 가격 " + totalPrice.calculateTotalPrice());

    }




}
