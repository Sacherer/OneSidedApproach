package com.example.demo.controller;

import com.example.demo.service.ImportExeclService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;


@RestController
@RequestMapping("/import")
@CrossOrigin
public class ImportExeclController {

    @Autowired
    private ImportExeclService importExeclService;

    @PostMapping("/student")
    public boolean student(@RequestParam("file") MultipartFile multipartFile,@RequestParam("id") Integer id) {
        return importExeclService.importStudent(multipartFile,id);
    }

    @PostMapping("/teacher")
    public boolean teacher(@RequestParam("file") MultipartFile multipartFile,@RequestParam("id") Integer id){
        return importExeclService.importTeacher(multipartFile,id);
    }


}
