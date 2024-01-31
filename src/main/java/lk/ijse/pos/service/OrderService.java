package lk.ijse.pos.service;

import lk.ijse.pos.dto.OrderDTO;
import lk.ijse.pos.entity.Orders;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface OrderService {
    List<Orders> getAllOrders();
    Orders getOrderById(Long id);
    Orders createOrder(OrderDTO orderDTO);
}
