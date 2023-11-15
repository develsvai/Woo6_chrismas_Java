package christmas.Controller;

import christmas.Dto.ExpectedVisitDateDto;
import christmas.Dto.FoodChoiceDto;
import christmas.Service.DdayDiscountService.DdayDiscountService;
import christmas.Service.SpecialDiscountService.SpecialDiscountService;
import christmas.Service.WeekdayDiscountService.WeekdayDiscountService;
import christmas.Service.WeekendDiscountService.WeekendDiscountService;
import christmas.ValueObject.FoodChoice.FoodChoice;
import christmas.Service.TotalPriceService.TotalPrice;
import christmas.ValueObject.TotalDiscount.TotalDiscount;
import christmas.View.InputView.InputView;


public class Controller {
    InputView inputView = new InputView();
    ExpectedVisitDateDto expectedVisitDateDto = new ExpectedVisitDateDto();
    FoodChoiceDto foodChoiceDto = new FoodChoiceDto();
    TotalDiscount totalDiscount = new TotalDiscount();
    DdayDiscountService ddayDiscountService = new DdayDiscountService();
    WeekdayDiscountService weekdayDiscountService  = new WeekdayDiscountService();

    WeekendDiscountService weekendDiscountService = new WeekendDiscountService();

    SpecialDiscountService specialDiscountService = new SpecialDiscountService();

    private int visitDate ;
    private FoodChoice foodChoice;

    public void EventPlannerStart() {
        InputDate();
        InputMenu();

    }

    private void eventDiscount( FoodChoice foodChoice, int visitDate){
        totalDiscount.setDdayDiscount(ddayDiscountService.calculateDiscount(visitDate));
        totalDiscount.setWeekdayDiscount(weekdayDiscountService.calculateTotalDiscount(foodChoice.getDessert(), visitDate));
        totalDiscount.setWeekendDiscount(weekendDiscountService.calculateTotalDiscount(foodChoice.getMain(),visitDate));
        totalDiscount.setSpecialDiscount(specialDiscountService.calculateTotalDiscount(visitDate));
    }


    public void InputDate () {
        Integer VisitDate = expectedVisitDateDto.ExpectedVisitDate(inputView.InputExpectedVisitDate()).getVisitDate();
        this.visitDate = VisitDate;

    }


    public void InputMenu () {
        this.foodChoice = foodChoiceDto.foodListMap(inputView.InputMenu());

        foodChoice.print().forEach(categoryMap -> {
            categoryMap.forEach((category, menuList) -> {
                System.out.println(category + ":");
                menuList.forEach(menuMap ->
                        menuMap.forEach((menu, quantity) ->
                                System.out.println("  " + menu + " - " + quantity + "개")));
            });
        });

        TotalPrice totalPrice = new TotalPrice(foodChoice);

        System.out.println( "할인전 총 가격 " + totalPrice.calculateTotalPrice());

    }




}
