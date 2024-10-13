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
    @NotNull
    private Long orderId;
    @NotEmpty
    private String customerName;
    @NotNull
    private LocalDateTime orderDate;
    @NotEmpty
    private String orderStatus;

}
