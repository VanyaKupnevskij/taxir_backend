package com.taxir.entities;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@Entity
@Table(name = "customers")
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "customer_id")
    private int customerId;

    @Column(name = "email")
    private String email;

    @Column(name = "password")
    private String password;

    @Column(name = "role")
    private String role;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    @JsonManagedReference
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "customer")
    private List<Trip> tripList;

    public Customer(int customerId, String email, String password, String role, String firstName, String lastName) {
        this.customerId = customerId;
        this.email = email;
        this.password = password;
        this.role = role;
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public Customer() {

    }

    public void addTrip(Trip trip){
        if (tripList == null) {
            tripList = new ArrayList<>();
        }
        tripList.add(trip);
        trip.setCustomer(this);
    }
}
