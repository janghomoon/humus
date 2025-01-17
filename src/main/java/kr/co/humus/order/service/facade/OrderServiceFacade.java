package kr.co.humus.order.service.facade;

import kr.co.humus.order.dto.request.ExternalOrderSaveRequest;
import kr.co.humus.order.dto.response.FindOrderData;
import kr.co.humus.order.dto.response.FindOrderResponse;

public interface OrderServiceFacade {

    void getExternalOrder();

    FindOrderData getOrderInfo(Long orderId);

    FindOrderResponse getOrderList();

    void postExternalOrder(ExternalOrderSaveRequest request);
}
