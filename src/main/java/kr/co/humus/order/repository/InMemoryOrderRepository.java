package kr.co.humus.order.repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import kr.co.humus.order.entity.Order;
import org.springframework.stereotype.Component;

@Component
public class InMemoryOrderRepository {
    private List<Order> orders = new ArrayList<>();

    //저장
    public Order save(Order order) {
        orders.add(order);
        return order;
    }
    public void saveAll(List<Order> orders) {
        orders.addAll(orders);
    }
    //단일 조회
    public Optional<Order> findById(long orderId) {
        return orders.stream().filter(e -> e.getOrderId().equals(orderId)).findFirst();
        //orElseThrow
    }
    //전체 조회
    public List<Order> findAll() {
        return new ArrayList<>(orders);
    }

    public void setOrders(Order order) {
        orders.remove(order);
    }

}
