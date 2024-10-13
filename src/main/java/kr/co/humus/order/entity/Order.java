package kr.co.humus.order.entity;

import java.time.LocalDateTime;
import kr.co.humus.order.common.enums.OrderStatus;
import kr.co.humus.order.dto.response.FindOrderData;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Getter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
@Builder
@ToString
public class Order {
    private Long orderId;
    private String customerName;
    private LocalDateTime orderDate;
    private OrderStatus orderStatus;



    public FindOrderData toFindOrderData() {
        return FindOrderData.builder()
                .orderId(this.orderId)
                .customerName(this.customerName)
                .orderDate(this.orderDate)
                .orderStatus(orderStatus.name())
                .build();
    }

}
