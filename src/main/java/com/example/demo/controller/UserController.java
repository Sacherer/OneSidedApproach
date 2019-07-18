package com.example.demo.controller;

import com.example.demo.dao.TeacherMapper;
import com.example.demo.dao.UserMapper;
import com.example.demo.po.Teacher;
import com.example.demo.service.StudentService;
import com.example.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
@CrossOrigin
public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    private StudentService studentService;

    @Autowired
    private TeacherMapper teacherMapper;

    @GetMapping("/getTeacher")
    public Teacher getTeacher(@RequestParam String tid){
        Teacher teacher = teacherMapper.selectByPrimaryKey(tid);
        return teacher;
    }

    @GetMapping("/send")
    public void sendSms(@RequestParam String phone) {
        studentService.send(phone);
    }

    @GetMapping("/login")
    public boolean login(@RequestParam String phone,@RequestParam String code){
        return userService.login(phone,code);
    }
}
