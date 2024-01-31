package lk.ijse.pos.service.impl;

import lk.ijse.pos.dto.CustomerDTO;
import lk.ijse.pos.entity.Customer;
import lk.ijse.pos.repository.CustomerRepository;
import lk.ijse.pos.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class CustomerServiceImpl implements CustomerService {
    @Autowired
    private CustomerRepository customerRepository;
    @Override
    public List<Customer> getAllCustomers() {
        return customerRepository.findAll();
    }

    @Override
    public Customer getCustomerById(Long id) {
        return customerRepository.findById(id).orElse(null);
    }

    @Override
    public Customer saveCustomer(CustomerDTO customerDTO) {
        Customer customer=customerRepository.findById(customerDTO.getId()).orElse(null);

        if (customer==null){
            Customer newCus=new Customer();
            newCus.setCusId(customerDTO.getId());
            newCus.setName(customerDTO.getName());
            newCus.setAddress(customerDTO.getAddress());
            newCus.setSalary(customerDTO.getSalary());
            return customerRepository.save(newCus);
        }else {
            return null;
        }
    }

    @Override
    public Customer updateCustomer(CustomerDTO customerDTO) {
        Customer customer=customerRepository.findById(customerDTO.getId()).orElse(null);

        if (customer!=null) {
            customer.setName(customerDTO.getName());
            customer.setAddress(customerDTO.getAddress());
            customer.setSalary(customerDTO.getSalary());
            return customerRepository.save(customer);
        }else {
            return null;
        }
    }

    @Override
    public Customer deleteCustomer(Long id) {
        Customer customer=customerRepository.findById(id).orElse(null);
        if (customer!=null){
            customerRepository.delete(customer);
            return customer;
        }else {
            return null;
        }
    }
}
