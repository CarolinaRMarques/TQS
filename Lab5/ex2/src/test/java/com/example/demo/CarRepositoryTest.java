package com.example.demo;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;

import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest
public class CarRepositoryTest {
    @Autowired
    private TestEntityManager entityManager;

    @Autowired
    private CarRepository repo;

    @Test
    public void whenFindByName_thenReturnCar() {
        Car a = new Car("focus","toyota");
        entityManager.persistAndFlush(a);

        Car found = repo.findByName(a.getName());
        assertThat(found.getName()).isEqualTo(a.getName());
    }

    @Test
    public void whenInvalidName_thenReturnNull() {
        Car fromDb = repo.findByName("doesNotExist");
        assertThat(fromDb).isNull();
    }

}
