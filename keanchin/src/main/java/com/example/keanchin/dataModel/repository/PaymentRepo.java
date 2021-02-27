package com.example.keanchin.dataModel.repository;

import com.example.keanchin.dataModel.Payment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PaymentRepo extends JpaRepository<Payment, String> {
}
