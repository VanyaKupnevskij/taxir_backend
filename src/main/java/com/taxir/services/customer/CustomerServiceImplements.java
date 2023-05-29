package com.taxir.services.customer;

import com.taxir.entities.Customer;
import com.taxir.repositories.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CustomerServiceImplements implements CustomerService {

    @Autowired
    CustomerRepository customerRepository;

    @Override
    public Customer saveCustomer(Customer customer) {
        List<Customer> customerList = customerRepository.findAll();

        for(Customer customers : customerList) {
            if (customer.getEmail().equals(customers.getEmail())) {
                return null;
            }
        }

        customerRepository.save(customer);

        return customer;
    }

    @Override
    public Customer getCustomer(int id) {
        Customer customer = null;

        Optional<Customer> optionalCustomer = customerRepository.findById(id);
        if (optionalCustomer.isPresent()) {
            customer = optionalCustomer.get();
        }

        return customer;
    }

    @Override
    public List<Customer> getAllCustomers() {
        return customerRepository.findAll();
    }

    @Override
    public Customer getCustomerByEmailAndPassword(String email, String password) {

        return customerRepository.findCustomerByEmailAndPassword(email, password);
    }
}
