package kr.co.humus.order;

import static kr.co.humus.order.common.constant.OrderConstants.ORDER_URI;

import javax.validation.Valid;
import kr.co.humus.order.dto.request.ExternalOrderSaveRequest;
import kr.co.humus.order.dto.response.FindOrderData;
import kr.co.humus.order.dto.response.FindOrderResponse;
import kr.co.humus.order.service.impl.OrderServiceImpl;
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

    private final OrderServiceImpl orderService;

    @InitBinder
    private void initBinder(WebDataBinder webDataBinder) {
        webDataBinder.initDirectFieldAccess();
    }

    @GetMapping("/external-order")
    public ResponseEntity<Void> getExternalOrder()  {
        return ResponseEntity.ok(orderService.getExternalOrder());
    }

    @PostMapping("/external-order")
    public ResponseEntity<Void> postExternalOrder(@RequestBody @Valid ExternalOrderSaveRequest request)  {
        return ResponseEntity.ok(orderService.postExternalOrder(request));
    }



    @GetMapping("/{orderId}")
    public ResponseEntity<FindOrderData> getOrderInfo(@PathVariable("orderId") Long orderId) {
        return ResponseEntity.ok(orderService.getOrderInfo(orderId));
    }

    @GetMapping
    public ResponseEntity<FindOrderResponse> getOrderList()  {
        return ResponseEntity.ok(orderService.getOrderList());
    }






}
