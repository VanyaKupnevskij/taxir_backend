package com.taxir.services.trip;

import com.taxir.entities.Customer;
import com.taxir.entities.Trip;

import java.util.List;

public interface TripService {

    Trip saveTrip(Trip trip);

    Trip getTrip(int id);

    List<Trip> getAllTripsByCustomerId(int id);

    List<Trip> getAllTripsByDriverId(int id);

    void updateStatusOfTrip(String status, int tripId, int driverId);

    List<Trip> getAllTrips();
}
