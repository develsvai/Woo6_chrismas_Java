package christmas.Model;

import java.time.LocalDate;

public class VisitDateModel {
    private final Integer visitDate;
    private static final String ERROR_MESSAGE_OUT_OF_RANGE = "[ERROR] 1에서 31 사이의 숫자여야 합니다";

    public VisitDateModel(int date) {
        checkInRange(date);
        this.visitDate = date;
    }


    private void checkInRange(Integer value) {
        if (value < 1 || value > 31) {
            throw new IllegalArgumentException(ERROR_MESSAGE_OUT_OF_RANGE);
        }
    }

    public LocalDate takeVisitDate() {

        return LocalDate.of(2023, 12, visitDate);
    }


}