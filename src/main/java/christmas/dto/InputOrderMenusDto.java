package christmas.dto;

import java.util.AbstractMap.SimpleEntry;
import java.util.List;

public class InputOrderMenusDto {
    private List<SimpleEntry< String, Integer>> OrderMenu;

    public InputOrderMenusDto(List<SimpleEntry< String, Integer>> order){
        this.OrderMenu = order;
    }

    public  List<SimpleEntry< String, Integer>> takeInputOrderMenus(){
        return OrderMenu;
    }

}
