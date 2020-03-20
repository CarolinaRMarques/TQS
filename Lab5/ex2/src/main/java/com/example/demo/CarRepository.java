package com.example.demo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
interface CarRepository extends JpaRepository<Car,Long> {
    Car findByName(String name);
}
