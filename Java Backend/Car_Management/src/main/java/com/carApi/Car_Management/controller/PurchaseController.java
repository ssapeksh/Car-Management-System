package com.carApi.Car_Management.controller;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.carApi.Car_Management.service.PurchaseService;
import com.carApi.Car_Management.entity.Purchase;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
public class PurchaseController {

    @Autowired
    private PurchaseService purchaseService;

    @PostMapping("api/buy")
    public ResponseEntity<Purchase> purchaseCar(@RequestParam Integer carId, @RequestParam Integer userId) {
        Purchase purchase = purchaseService.purchaseCar(carId, userId);
        return ResponseEntity.ok(purchase);
    }
    
    
    @GetMapping("api/GetListOfPurchases")
    public Collection<Purchase> GetAllPurchases()
    {
    	Collection<Purchase> allpurchases = purchaseService.GetAllPurchases();
    	return allpurchases;
    }
}
