package kr.co.humus.order;

import static kr.co.humus.order.common.constant.OrderConstants.ORDER_URI;

import javax.validation.Valid;
import kr.co.humus.common.exception.HumusException;
import kr.co.humus.order.dto.request.ExternalOrderSaveRequest;
import kr.co.humus.order.dto.response.FindOrderData;
import kr.co.humus.order.dto.response.FindOrderResponse;
import kr.co.humus.order.service.impl.OrderServiceFacadeImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping(value = ORDER_URI, produces = MediaType.APPLICATION_JSON_VALUE)
public class OrderController {

    private final OrderServiceFacadeImpl orderServiceFacade;

    @InitBinder
    private void initBinder(WebDataBinder webDataBinder) {
        webDataBinder.initDirectFieldAccess();
    }

    @GetMapping("/external-order")
    public ResponseEntity<Void> getExternalOrder() throws HumusException {
        orderServiceFacade.getExternalOrder();
        return ResponseEntity.ok().build();
    }

    @PostMapping("/external-order")
    public ResponseEntity<Void> postExternalOrder(@RequestBody @Valid ExternalOrderSaveRequest request) throws HumusException {
        orderServiceFacade.postExternalOrder(request);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/{orderId}")
    public ResponseEntity<FindOrderData> getOrderInfo(@PathVariable("orderId") Long orderId) throws HumusException {
        return ResponseEntity.ok(orderServiceFacade.getOrderInfo(orderId));
    }

    @GetMapping
    public ResponseEntity<FindOrderResponse> getOrderList() throws HumusException {
        return ResponseEntity.ok(orderServiceFacade.getOrderList());
    }






}
