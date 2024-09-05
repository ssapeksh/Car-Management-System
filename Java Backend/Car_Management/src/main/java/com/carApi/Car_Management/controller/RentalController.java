package com.carApi.Car_Management.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.carApi.Car_Management.service.RentalService;
import com.carApi.Car_Management.entity.Rental;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Collection;
import java.util.Date;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
public class RentalController {

    @Autowired
    private RentalService rentalService;

    @PostMapping("/api/rental/rent")
    public ResponseEntity<?> rentCar(@RequestParam Integer carId, @RequestParam Integer userId, @RequestParam String returnDate) {
        
        // Convert the String to Date
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        Date returndate = null;
        try {
            returndate = formatter.parse(returnDate);
        } catch (ParseException e) {
            return ResponseEntity.badRequest().body("Invalid date format.");
        }
        
        Rental rental = rentalService.rentCar(carId, userId, returndate);
        return ResponseEntity.ok(rental);
    }
    
    @GetMapping("/api/rental/GetAllRentalRecords")
    public Collection<Rental> GetAllRentalRecords() {
        return rentalService.GetAllRentRecords();
    }
}
