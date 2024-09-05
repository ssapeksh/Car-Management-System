package com.carApi.Car_Management.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.carApi.Car_Management.entity.Purchase;

@Repository
public interface PurchaseRepository extends JpaRepository<Purchase, Integer> {
    // Custom query methods if needed
}
