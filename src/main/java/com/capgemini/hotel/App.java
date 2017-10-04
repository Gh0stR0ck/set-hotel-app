package com.capgemini.hotel;

import com.capgemini.hotel.utils.Database;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class App {

    public static Hotel hotel = new Hotel();

    public static void main(String[] args) throws Exception {
        System.out.println("Database");
        Database db = new Database(
                "capgemini-academy.ck17qz3qdemp.eu-west-1.rds.amazonaws.com",
                "hotel1",
                "capgemini",
                "hotel1");

        SpringApplication.run(App.class, args);
    }
}
