package christmas.Service.DdayDiscountService;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class DdayDiscountService {

    public int calculateDiscount( int date){
        isVaildEventDate(date);
        return ((date -1)*100)+1000;
    }


    private void isVaildEventDate(int date){
        if (date < 1 || date > 25) {
            throw new IllegalArgumentException("이벤트 날짜는 1부터 25까지의 값이어야 합니다.");
        }

    }


}
