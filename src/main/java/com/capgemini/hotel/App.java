package com.capgemini.hotel;

import com.capgemini.hotel.controller.apiController;
import com.capgemini.hotel.model.Hotel;
import org.springframework.boot.SpringApplication;

public class App {

    public static void main(String[] args) throws Exception {
        //SpringApplication.run(apiController.class, args);

        Hotel hotel = new Hotel();

        System.out.println(hotel.toString());
    }
}
