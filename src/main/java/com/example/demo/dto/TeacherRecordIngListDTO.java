package com.example.demo.dto;

import com.example.demo.po.Deptment;
import com.example.demo.po.Recording;

import java.util.List;

public class TeacherRecordIngListDTO extends Recording {
    private String sname;
    private String avatar;
    private String phone;
    private Byte gender;
    private String name;
    private List<Deptment> deptments;

    public String getSname() {
        return sname;
    }

    public void setSname(String sname) {
        this.sname = sname;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Byte getGender() {
        return gender;
    }

    public void setGender(Byte gender) {
        this.gender = gender;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Deptment> getDeptments() {
        return deptments;
    }

    public void setDeptments(List<Deptment> deptments) {
        this.deptments = deptments;
    }
}
