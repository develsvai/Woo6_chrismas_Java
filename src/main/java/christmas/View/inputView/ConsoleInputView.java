package christmas.View.inputView;


import camp.nextstep.edu.missionutils.Console;
import christmas.View.inputView.Parser.OrderParser;
import christmas.View.inputView.Parser.VisitDateParser;
import java.util.AbstractMap.SimpleEntry;
import java.util.List;

public class ConsoleInputView implements InputView{

    private static final String ExpectedDate = "12월 중 식당 예상 방문 날짜는 언제인가요? (숫자만 입력해 주세요!)";
    private static final String InputMenuAndCount = "주문하실 메뉴를 메뉴와 개수를 알려 주세요. (e.g. 해산물파스타-2,레드와인-1,초코케이크-1)";

    @Override
    public List<SimpleEntry<String, Integer>> input_Order_Menu() {
        System.out.println(InputMenuAndCount);
        return OrderParser.parseMenus(Console.readLine());
    }

    @Override
    public Integer input_Expected_Visit_Date(){
        System.out.println(ExpectedDate);
        return VisitDateParser.ParseVisitDate(Console.readLine());

    }

    private void isInputExpectedVisitDateNull(String Date){
        if(Date.isEmpty()) {
            throw new IllegalArgumentException("");
        }
    }
}
