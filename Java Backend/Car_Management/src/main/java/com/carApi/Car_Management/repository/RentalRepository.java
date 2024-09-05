package com.carApi.Car_Management.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.carApi.Car_Management.entity.Rental;

@Repository
public interface RentalRepository extends JpaRepository<Rental, Integer> {
    // Custom query methods if needed
}
