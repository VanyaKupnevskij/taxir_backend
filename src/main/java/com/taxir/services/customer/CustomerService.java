package com.taxir.services.customer;

import com.taxir.entities.Customer;

import java.util.List;

public interface CustomerService {

    Customer saveCustomer(Customer customer);

    Customer getCustomer(int id);

    List<Customer> getAllCustomers();

    Customer getCustomerByEmailAndPassword(String email, String password);
}
