package com.capgemini.hotel;

import com.capgemini.hotel.model.Room;
import com.capgemini.hotel.utils.Database;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class App {

    public static Database db = new Database(
            "capgemini-academy.ck17qz3qdemp.eu-west-1.rds.amazonaws.com",
            "hotel1",
            "capgemini",
            "hotel1");

    public static void main(String[] args) throws Exception {

        SpringApplication.run(App.class, args);
    }
}
