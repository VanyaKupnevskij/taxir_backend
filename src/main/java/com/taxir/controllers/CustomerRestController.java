package com.taxir.controllers;

import com.taxir.entities.Customer;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
@CrossOrigin
public class CustomerRestController extends ServiceController {

    @PostMapping("/customer/create")
    public Customer createCustomer(@RequestBody Customer customer) {
        customerService.saveCustomer(customer);

        return customer;
    }

    @PostMapping("/customer/login")
    public Customer loginCustomer(@RequestBody Customer customer) {

        return customerService.getCustomerByEmailAndPassword(customer.getEmail(), customer.getPassword());
    }

    @GetMapping("/customer/{id}")
    public Customer getCustomer(@PathVariable int id) {

        return customerService.getCustomer(id);
    }

    @GetMapping("/customer/")
    public List<Customer> getAllCustomers() {

        return customerService.getAllCustomers();
    }
}
