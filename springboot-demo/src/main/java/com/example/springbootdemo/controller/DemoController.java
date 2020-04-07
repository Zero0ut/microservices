package com.example.springbootdemo.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.net.InetAddress;
import java.net.UnknownHostException;

@RestController
public class DemoController {
    @RequestMapping("/demo")
    public String demo() {
        StringBuilder message = new StringBuilder("Welcome GCP App Engine!");
        try {
            InetAddress ip = InetAddress.getLocalHost();
            message.append(" from host: " + ip);
        } catch (UnknownHostException e) {
            e.printStackTrace();
        }
        return message.toString();
    }

    @RequestMapping("/")
    public String index() {
        StringBuilder message = new StringBuilder("Default Controller!");
        try {
            InetAddress ip = InetAddress.getLocalHost();
            message.append(" from host: " + ip);
        } catch (UnknownHostException e) {
            e.printStackTrace();
        }
        return message.toString();
    }
}
