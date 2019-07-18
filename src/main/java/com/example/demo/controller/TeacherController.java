package com.example.demo.controller;

import com.example.demo.po.Teacher;
import com.example.demo.service.StudentService;
import com.example.demo.service.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/teacher")
@CrossOrigin
public class TeacherController {

    @Autowired
    private StudentService studentService;

    @Autowired
    private TeacherService teacherService;

    @GetMapping("/getTeacher")
    public Teacher getTeacher(@RequestParam String tid) {
        Teacher teacher = teacherService.selectByPrimaryKey(tid);
        return teacher;
    }

    @GetMapping("/authorize")
    public boolean authorize(@RequestParam String code,
                             @RequestParam String phone,
                             @RequestParam String tid,
                             @RequestParam String openId,
                             @RequestParam String nickname,
                             @RequestParam String sex,
                             @RequestParam String headimgurl) {
        return teacherService.authorize(code, phone, tid, openId, nickname, sex, headimgurl);
    }

    @GetMapping("/check")
    public boolean check(@RequestParam String openId) {
        Teacher teacher = teacherService.getTeacherByOpenId(openId);
        if (teacher != null) {
            return true;
        }
        return false;
    }

    @PostMapping("/updateDeptment")
    public boolean updateDeptment(@RequestParam String tid) {
        return teacherService.updateDeptment(tid);
    }

    @GetMapping("/send")
    public void sendSms(@RequestParam String phone) {
        studentService.send(phone);
    }

}
