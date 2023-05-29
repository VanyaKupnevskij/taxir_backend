package com.taxir.repositories;

import com.taxir.entities.Trip;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface TripRepository extends JpaRepository<Trip, Integer> {
    List<Trip> findAllByCustomerCustomerId(int id);
    List<Trip> findAllByDriverId(int id);

    @Modifying
    @Transactional
    @Query(value = "UPDATE trips " +
            "SET status=?1, driver_id=?3 " +
            "WHERE trip_id=?2", nativeQuery = true)
    void updateStatusOfTrip(String status, int tripId, int driverId);
}
