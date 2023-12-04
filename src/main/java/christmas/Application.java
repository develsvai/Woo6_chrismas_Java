package christmas;

import christmas.View.inputView.ConsoleInputView;
import christmas.View.inputView.InputView;
import christmas.View.outputView.ConsoleOutputView;
import christmas.View.outputView.OutputView;
import christmas.controller.Controller;

public class Application {

    public static void main(String[] args) {
        InputView inputView = new ConsoleInputView();
        OutputView outputView = new ConsoleOutputView();
        Controller controller = new Controller(inputView,outputView);
        controller.chrisMasPromotionPlanner();
    }

}
