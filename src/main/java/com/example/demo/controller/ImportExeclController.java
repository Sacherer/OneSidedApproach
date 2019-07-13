package com.example.demo.controller;

import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping("/import")
@CrossOrigin
public class ImportExeclController {

    @PostMapping("/student")
    public boolean student(@RequestParam("file") MultipartFile file){

        return false;
    }

    @PostMapping("/teacher")
    public boolean teacher(@RequestParam("file") MultipartFile file){

        return false;
    }

    @PostMapping("/deptment")
    public boolean deptment(@RequestParam("file") MultipartFile file){

        return false;
    }
}
