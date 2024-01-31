package lk.ijse.pos.controller;

import lk.ijse.pos.dto.OrderDTO;
import lk.ijse.pos.entity.Orders;
import lk.ijse.pos.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "*")
public class OrderController {
    @Autowired
    private OrderService orderService;
    @GetMapping("/orders")
    public ResponseEntity<List<Orders>> getAllOrders(){
        return ResponseEntity.status(200).body(orderService.getAllOrders());
    }
    @GetMapping("/orders/{id}")
    public ResponseEntity<Orders> getOrderById(@PathVariable Long id) {
        return ResponseEntity.status(200).body(orderService.getOrderById(id));
    }

    @PostMapping("/orders")
    public ResponseEntity<Orders> createOrder(@RequestBody OrderDTO order) {
        return ResponseEntity.status(201).body(orderService.createOrder(order));
    }
}
