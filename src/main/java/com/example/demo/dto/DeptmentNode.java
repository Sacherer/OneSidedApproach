package com.example.demo.dto;

import com.example.demo.po.Deptment;
import com.fasterxml.jackson.annotation.JsonInclude;

import java.util.List;
@JsonInclude(JsonInclude.Include.NON_EMPTY)
public class DeptmentNode {
    private Integer did;

    private String dname;

    private List<DeptmentNode> subDeptments;

    public List<DeptmentNode> getSubDeptments() {
        return subDeptments;
    }

    public void setSubDeptments(List<DeptmentNode> subDeptments) {
        this.subDeptments = subDeptments;
    }



    public Integer getDid() {
        return did;
    }

    public void setDid(Integer did) {
        this.did = did;
    }

    public String getDname() {
        return dname;
    }

    public void setDname(String dname) {
        this.dname = dname;
    }


}
