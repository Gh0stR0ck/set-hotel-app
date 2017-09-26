package com.capgemini.hotel.controller;

import org.springframework.boot.*;
import org.springframework.boot.autoconfigure.*;
import org.springframework.stereotype.*;
import org.springframework.web.bind.annotation.*;

@RestController
public class apiController {

    @RequestMapping("/api")
    @ResponseBody
    String home() {
        return "API is online";
    }

}