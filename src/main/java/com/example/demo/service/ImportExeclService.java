package com.example.demo.service;

import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

public interface ImportExeclService {
    boolean importStudent(MultipartFile multipartFile) ;

    boolean importTeacher(MultipartFile multipartFile);
}
