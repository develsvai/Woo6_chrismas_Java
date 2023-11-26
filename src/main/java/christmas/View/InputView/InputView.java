package christmas.View.InputView;


import camp.nextstep.edu.missionutils.Console;

public class InputView {
    private static final String Hi_Comment = "안녕하세요! 우테코 식당 12월 이벤트 플래너입니다.";
    private static final String ExpectedDate = "12월 중 식당 예상 방문 날짜는 언제인가요? (숫자만 입력해 주세요!)";

    private static final String InputMenuAndCount = "주문하실 메뉴를 메뉴와 개수를 알려 주세요. (e.g. 해산물파스타-2,레드와인-1,초코케이크-1)";
    private static final String PreviewProfit = "12월 3일에 우테코 식당에서 받을 이벤트 혜택 미리 보기!";


    public String InputMenu() {
        System.out.println(InputMenuAndCount);
        String menu = Console.readLine();
        System.out.println(PreviewProfit);
        isInputMenuNull(menu);
        return  menu;
    }

    private void isInputMenuNull(String menu){
        if(menu.isEmpty()) {
            throw new IllegalArgumentException("");
        }
    }


    public String InputExpectedVisitDate(){
        System.out.println(Hi_Comment);
        System.out.println(ExpectedDate);
        String Data = Console.readLine();
        isInputExpectedVisitDateNull(Data);
        return  Data;
    }

    private void isInputExpectedVisitDateNull(String Date){
        if(Date.isEmpty()) {
            throw new IllegalArgumentException("");
        }
    }
}
