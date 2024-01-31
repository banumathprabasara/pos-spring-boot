package lk.ijse.pos.service;

import lk.ijse.pos.dto.CustomerDTO;
import lk.ijse.pos.entity.Customer;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface CustomerService {
    List<Customer> getAllCustomers();
    Customer getCustomerById(Long id);
    Customer saveCustomer(CustomerDTO customerDTO);
    Customer updateCustomer(CustomerDTO customerDTO);
    Customer deleteCustomer(Long id);
}
