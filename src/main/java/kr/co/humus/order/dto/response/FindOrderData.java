package kr.co.humus.order.dto.response;

import java.time.LocalDateTime;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@ToString
public class FindOrderData {

    private Long orderId;
    private String customerName;
    private LocalDateTime orderDate;
    private String orderStatus;

}
