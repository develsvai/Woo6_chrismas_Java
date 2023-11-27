package christmas.PromotionEnum;

public enum EventPolicyEnum {

    DDAY_DISCOUNT("크리스마스 디데이 할인",1000),

    WEEKDAY_DISCOUNT("평일 할인",2023),

    WEEKEND_DISCOUNT("주말 할인",2023),

    SPECIAL_DISCOUNT("특별 할인",1000),

    GIVEAWAY_DISCOUNT("증정 이벤트",25000);


    private final String description;
    private final int DiscountAmount;


    EventPolicyEnum(String description, int discountAmount) {
        this.description = description;
        this.DiscountAmount = discountAmount;
    }

    public String getDescription() {
        return description;
    }

    public int getDiscountAmount() {
        return DiscountAmount;
    }
}

