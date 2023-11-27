package christmas.controller;

import christmas.Service.promotionService.PromotionService;
import christmas.View.inputView.InputView;
import christmas.View.outputView.OutputView;
import christmas.dto.InputOrderMenusDto;
import christmas.dto.InputVisitDateDto;
import christmas.dto.ModelToViewDto;
import javax.swing.text.View;


public class Controller {
    private final InputView inputView;
    private final OutputView outputView;
    private final PromotionService promotionService;

    public Controller(InputView inputView , OutputView outputView, PromotionService promotionService) {
        this.inputView = inputView;
        this.outputView = outputView;
        this.promotionService = promotionService;
    }

    public void chrisMas_Promotion_Service(){
       outputView.print_Welcome_Message();
       Input_Expected_Visit_Date();
       Input_Order_Menu();
       ModelToViewDto modelToViewDto= new ModelToViewDto(promotionService.getOrderMenus());
       outputView.print_order_Menu(modelToViewDto.transferModelToView());
    }


    public void Input_Expected_Visit_Date() {
        InputVisitDateDto inputVisitDateDto = new InputVisitDateDto(inputView.input_Expected_Visit_Date());
        promotionService.createVisitDateModel(inputVisitDateDto.takeVisitDate());
    }


    public void Input_Order_Menu () {
        InputOrderMenusDto inputOrderMenusDto =  new InputOrderMenusDto(inputView.input_Order_Menu());
        promotionService.createOrderMenusModel(inputOrderMenusDto.takeInputOrderMenus());
    }


}
