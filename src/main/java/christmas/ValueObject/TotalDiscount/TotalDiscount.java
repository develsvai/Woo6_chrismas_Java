package christmas.ValueObject.TotalDiscount;

public class TotalDiscount {
    private int DdayDiscount;
    private int WeekdayDiscount;
    private int WeekendDiscount;
    private int specialDiscount;
    private int BonusEvent;


    public void setDdayDiscount(int ddayDiscount) {
        DdayDiscount = ddayDiscount;
    }
    public void setWeekdayDiscount(int weekdayDiscount) {
        WeekdayDiscount = weekdayDiscount;
    }
    public void setWeekendDiscount(int weekdayDiscount) {
        WeekendDiscount = weekdayDiscount;
    }

    public void setSpecialDiscount(int specialDiscount1) {
        specialDiscount =  specialDiscount1;
    }
    public void setBonusEvent(int bonusEvent) {
        BonusEvent = bonusEvent;
    }

    public int getSpecialDiscount() {
        return specialDiscount;
    }
    public int getDdayDiscount() {
        return DdayDiscount;
    }
    public int getWeekdayDiscount() {
        return WeekdayDiscount;
    }
    public int getWeekendDiscount() {
        return WeekendDiscount;
    }

    public int getBonusEvent() {
        return BonusEvent;
    }

    public int TotalDiscountPrice() {
        return DdayDiscount + specialDiscount + WeekendDiscount + WeekdayDiscount + 25000;
    }



}
