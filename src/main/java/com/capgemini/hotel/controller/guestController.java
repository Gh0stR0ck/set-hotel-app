package com.capgemini.hotel.controller;

import org.springframework.boot.*;
import org.springframework.boot.autoconfigure.*;
import org.springframework.stereotype.*;
import org.springframework.web.bind.annotation.*;

@RestController
public class guestController {

    @RequestMapping("/api/guest")
    @ResponseBody
    String home() {
        return "API is online";
    }

}