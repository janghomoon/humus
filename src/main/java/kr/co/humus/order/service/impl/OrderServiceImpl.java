package kr.co.humus.order.service.impl;

import kr.co.humus.order.dto.response.FindOrderData;
import kr.co.humus.order.dto.response.FindOrderResponse;
import kr.co.humus.order.service.facade.OrderService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class OrderServiceImpl implements OrderService {

    @Override
    public Void getExternalOrder() {
        return null;
    }

    @Override
    public FindOrderData getOrderInfo(Long orderId) {
        return null;
    }

    @Override
    public FindOrderResponse getOrderList() {
        return null;
    }
}
