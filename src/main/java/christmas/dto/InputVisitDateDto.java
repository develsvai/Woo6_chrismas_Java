package christmas.dto;

public class InputVisitDateDto {
    private final Integer VisitDate;
    public InputVisitDateDto( Integer Date) {
        this.VisitDate = Date;
    }

    public int takeVisitDate(){
        return VisitDate;
    }
}
