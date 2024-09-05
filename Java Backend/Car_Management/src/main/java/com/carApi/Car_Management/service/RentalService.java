package com.carApi.Car_Management.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.carApi.Car_Management.entity.Car;
import com.carApi.Car_Management.entity.Rental;
import com.carApi.Car_Management.entity.User;
import com.carApi.Car_Management.repository.RentalRepository;

import java.util.Collection;
import java.util.Date;

@Service
public class RentalService {

    @Autowired
    private RentalRepository rentalRepository;

    @Autowired
    private CarService carService;

    @Autowired
    private UserService userService;

    public Rental rentCar(Integer carId, Integer userId, Date returnDate) {
        Car car = carService.GetOneCar(carId);
        User user = userService.getUserById(userId);

        // Assuming car is available for rent
        car.setStatus("Rented");
        carService.savecar(car);

        double totalPrice = calculateRentalPrice(car, returnDate);

        Rental rental = new Rental(car, user, new Date(), returnDate, totalPrice);
        return rentalRepository.save(rental);
    }

    private double calculateRentalPrice(Car car, Date returnDate) {
        // Custom logic to calculate rental price based on car model, duration, etc.
        long rentalDays = (returnDate.getTime() - new Date().getTime()) / (1000 * 60 * 60 * 24);
        return rentalDays * car.getPrice() * 0.10; // Example calculation
    }
    
    public Collection<Rental> GetAllRentRecords() {
        return rentalRepository.findAll();
    }
}
