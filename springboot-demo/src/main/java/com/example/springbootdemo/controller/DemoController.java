package com.example.springbootdemo.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.net.InetAddress;
import java.net.UnknownHostException;

@RestController
public class DemoController {

    @RequestMapping("/whoami")
    public String whoami() {
        StringBuilder message = new StringBuilder("You are connected ");
        try {
            InetAddress ip = InetAddress.getLocalHost();
            message.append(" from host: " + ip);
        } catch (UnknownHostException e) {
            e.printStackTrace();
        }
        return message.toString();
    }


}
