package christmas.View.inputView;

import java.util.AbstractMap.SimpleEntry;
import java.util.List;

public interface InputView {
    public List<SimpleEntry<String, Integer>> input_Order_Menu();

    public Integer input_Expected_Visit_Date();

}
