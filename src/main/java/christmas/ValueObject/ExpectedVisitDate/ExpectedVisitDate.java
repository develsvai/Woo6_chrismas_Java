package christmas.ValueObject.ExpectedVisitDate;

public class ExpectedVisitDate {
    private final Integer VisitDate;

    public ExpectedVisitDate( Integer date){
        this.VisitDate = date;
    }

    public Integer getVisitDate() {
        return VisitDate;
    }

}
