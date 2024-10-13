package kr.co.humus.order.service.impl;

import kr.co.humus.order.dto.request.ExternalOrderSaveRequest;
import kr.co.humus.order.dto.response.FindOrderData;
import kr.co.humus.order.dto.response.FindOrderResponse;
import kr.co.humus.order.service.OrderService;
import kr.co.humus.order.service.facade.OrderServiceFacade;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j
public class OrderServiceFacadeImpl implements OrderServiceFacade {
    //facade 패턴 적용 및 개방 페쇄 원칙 사용 및 추후 확장 시  gateway 같은 역할로 사용
    private final OrderService orderService;

    @Override
    public void getExternalOrder() {
        orderService.getExternalOrder();
    }

    @Override
    public FindOrderData getOrderInfo(Long orderId) {
        return orderService.getOrderInfo(orderId);
    }

    @Override
    public FindOrderResponse getOrderList() {
        return orderService.getOrderList();
    }

    @Override
    public void postExternalOrder(ExternalOrderSaveRequest request) {
        orderService.postExternalOrder(request);
    }
}
