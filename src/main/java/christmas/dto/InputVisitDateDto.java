package christmas.dto;

public class InputVisitDateDto {
    private Integer VisitDate;
    public InputVisitDateDto( Integer Date) {
        this.VisitDate = Date;
    }

    public Integer takeVisitDate(){
        return VisitDate;
    }
}
