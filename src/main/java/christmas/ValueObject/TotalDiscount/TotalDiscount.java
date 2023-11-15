package christmas.ValueObject.TotalDiscount;

public class TotalDiscount {
    private int DdayDiscount;
    private int WeekdayDiscount;
    private int specialDiscount;
    private int BonusEvent;


    public void setDdayDiscount(int ddayDiscount) {
        DdayDiscount = ddayDiscount;
    }

    public void setWeekdayDiscount(int weekdayDiscount) {
        WeekdayDiscount = weekdayDiscount;
    }

    public void setSpecialDiscount(int specialDiscount) {
        this.specialDiscount = specialDiscount;
    }

    public void setBonusEvent(int bonusEvent) {
        BonusEvent = bonusEvent;
    }


}
