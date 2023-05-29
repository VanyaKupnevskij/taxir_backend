package com.taxir.controllers;

import com.taxir.entities.Trip;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
@CrossOrigin
public class TripRestController extends ServiceController {

    @PostMapping("/trip/create")
    public Trip createTrip(@RequestBody Trip trip) {
        tripService.saveTrip(trip);

        return trip;
    }

    @GetMapping("/trip/{id}")
    public Trip getTrip(@PathVariable int id) {

        return tripService.getTrip(id);
    }

    @GetMapping("/trip/getAllByCustomer/{id}")
    public List<Trip> getTrips(@PathVariable int id) {

        return tripService.getAllTripsByCustomerId(id);
    }

    @GetMapping("/trip/getAllByDriver/{id}")
    public List<Trip> getTripsDriver(@PathVariable int id) {

        return tripService.getAllTripsByDriverId(id);
    }

    @GetMapping("/trip/")
    public List<Trip> getAllTrips() {

        return tripService.getAllTrips();
    }

    @PatchMapping("/trip/updateStatus")
    public Trip updateStatusOfTrip(@RequestBody Trip trip) {
        tripService.updateStatusOfTrip(trip.getStatus(), trip.getTripId(), trip.getDriverId());

        return tripService.getTrip(trip.getTripId());
    }
}
