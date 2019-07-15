package com.example.demo.controller;

import com.example.demo.po.Recording;
import com.example.demo.po.Student;
import com.example.demo.po.Teacher;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping("/recording")
@CrossOrigin
@EnableAutoConfiguration
public class RecordingController {



    @GetMapping("/checkStudent")
    public Student checkStudent(@RequestBody String openId){
        Student student = new Student();
        return student;
    }

    @GetMapping("/checkTeacher")
    public Teacher checkTeacher(@RequestBody String openId){
        Teacher teacher = new Teacher();
        return teacher;
    }

    @GetMapping("/getStudentRecording")
    public Recording getStudentRecording(@RequestBody(required = false) Recording recording){
        Recording re = new Recording();
        return re;
    }

    @GetMapping("/getTeacherRecording")
    public  Recording getTeacherRecording(@RequestBody(required = false) Recording recording){
        Recording re = new Recording();
        return re;
    }

    @PostMapping("/upload")
    public boolean upload(@RequestParam("file") MultipartFile file,Recording recording){

        return false;
    }

    @GetMapping("/getRecording")
    public Recording getRecording(@RequestParam int rid){
        Recording recording = new Recording();
        return recording;
    }

    @GetMapping("/likes")
    public void likes(@RequestParam int rid){ //

    }

    @GetMapping("/download")
    public boolean download(@RequestParam String fileUrl){

        return false;
    }
    @GetMapping("/pldownload")
    public boolean pldownload(@RequestParam String[] fileUrl){

        return false;
    }
    @GetMapping("/getOwnRecording")
    public Recording getOwnRecording(@RequestBody String openId){
        Recording recording = new Recording();
        return recording;
    }

    @PostMapping("/deleteOwn")
    public void deleteOwn(@RequestBody String openId){

    }


}
