package christmas.vo;

import christmas.promotionEnum.EventPolicyEnum;
import java.util.EnumMap;

public class Benefits {
    private EnumMap<EventPolicyEnum, Integer> benefits;

    public Benefits( EnumMap<EventPolicyEnum, Integer> benefits ) {
        this.benefits = benefits;
    }

    public EnumMap<EventPolicyEnum, Integer> getBenefits() {
        return benefits;
    }
}
