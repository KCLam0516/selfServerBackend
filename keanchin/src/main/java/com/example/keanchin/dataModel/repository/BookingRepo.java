package com.example.keanchin.dataModel.repository;

import com.example.keanchin.dataModel.Booking;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookingRepo extends JpaRepository<Booking, String> {
    Booking findByCarId(Long carId);
    Booking findById(Long id);
}
