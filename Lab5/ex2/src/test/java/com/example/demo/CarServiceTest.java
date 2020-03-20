package com.example.demo;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;

import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;

@ExtendWith(MockitoExtension.class)
public class CarServiceTest {

    @Mock(lenient = true)
    private CarRepository carRepository;
    @InjectMocks
    private CarService carService;

    @BeforeEach
    public void setUp() throws Exception {
        Car a = new Car("focus", "ford");
        Mockito.when(carRepository.findByName(a.getName())).thenReturn(a);
        Mockito.when(carRepository.findByName("wrong_name")).thenReturn(null);
        Mockito.when(carRepository.findById(a.getId())).thenReturn(Optional.of(a));
    }


    @Test
    public void whenFindByName_thenReturnCar() {
        String name =  "focus";
        Car found = carRepository.findByName(name);
        assertThat(found.getName()).isEqualTo(name);
    }

    @Test
    public void whenInvalidName_thenReturnNull() {
        Car fromDb = carRepository.findByName("doesNotExist");
        assertThat(fromDb).isNull();
    }

    @Test
    public void whenValidCar_thenCarDetailsAreCorrect() {
        String maker = "ford";
        assertThat(carService.getCarDetails("focus").getMaker()).isEqualTo(maker);
    }

    @Test
    public void whenEmptyConstructor_NothingHappens(){
        Car b = new Car();
        assertThat(carService.getCarDetails(b.getName())).isNull();
    }
}
