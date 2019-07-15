package com.example.demo.controller;

import com.example.demo.dto.TeacherListDTO;
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

    @GetMapping("/getTeacherRecording")
    public PageInfo<TeacherListDTO> getTeacherRecording(
            @RequestParam(required = false) String sid,
            @RequestParam(required = false) String sname,
            @RequestParam(required = false) String nickname,
            @RequestParam(required = false) String name,
            @RequestParam(required = false) String dname,
            @RequestParam(required = false,defaultValue = "1") Integer pageNum
    ){
        PageHelper.startPage(pageNum,5);
        Page<TeacherListDTO> recordingListAll = teacherMapper.getSelectListAllInterface(sid,sname,nickname,name,dname);
        PageInfo<TeacherListDTO> recordingListDTOPageInfo = recordingListAll.toPageInfo();
        return recordingListDTOPageInfo;
    }
}
