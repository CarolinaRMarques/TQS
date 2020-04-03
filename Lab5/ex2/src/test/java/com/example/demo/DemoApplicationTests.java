package com.example.demo;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import static org.assertj.core.api.Assertions.assertThat;


@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@AutoConfigureTestDatabase
class DemoApplicationTests {

    @Autowired
    private CarRepository repo;

    @Autowired
    private TestRestTemplate restClient;

    @BeforeEach
    public void setUp() throws Exception{
        repo.saveAndFlush(new Car("zoe","renault"));
        repo.saveAndFlush((new Car("prius","toyota")));
    }

    @AfterEach
    public void resetDb() {repo.deleteAll();}

    @Test
    void getCar_returnCarDetailsTest() {
        ResponseEntity <Car> entity = restClient.getForEntity("/cars/prius",Car.class);
        assertThat(entity.getStatusCode()).isEqualTo(HttpStatus.OK);
        assertThat(entity.getBody().getName()).isEqualTo("prius");


    }
    @Test
    void contextLoads() {
    }

}
