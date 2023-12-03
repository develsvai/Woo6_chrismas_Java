package christmas.Service;

import christmas.promotionEnum.EventPolicyEnum;
import java.util.EnumMap;

public class TotalBenefitAmount {
    private final EnumMap<EventPolicyEnum, Integer> benefits;

    public TotalBenefitAmount(EnumMap<EventPolicyEnum, Integer> benefits){
            this.benefits = benefits;
    }

    public Integer totalBenefitAmount(){
        return benefits.values().stream().mapToInt(Integer::intValue).sum();
    }
}
