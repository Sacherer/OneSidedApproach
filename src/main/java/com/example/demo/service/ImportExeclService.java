package com.example.demo.service;

import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

public interface ImportExeclService {
    boolean importStudent(MultipartFile multipartFile,Integer id) ;

    boolean importTeacher(MultipartFile multipartFile);
}
