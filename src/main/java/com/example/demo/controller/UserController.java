package com.example.demo.controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
@CrossOrigin
public class UserController {

    @RequestMapping("/register")
    public void register() {

    }

    @RequestMapping("/adminRegister")
    public void AdminRegister() {

    }

}
