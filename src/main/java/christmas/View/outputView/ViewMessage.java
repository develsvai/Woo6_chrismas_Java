package christmas.View.outputView;

public enum ViewMessage {

    WELCOME_MESSAGE("안녕하세요 우테코 식당 12월 이벤트 플래너 입니다."),
    PREVIEW_BENEFIT_MESSAGE("12월 %d일에 우테코 식당에서 받을 이벤트 혜택 미리보기!"),
    ORDER_MENU_MESSAGE("<주문 메뉴>"),
    BEFORE_DISCOUNT_TOTAL_PRICE_MESSAGE("<할인 전 총주문 금액>"),
    GIVEAWAY_MENU_MESSAGE("<증정 메뉴>"),
    BENEFITS_MESSAGE("<혜택 내역>"),
    TOTAL_BENEFIT_PRICE_MESSAGE("<총혜택 금액>"),
    AFTER_DISCOUNT_PAYMENT_AMOUNT_MESSAGE("<할인 후 예상 결제 금액>"),
    DECEMBER_EVENT_BADGE_MESSAGE("<12월 이벤트 배지>");

    private final String message;

    ViewMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
