package com.example.demo.controller;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
@CrossOrigin
public class UserController {

    @GetMapping("/adminLogin")
    public String adminLogin(@RequestParam String username,@RequestParam String password,@RequestParam String code){
        return "";
    }
    @GetMapping("/teacherLogin")
    public String teacherLogin(@RequestParam String username,@RequestParam String password,@RequestParam String code){
        return "";
    }
}
