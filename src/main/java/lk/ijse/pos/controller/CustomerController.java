package lk.ijse.pos.controller;

import lk.ijse.pos.dto.CustomerDTO;
import lk.ijse.pos.entity.Customer;
import lk.ijse.pos.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "*")
public class CustomerController {
    @Autowired
    private CustomerService customerService;

    @GetMapping("/customers")
    public ResponseEntity<List<Customer>> getAllCustomers(){
        return ResponseEntity.status(200).body(customerService.getAllCustomers());
    }

    @GetMapping("/customers/{id}")
    public ResponseEntity<?> getCustomerById(@PathVariable Long id){
        try {
            return ResponseEntity.status(200).body(customerService.getCustomerById(id));
        }catch (Exception e){
            return ResponseEntity.status(500).body(e.getMessage());
        }
    }
    @PostMapping("/customers")
    public ResponseEntity<?> saveCustomer(@RequestBody Customer customer){
        try {
            return ResponseEntity.status(201).body(customerService.saveCustomer(new CustomerDTO(customer.getCusId(),customer.getName(),customer.getAddress(),customer.getSalary())));

        }catch (Exception e){
            return ResponseEntity.status(500).body(e.getMessage());
        }
    }

    @PutMapping("/customers/{id}")
    public ResponseEntity<?> updateCustomer(@RequestBody Customer customer){
        try {
            return ResponseEntity.status(200).body(customerService.updateCustomer(new CustomerDTO(customer.getCusId(),customer.getName(),customer.getAddress(),customer.getSalary())));
        }catch (Exception e){
            return ResponseEntity.status(500).body(e.getMessage());
        }
    }

    @DeleteMapping("/customers/{id}")
    public ResponseEntity<?> deleteCustomer(@PathVariable Long id){
        try {
            return ResponseEntity.status(200).body(customerService.deleteCustomer(id));
        }catch (Exception e){
            return ResponseEntity.status(500).body(e.getMessage());
        }
    }
}
