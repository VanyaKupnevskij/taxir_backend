package com.taxir.repositories;

import com.taxir.entities.Customer;
import com.taxir.entities.Trip;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CustomerRepository extends JpaRepository<Customer, Integer> {

    Customer findCustomerByEmailAndPassword(String email, String password);
}
