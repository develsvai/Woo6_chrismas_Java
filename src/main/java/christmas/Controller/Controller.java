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
import christmas.View.OutputView.OutputView;


public class Controller {
    InputView inputView = new InputView();
    OutputView outputView = new OutputView();
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
        ptoMotion(foodChoice,visitDate);
        outputView.orderMenu(foodChoice.getAllFoodNamesWithQuantity());
        TotalPrice totalPrice = new TotalPrice(foodChoice);
        outputView.beforeDiscountTotalPrice(totalPrice.calculateTotalPrice());
        outputView.BonusEvent();
        outputView.profitList(totalDiscount);

    }

    private void ptoMotion( FoodChoice foodChoice, int visitDate){

        totalDiscount.setDdayDiscount(ddayDiscountService.calculateDiscount(visitDate));
        totalDiscount.setWeekdayDiscount(weekdayDiscountService.calculateTotalDiscount(foodChoice.getDessert(), visitDate));
        totalDiscount.setWeekendDiscount(weekendDiscountService.calculateTotalDiscount(foodChoice.getMain(),visitDate));
        totalDiscount.setSpecialDiscount(specialDiscountService.calculateTotalDiscount(visitDate));

    }


    public void InputDate () {

        this.visitDate = expectedVisitDateDto.ExpectedVisitDate(inputView.InputExpectedVisitDate()).getVisitDate();

    }


    public void InputMenu () {

        this.foodChoice = foodChoiceDto.foodListMap(inputView.InputMenu());

    }


}
