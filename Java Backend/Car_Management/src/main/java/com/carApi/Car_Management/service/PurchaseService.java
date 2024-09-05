package com.carApi.Car_Management.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.carApi.Car_Management.entity.Car;
import com.carApi.Car_Management.entity.Purchase;
import com.carApi.Car_Management.entity.User;
import com.carApi.Car_Management.repository.PurchaseRepository;

import java.util.Collection;
import java.util.Date;

@Service
public class PurchaseService {

    @Autowired
    private PurchaseRepository purchaseRepository;

    @Autowired
    private CarService carService;

    @Autowired
    private UserService userService;

    public Purchase purchaseCar(Integer carId, Integer userId) {
        Car car = carService.GetOneCar(carId);
        User user = userService.getUserById(userId);

        // Assuming car is available for purchase
        car.setStatus("Sold");
        carService.savecar(car);

        Purchase purchase = new Purchase(car, user, new Date(), car.getPrice());
        return purchaseRepository.save(purchase);
    }
    
    public Collection<Purchase> GetAllPurchases()
    {
    	Collection<Purchase> allpurchases = purchaseRepository.findAll();
    	return allpurchases;
    }
}
