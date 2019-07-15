package com.example.demo.controller;

import com.example.demo.dao.TeacherMapper;
import com.example.demo.dto.TeacherListDTO;
import com.example.demo.po.Teacher;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/teacher")
@CrossOrigin
public class TeacherController {

    @Autowired
    private TeacherMapper teacherMapper;

    @GetMapping("/getTeacher")
    public Teacher getTeacher(@RequestParam String tid){
        Teacher teacher = new Teacher();
        return teacher;
    }

    @GetMapping("/authorize")
    public void authorize(@RequestParam String code){

    }

    @GetMapping("/check")
    public boolean check(){
        return false;
    }
    
    @PostMapping("/updateDeptment")
    public boolean updateDeptment(){
        return false;
    }


}
