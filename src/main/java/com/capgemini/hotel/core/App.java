package com.capgemini.hotel.core;

import com.capgemini.hotel.core.controller.apiController;
import org.springframework.boot.SpringApplication;

public class App {

    public static void main(String[] args) throws Exception {
        SpringApplication.run(apiController.class, args);
    }
}
