package com.capgemini.hotel;

import com.capgemini.hotel.model.Guest;
import com.capgemini.hotel.model.Hotel;
import com.capgemini.hotel.utils.Database;
import com.sun.org.apache.xpath.internal.operations.Bool;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.sql.ResultSet;

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
