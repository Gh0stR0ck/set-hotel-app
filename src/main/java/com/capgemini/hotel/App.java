package com.capgemini.hotel;

import com.capgemini.hotel.model.Guest;
import com.capgemini.hotel.model.Hotel;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class App {

    public static Hotel hotel = new Hotel();

    public static void main(String[] args) throws Exception {
        SpringApplication.run(App.class, args);

    }
}
