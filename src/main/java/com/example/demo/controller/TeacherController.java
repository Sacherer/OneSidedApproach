package com.example.demo.controller;

import com.example.demo.po.Teacher;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/teacher")
@CrossOrigin
public class TeacherController {

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
