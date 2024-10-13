package kr.co.humus.order.service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;
import kr.co.humus.order.client.OrderClient;
import kr.co.humus.order.dto.request.ExternalOrderSaveRequest;
import kr.co.humus.order.dto.response.ExternalOrderData;
import kr.co.humus.order.dto.response.ExternalOrderResponse;
import kr.co.humus.order.dto.response.FindOrderData;
import kr.co.humus.order.dto.response.FindOrderResponse;
import kr.co.humus.order.entity.Order;
import kr.co.humus.order.repository.InMemoryOrderRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

@Service
@RequiredArgsConstructor
@Slf4j
public class OrderService {

    //todo Transactional 처리 해야하지만 memory 테스트 용으로 패스
    private final InMemoryOrderRepository orderRepository;
    private final OrderClient orderClient;


    public FindOrderData getOrderInfo(Long orderId) {
        Optional<Order> optional = orderRepository.findById(orderId);
        return optional.map(Order::toFindOrderData).orElse(null);
    }

    public FindOrderResponse getOrderList() {
        List<Order> list = orderRepository.findAll();
        if (CollectionUtils.isEmpty(list)) {
            return null;
        }
        return FindOrderResponse.builder()
                .data(list.stream().map(Order::toFindOrderData).toList())
                .build();
    }

    public void getExternalOrder() {
        ExternalOrderResponse externalOrderResponse = orderClient.getExternalOrderList();
        if (Objects.isNull(externalOrderResponse)) return;
        orderRepository.saveAll(externalOrderResponse.getData().stream().map(ExternalOrderData::toEntity).toList());
    }


    public void postExternalOrder(ExternalOrderSaveRequest request) {
        orderClient.sendExternalOrderList(request);
    }
}
