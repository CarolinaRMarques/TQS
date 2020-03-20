package com.example.demo;

import javax.persistence.*;

@Entity
@Table(name = "car")
public class Car {
    private String name;
    private String maker;

    public Car() {
    }

    public Car(String name, String maker) {
        this.name = name;
        this.maker = maker;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMaker() {
        return maker;
    }

    public void setMaker(String maker) {
        this.maker = maker;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
