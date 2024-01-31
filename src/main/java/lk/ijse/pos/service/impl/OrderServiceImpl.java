package lk.ijse.pos.service.impl;

import lk.ijse.pos.dto.OrderDTO;
import lk.ijse.pos.entity.Customer;
import lk.ijse.pos.entity.Item;
import lk.ijse.pos.entity.Orders;
import lk.ijse.pos.repository.CustomerRepository;
import lk.ijse.pos.repository.ItemRepository;
import lk.ijse.pos.repository.OrderRepository;
import lk.ijse.pos.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
@Service
public class OrderServiceImpl implements OrderService {

    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private ItemRepository itemRepository;

    @Autowired
    private CustomerRepository customerRepository;
    @Override
    public List<Orders> getAllOrders() {
        return orderRepository.findAll();
    }

    @Override
    public Orders getOrderById(Long id) {
        return orderRepository.findById(id).orElse(null);
    }

    @Override
    public Orders createOrder(OrderDTO orderDTO) {
        Orders orders = new Orders();
        List<Long> itemIds = orderDTO.getItems();
        Set<Item>itemSet=new HashSet<>();

        orders.setTotal(0.0);
        for (Long itemId : itemIds) {
            Item item = itemRepository.findById(itemId).orElse(null);
            Customer customer = customerRepository.findById(orderDTO.getCustomerId()).orElse(null);
            if(item!=null && item.getQtyOnHand()>0 && customer!=null){
                itemSet.add(item);
                orders.setTotal(orders.getTotal()+item.getUnitPrice());
                orders.setCustomer(customer);
            }
        }
        orders.setDate(LocalDateTime.now());
        orders.setItems(itemSet);

        return orderRepository.save(orders);
    }
}
