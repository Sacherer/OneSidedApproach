package com.example.demo.dto;

import com.example.demo.po.Deptment;
import com.example.demo.po.Recording;

import java.util.LinkedList;
import java.util.List;

public class RecordIngListDTO extends Recording {
    private String name;
    private String avatar;
    private String phone;
    private String sname;
    private Byte gender;
    private List<Integer> dids;

    public List<Integer> getDids() {
        return dids;
    }

    public void setDids(List<Integer> dids) {
        this.dids = dids;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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

    public String getSname() {
        return sname;
    }

    public void setSname(String sname) {
        this.sname = sname;
    }

    public Byte getGender() {
        return gender;
    }

    public void setGender(Byte gender) {
        this.gender = gender;
    }


}
