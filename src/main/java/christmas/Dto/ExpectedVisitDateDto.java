package christmas.Dto;

import christmas.Util.TypeConverter;
import christmas.ValueObject.ExpectedVisitDate.ExpectedVisitDate;

public class ExpectedVisitDateDto {

    TypeConverter typeConverter = new TypeConverter();



    public ExpectedVisitDate ExpectedVisitDate(String Date) {
        Integer ExpectedDate = typeConverter.ConvertStringToInteger(Date);
        isValidVisitDateNull(ExpectedDate);
        return new ExpectedVisitDate(ExpectedDate);
    }

    public void isValidVisitDateNull(Integer date) {
        if (date == null) {
            throw new IllegalArgumentException("");
        }
    }

    /**
     * 그외 예외처리 들은 벨류 오브젝트 에서 처리
     */


}
