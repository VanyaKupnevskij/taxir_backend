package com.taxir.services.trip;

import com.taxir.entities.Trip;
import com.taxir.services.trip.Weather;
import com.taxir.repositories.TripRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;



@Service
public class TripServiceImplements implements TripService {

    @Autowired
    TripRepository tripRepository;

    @Override
    public Trip saveTrip(Trip trip) {
        double distance = Math.random()*101;

        trip.setStatus("Нова");
        trip.setDistance((float) distance);
        trip.setTripTime((float) (distance / 60));
        switch ((int) (Math.random()*3)) {
            case 0: trip.setWeather("Сонячно");
                    trip.setPrice((float) (distance * 10 * Weather.Sunny));
                    break;
            case 1: trip.setWeather("Дощить");
                    trip.setPrice((float) (distance * 10 * Weather.Rainny));
                    break;
            case 2: trip.setWeather("Пурга");
                    trip.setPrice((float) (distance * 10 * Weather.Storm));
                    break;
        }

        tripRepository.save(trip);

        return trip;
    }

    @Override
    public Trip getTrip(int id) {
        return tripRepository.getById(id);
    }

    @Override
    public List<Trip> getAllTripsByCustomerId(int id) {
        return tripRepository.findAllByCustomerCustomerId(id);
    }

    @Override
    public List<Trip> getAllTripsByDriverId(int id) {
        return tripRepository.findAllByDriverId(id);
    }

    @Override
    public void updateStatusOfTrip(String status, int tripId, int driverId) {
        tripRepository.updateStatusOfTrip(status, tripId, driverId);
    }

    @Override
    public List<Trip> getAllTrips() {
        return tripRepository.findAll();
    }
}
