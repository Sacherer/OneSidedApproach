package com.example.demo.controller;

import com.example.demo.po.Student;
import com.example.demo.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/student")
@CrossOrigin
public class StudentController {

    @Autowired
    private StudentService studentService;

    @GetMapping("/getStu")
    public Student getStu(@RequestParam String sid) {//
        Student student = studentService.selectByPrimaryKey(sid);
        return student;
    }

    @GetMapping("/authorize")
    public boolean authorize(@RequestParam String code,
                             @RequestParam String phone,
                             @RequestParam String sid,
                             @RequestParam String openId,
                             @RequestParam String nickname,
                             @RequestParam String sex,
                             @RequestParam String headimgurl) {
        return studentService.authorize(code,phone,sid,openId,nickname,sex,headimgurl);
    }

    @GetMapping("/check")
    public boolean check(@RequestParam String openId) {
        Student student = studentService.getStudentByOpenId(openId);
        if (student != null) {
            return true;
        }
        return false;
    }

    @GetMapping("/send")
    public void sendSms(@RequestParam String phone) {
        studentService.send(phone);
    }
}