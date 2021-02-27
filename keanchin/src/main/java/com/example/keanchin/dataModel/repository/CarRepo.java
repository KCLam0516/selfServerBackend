package com.example.keanchin.dataModel.repository;

import com.example.keanchin.dataModel.Car;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CarRepo extends JpaRepository<Car, String> {
    Car findById(Long id);
}
