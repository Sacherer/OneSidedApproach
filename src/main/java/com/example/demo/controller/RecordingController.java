package com.example.demo.controller;

import com.example.demo.dto.RecordIngListDTO;
import com.example.demo.dto.TeacherRecordIngListDTO;
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
import javafx.beans.binding.Bindings;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.*;

@RestController
@RequestMapping("/recording")
@CrossOrigin
@EnableAutoConfiguration
public class RecordingController {

    @Autowired
    private RecordingMapper recordingMapper;
    @Autowired
    private DeptmentMapper deptmentMapper;


    @GetMapping("/checkStudent")//did
    public Student checkStudent(@RequestBody String openId) {
        Student student = new Student();
        return student;
    }

    @GetMapping("/checkTeacher")
    public Teacher checkTeacher(@RequestBody String openId) {
        Teacher teacher = new Teacher();
        return teacher;
    }

    // 学生查看自己录音的详情
    @GetMapping("/getStudentRecording")
    public PageInfo<StudentRecordIngListDTO> getStudentRecording(
            @RequestParam(required = false) String sname,
            @RequestParam(required = false) String name,
            @RequestParam(required = false, defaultValue = "1") Integer pageNum
    ) {
        PageHelper.startPage(pageNum, 5);
        Page<StudentRecordIngListDTO> RecordIngList = recordingMapper.getSelectByStudentList(sname, name);

        for (StudentRecordIngListDTO recordings : RecordIngList) {
            LinkedList<Deptment> list = new LinkedList<>();
            Deptment deptment = deptmentMapper.selectByPrimaryKey(recordings.getDid());
            list.add(deptment);
            Integer pid = deptment.getPid();
            if (pid != null && pid != 0) {
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

    // 老师查看的录音详情
    @GetMapping("/getTeacherRecording")
    public PageInfo<TeacherRecordIngListDTO> getTeacherRecording(
            @RequestParam(required = false) String sname,
            @RequestParam(required = false) String name,
            @RequestParam(required = false) String sid,
            @RequestParam(required = false, defaultValue = "1") Integer pageNum
    ) {
        PageHelper.startPage(pageNum, 5);
        Page<TeacherRecordIngListDTO> teacherRecordIng = recordingMapper.getSelectByTeacherList(sname, name, sid);
        for (TeacherRecordIngListDTO teacherList : teacherRecordIng) {
            LinkedList<Deptment> list = new LinkedList<>();
            Deptment deptment = deptmentMapper.selectByPrimaryKey(teacherList.getDid());
            list.add(deptment);
            Integer pid = deptment.getPid();
            if (pid != null && pid != 0) {
                deptment = deptmentMapper.getSelectByAreaId(pid);
                list.add(deptment);
                pid = deptment.getPid();
            }
            Collections.reverse(list);
            teacherList.setDeptments(list);
        }
        PageInfo<TeacherRecordIngListDTO> teacherRecordIngListDTOPageInfo = teacherRecordIng.toPageInfo();
        return teacherRecordIngListDTOPageInfo;
    }

    // 点击某一条录音展示详情并且获取浏览量
    @GetMapping("/getRecording")
    public RecordIngListDTO getRecording(@RequestParam int rid) {
        recordingMapper.getUpdatevisits(rid);
        RecordIngListDTO recordIngListDTO = recordingMapper.selectByPrimaryKey2(rid);
        LinkedList<Integer> list = new LinkedList<>();
        Deptment deptment = deptmentMapper.selectByPrimaryKey(recordIngListDTO.getDid());
        list.add(recordIngListDTO.getDid());

        Integer pid = deptment.getPid();
        if(pid!=null && pid !=0){
            deptment = deptmentMapper.getSelectByAreaId(pid);
            list.add(deptment.getPid());
            pid = deptment.getPid();
        }
        Collections.reverse(list);
        recordIngListDTO.setDids(list);
        return  recordIngListDTO;
    }

//   点赞
    @GetMapping("/likes")
    public void likes(@RequestParam int rid) {
        recordingMapper.getInsertThumbup(rid);
    }

    // 获取自己的所有录音的信息
    @GetMapping("/getOwnRecording")
    public Recording getOwnRecording(@RequestBody String openId) {
        Recording recording = new Recording();
        return recording;
    }

    //  删除该学生的录音信息及上传录音文件
    @PostMapping("/deleteOwn")
    public void deleteOwn(@RequestBody String openId) {

    }


}
