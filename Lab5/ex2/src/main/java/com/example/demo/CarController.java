package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/api")
public class CarController {

    @Autowired
    private CarService carService;

    public CarController(CarService carService){ this.carService = carService;}

    @GetMapping(path="/cars/{name}")
    public Car getCar(@PathVariable String name) {
        return carService.getCarDetails(name);
    }

}
