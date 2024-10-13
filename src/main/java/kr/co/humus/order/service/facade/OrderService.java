package kr.co.humus.order.service.facade;

import kr.co.humus.order.dto.response.FindOrderData;
import kr.co.humus.order.dto.response.FindOrderResponse;

public interface OrderService {

    Void getExternalOrder();

    FindOrderData getOrderInfo(Long orderId);

    FindOrderResponse getOrderList();
}
