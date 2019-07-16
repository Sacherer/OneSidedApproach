package com.example.demo.dto;

public class ImportStudentDTO {
    private String sid;

    private String sname;

    private String phone;

    private String did;

    public String getSid() {
        return sid;
    }

    public void setSid(String sid) {
        this.sid = sid;
    }

    public String getSname() {
        return sname;
    }

    public void setSname(String sname) {
        this.sname = sname;
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

    public ImportStudentDTO(String sid, String sname, String phone, String did) {
        this.sid = sid;
        this.sname = sname;
        this.phone = phone;
        this.did = did;
    }
}
