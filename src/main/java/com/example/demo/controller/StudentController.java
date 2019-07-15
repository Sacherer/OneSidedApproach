package com.example.demo.controller;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/student")
@CrossOrigin
public class StudentController {

    @GetMapping("/getStu")
    public Student getStu(@RequestParam String sid){//
        Student student = new Student();
        return student;
    }

    @GetMapping("/authorize")
    public void authorize(@RequestParam String code){

    }

    @GetMapping("/check")
    public boolean check(){
        return false;
    }


}
