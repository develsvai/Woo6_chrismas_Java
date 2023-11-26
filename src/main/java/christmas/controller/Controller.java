package christmas.controller;

import christmas.View.inputView.InputView;
import christmas.View.outputView.OutputView;
import christmas.vo.FoodChoice.FoodChoice;
import christmas.View.inputView.ConsoleInputView;
import christmas.View.outputView.ConsoleOutputView;
import java.util.AbstractMap.SimpleEntry;
import java.util.List;
import java.util.Map;


public class Controller {
    private final InputView inputView;
    private final OutputView outputView;

    public Controller(InputView inputView , OutputView outputView) {
        this.inputView = inputView;
        this.outputView = outputView;
    }

    public void chrisMas_Promotion_Service(){
        outputView.print_Welcome_Message();

    }


    public void Input_Expected_Visit_Date() {
        inputView.input_Expected_Visit_Date();

    }


    public void Input_Order_Menu () {
        List<SimpleEntry<String, Integer>> orderMenu =  inputView.input_Order_Menu();

        for (Map.Entry<String, Integer> entry : orderMenu) {
            System.out.println("Key: " + entry.getKey() + ", Value: " + entry.getValue());
        }
    }


}
