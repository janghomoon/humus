package kr.co.humus.order.dto.request;

import java.util.List;
import javax.validation.constraints.Min;
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
public class ExternalOrderSaveRequest {
    @NotNull(message = "외부 연동 주문 데이터는 필수 입니다.")
    @Min(value = 1, message = "외부 연동 주문 데이터는 적오도 한개 이상의 데이터가 필요합니다.")
    private List<ExternalOrderSaveData> data;
}
