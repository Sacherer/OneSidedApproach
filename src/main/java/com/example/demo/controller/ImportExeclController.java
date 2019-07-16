package com.example.demo.controller;

import com.example.demo.service.ImportExeclService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@RestController
@RequestMapping("/import")
@CrossOrigin
public class ImportExeclController {

    @Autowired
    private ImportExeclService importExeclService;

    @PostMapping("/student")
    public boolean student(@RequestParam("file") MultipartFile multipartFile) {
        return importExeclService.importStudent(multipartFile);
    }

    @PostMapping("/teacher")
    public boolean teacher(@RequestParam("file") MultipartFile multipartFile){
        return importExeclService.importTeacher(multipartFile);
    }

    @PostMapping("/deptment")
    public boolean deptment(@RequestParam("file") MultipartFile file){

        return false;
    }
}
