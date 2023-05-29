package com.taxir.controllers;

import com.taxir.services.customer.CustomerService;
import com.taxir.services.trip.TripService;
import org.springframework.beans.factory.annotation.Autowired;

public abstract class ServiceController {

    @Autowired
    CustomerService customerService;

    @Autowired
    TripService tripService;
}
