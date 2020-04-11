package com.example.springbootdemo.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MessageController {
    @RequestMapping("/message")
    public String message() {
        StringBuilder message = new StringBuilder("Hello from Google Cloud");
        return message.toString();
    }
}
