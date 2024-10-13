package kr.co.humus.order.dto.request;

import java.time.LocalDateTime;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
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
public class ExternalOrderSaveData {
    @NotNull(message = "주문 아이디는 필수 입니다.")
    private Long orderId;
    @NotEmpty(message = "고객 명은 필수 입니다.")
    private String customerName;
    @NotNull(message = "주문 날짜는 필수 입니다.")
    private LocalDateTime orderDate;
    @NotEmpty(message = "주문 상태는 필수 입니다.")
    private String orderStatus;

}
