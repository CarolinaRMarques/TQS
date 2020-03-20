package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class CarService {
    @Autowired
    private CarRepository repo;

    public CarService(CarRepository repo) { this.repo = repo ;}

    public Car getCarDetails(String car) {
        return repo.findByName(car);
    }

}
