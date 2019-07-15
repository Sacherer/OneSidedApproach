package com.example.demo.controller;

import com.example.demo.dao.RecordingMapper;
import com.example.demo.dto.StudentRecordIngListDTO;
import com.example.demo.po.Recording;
import com.example.demo.po.Student;
import com.example.demo.po.Teacher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@RestController
@RequestMapping("/recording")
@CrossOrigin
@EnableAutoConfiguration
public class RecordingController {

    @Autowired
    private RecordingMapper recordingMapper;

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
    public List<StudentRecordIngListDTO> getStudentRecording(
            @RequestBody(required = false) String sname,
            @RequestBody(required = false) String name
    ){
        List<StudentRecordIngListDTO> studentRecordIngList = recordingMapper.getSelectByStudentList(sname,name);
        return studentRecordIngList;
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
