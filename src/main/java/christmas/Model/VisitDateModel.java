package christmas.Model;

import christmas.dto.InputVisitDateDto;
import java.time.LocalDate;

public class VisitDateModel {
    private final Integer visitDate;

    public VisitDateModel(Integer date) {
        // 년도는 2023으로 고정 
        this.visitDate = date;
    }

    public LocalDate takeVisitDate() {
        return LocalDate.of(2023, 12, visitDate);
    }
}