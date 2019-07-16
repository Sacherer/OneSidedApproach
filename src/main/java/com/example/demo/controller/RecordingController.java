package com.example.demo.controller;

import com.github.pagehelper.Page;
import com.example.demo.dao.DeptmentMapper;
import com.example.demo.dao.RecordingMapper;
import com.example.demo.dto.StudentRecordIngListDTO;
import com.example.demo.po.Deptment;
import com.example.demo.po.Recording;
import com.example.demo.po.Student;
import com.example.demo.po.Teacher;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

@RestController
@RequestMapping("/recording")
@CrossOrigin
@EnableAutoConfiguration
public class RecordingController {

    @Autowired
    private RecordingMapper recordingMapper;
    @Autowired
    private DeptmentMapper deptmentMapper;

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
    public PageInfo<StudentRecordIngListDTO> getStudentRecording(
            @RequestParam(required = false) String sname,
            @RequestParam(required = false) String name,
            @RequestParam(required = false,defaultValue = "1") Integer pageNum
    ){
        PageHelper.startPage(pageNum,5);
        Page<StudentRecordIngListDTO> RecordIngList = recordingMapper.getSelectByStudentList(sname,name);

        for (StudentRecordIngListDTO recordings : RecordIngList) {
            LinkedList<Deptment> list = new LinkedList<>();
            Deptment deptment = deptmentMapper.selectByPrimaryKey(recordings.getDid());
            list.add(deptment);
            Integer pid = deptment.getPid();
            if(pid!=null && pid!=0){
                deptment = deptmentMapper.getSelectByAreaId(pid);
                list.add(deptment);
                pid = deptment.getPid();
            }
            Collections.reverse(list);
            recordings.setDeptments(list);
        }
        PageInfo<StudentRecordIngListDTO> studentRecordIngListDTOPageInfo = RecordIngList.toPageInfo();
        return studentRecordIngListDTOPageInfo;
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
