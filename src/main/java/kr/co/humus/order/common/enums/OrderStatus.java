package kr.co.humus.order.common.enums;

import java.util.Arrays;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum OrderStatus {

    PROCESSING("P", "주문 접수중")
    , SHIPPED("S", "배송 진행 중")
    , COMPLETED("C", "배송 완료")
    ;
    private final String code;
    private final String desc;

    public static OrderStatus fromCode(String code) {
        return Arrays.stream(values())
                .filter(f -> f.getCode().equalsIgnoreCase(code))
                .findFirst()
                .orElse(null);
    }
    public static OrderStatus fromName(String name) {
        return Arrays.stream(values())
                .filter(f -> f.name().equalsIgnoreCase(name))
                .findFirst()
                .orElse(null);
    }

}
