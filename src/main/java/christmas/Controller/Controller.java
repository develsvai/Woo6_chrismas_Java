package christmas.Controller;

import christmas.View.InputView.InputView;

public class Controller {
    InputView inputView = new InputView();

    public void InputDate () {
        inputView.InputExpectedVisitDate();
    }


    public void InputMenu () {
        inputView.InputMenu();

    }
}
