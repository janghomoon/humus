package kr.co.humus.order.common.enums;

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
}
