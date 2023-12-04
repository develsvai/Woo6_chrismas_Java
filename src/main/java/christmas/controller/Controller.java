package christmas.controller;

import christmas.Model.OrderMenusModel;
import christmas.Model.PromotionDatePolicy;
import christmas.Model.VisitDateModel;
import christmas.Service.AfterDiscountPaymentAmount;
import christmas.Service.TotalBenefitAmount;
import christmas.Service.Constructor;
import christmas.Service.promotionService.DDayDiscountService;
import christmas.Service.promotionService.GiveAwayEventService;
import christmas.Service.promotionService.SpecialDiscountService;
import christmas.Service.promotionService.WeekDayDiscountService;
import christmas.Service.promotionService.WeekendDiscountService;
import christmas.View.inputView.InputView;
import christmas.View.outputView.OutputView;
import christmas.dto.InputOrderMenusDto;
import christmas.dto.InputVisitDateDto;
import christmas.dto.ModelToViewDto;
import christmas.promotionEnum.EventPolicyEnum;
import java.util.AbstractMap.SimpleEntry;
import java.util.EnumMap;

public class Controller {
    private final InputView inputView;
    private final OutputView outputView;
    private OrderMenusModel orderMenus;
    private VisitDateModel visitDate;
    private PromotionDatePolicy policy;
    private final EnumMap<EventPolicyEnum, Integer> benefits;

    public Controller(InputView inputView , OutputView outputView) {
        this.inputView = inputView;
        this.outputView = outputView;
        benefits = new EnumMap<>(EventPolicyEnum.class);
    }

    public void chrisMasPromotionPlanner() {
        outputView.print_Welcome_Message();

        //모델 생성
        createModel();

        outputView.print_PreView_Benefit_Message(visitDate.takeVisitDate());

        //주문 메뉴
        ModelToViewDto modelToViewDto = new ModelToViewDto(orderMenus);
        outputView.print_order_Menu(modelToViewDto.TransferModelToViewOrderMenu());

        //할인전 총 주문 금액
        outputView.print_before_Discount_Total_Price(modelToViewDto.TransferModelToViewTotalAmount());

        //증정 메뉴
        giveAwayService();

        //할인정책 적용
        applyDiscountService();

        //혜택 내역
        outputView.benefits_history(benefits);

        //총 혜택 금액
        TotalBenefitAmount totalBenefitAmount = new TotalBenefitAmount(benefits);
        outputView.print_Total_Benefit_Price(totalBenefitAmount.totalBenefitAmount());

        //할인후 예상 결제 금액
        AfterDiscountPaymentAmount afterDiscountPaymentAmount = new AfterDiscountPaymentAmount(orderMenus, benefits);
        outputView.print_After_Discount_Payment_Amount(afterDiscountPaymentAmount.getAfterDiscountPaymentAmount());

        //12월 이벤트 배지
        outputView.print_December_Event_Badge(totalBenefitAmount.totalBenefitAmount());

    }

    private void createModel(){
        InputVisitDateDto inputVisitDateDto = Input_Expected_Visit_Date();
        InputOrderMenusDto inputOrderMenusDto = Input_Order_Menu();

        Constructor constructor = new Constructor();
        visitDate = constructor.createVisitDateModel(inputVisitDateDto.takeVisitDate());
        orderMenus = constructor.createOrderMenusModel(inputOrderMenusDto.takeInputOrderMenus());
        policy = constructor.createpromotionDatePolicy(visitDate);
    }

    private void giveAwayService(){
        //증정 메뉴
        GiveAwayEventService giveAwayEventService = new GiveAwayEventService();
        SimpleEntry<EventPolicyEnum, Integer> giveAayResult = giveAwayEventService.discountService(orderMenus, visitDate, policy);
        outputView.print_giveAway_Menu(giveAayResult);
        benefits.put(giveAayResult.getKey(),giveAayResult.getValue());
    }


    private void applyDiscountService(){
        //디데이 할인
        DDayDiscountService dDayDiscountService = new DDayDiscountService();
        SimpleEntry<EventPolicyEnum, Integer> dDayResult = dDayDiscountService.discountService(orderMenus, visitDate, policy);
        benefits.put(dDayResult.getKey(), dDayResult.getValue());

        //평일 할인
        WeekDayDiscountService weekDayDiscountService = new WeekDayDiscountService();
        SimpleEntry<EventPolicyEnum, Integer> weekDayResult = weekDayDiscountService.discountService(orderMenus,visitDate,policy);
        benefits.put(weekDayResult.getKey(),weekDayResult.getValue());

        //주말 할인
        WeekendDiscountService weekendDiscountService = new WeekendDiscountService();
        SimpleEntry<EventPolicyEnum, Integer> weekendResult = weekendDiscountService.discountService(orderMenus, visitDate, policy);
        benefits.put(weekendResult.getKey(), weekendResult.getValue());

        //특별 할인
        SpecialDiscountService specialDiscountService = new SpecialDiscountService();
        SimpleEntry<EventPolicyEnum, Integer> specialResult = specialDiscountService.discountService(orderMenus, visitDate,policy);
        benefits.put(specialResult.getKey(), specialResult.getValue());
    }


    private InputVisitDateDto Input_Expected_Visit_Date() {
         return new InputVisitDateDto(inputView.input_Expected_Visit_Date());
    }

    private InputOrderMenusDto Input_Order_Menu () {
        return new InputOrderMenusDto(inputView.input_Order_Menu());
    }

}
