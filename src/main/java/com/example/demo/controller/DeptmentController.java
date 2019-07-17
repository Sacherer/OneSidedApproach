package com.example.demo.controller;

import com.example.demo.dao.DeptmentMapper;
import com.example.demo.dto.DeptmentNode;
import com.example.demo.po.Deptment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/deprecated")
@CrossOrigin
@EnableAutoConfiguration
public class DeptmentController {

    @Autowired
    private DeptmentMapper deptmentMapper;

    @GetMapping("/getAreaAll")
    public List<DeptmentNode> getAreaAll(@RequestParam Integer did){
        List<DeptmentNode> deptmentNodes = deptmentMapper.getSelectTree(did);
        return deptmentNodes;
    }

    @GetMapping("/getCollege")
    public List<Deptment> getCollege(){
        List<Deptment> deptmentList = deptmentMapper.getCollege();
        return deptmentList;
    }

}
