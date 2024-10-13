package kr.co.humus.order.dto.response;

import java.time.LocalDateTime;
import kr.co.humus.order.common.enums.OrderStatus;
import kr.co.humus.order.entity.Order;
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
@ToString
@Builder
public class ExternalOrderData {
    private Long orderId;
    private String customerName;
    private LocalDateTime orderDate;
    private String orderStatus;


    public Order toEntity() {
        return Order.builder()
                .orderId(this.orderId)
                .customerName(this.customerName)
                .orderDate(this.orderDate)
                .orderStatus(OrderStatus.fromName(this.orderStatus))
                .build();
    }
}
