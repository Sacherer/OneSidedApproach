package com.example.demo.dto;

public class ImportTeacherDTO {
    private String tid;

    private String tname;

    private String phone;

    private String did;

    public String getTid() {
        return tid;
    }

    public void setTid(String tid) {
        this.tid = tid;
    }

    public String getTname() {
        return tname;
    }

    public void setTname(String tname) {
        this.tname = tname;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getDid() {
        return did;
    }

    public void setDid(String did) {
        this.did = did;
    }

    public ImportTeacherDTO(String tid, String tname, String phone, String did) {
        this.tid = tid;
        this.tname = tname;
        this.phone = phone;
        this.did = did;
    }
}
