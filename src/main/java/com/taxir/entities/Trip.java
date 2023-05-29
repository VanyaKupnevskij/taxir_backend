package com.taxir.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@Entity
@Table(name = "trips")
@JsonIgnoreProperties({"hibernateLazyInitializer"})
public class Trip {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "trip_id")
    private int tripId;

    @Column(name = "trip_from")
    private String tripFrom;

    @Column(name = "trip_to")
    private String tripTo;

    @Column(name = "price")
    private float price;

    @Column(name = "status")
    private String status;

    @Column(name = "weather")
    private String weather;

    @Column(name = "trip_time")
    private double tripTime;

    @Column(name = "distance")
    private float distance;

    @Column(name = "driver_id")
    private int driverId;

    @JsonBackReference
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "fk_customer_id")
    private Customer customer;

    public Trip() {

    }
}
