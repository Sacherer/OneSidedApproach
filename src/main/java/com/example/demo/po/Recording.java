package com.example.demo.po;

import java.util.Date;

public class Recording {
    private Integer rid;

    private String openid;

    private String filename;

    private Integer thumbup;

    private Integer visits;

    private Date uploadtime;

    private String recordingtime;

    private String companyname;

    private String fileurl;

    private Integer isadopt;

    public Integer getRid() {
        return rid;
    }

    public void setRid(Integer rid) {
        this.rid = rid;
    }

    public String getOpenid() {
        return openid;
    }

    public void setOpenid(String openid) {
        this.openid = openid == null ? null : openid.trim();
    }

    public String getFilename() {
        return filename;
    }

    public void setFilename(String filename) {
        this.filename = filename == null ? null : filename.trim();
    }

    public Integer getThumbup() {
        return thumbup;
    }

    public void setThumbup(Integer thumbup) {
        this.thumbup = thumbup;
    }

    public Integer getVisits() {
        return visits;
    }

    public void setVisits(Integer visits) {
        this.visits = visits;
    }

    public Date getUploadtime() {
        return uploadtime;
    }

    public void setUploadtime(Date uploadtime) {
        this.uploadtime = uploadtime;
    }

    public String getRecordingtime() {
        return recordingtime;
    }

    public void setRecordingtime(String recordingtime) {
        this.recordingtime = recordingtime == null ? null : recordingtime.trim();
    }

    public String getCompanyname() {
        return companyname;
    }

    public void setCompanyname(String companyname) {
        this.companyname = companyname == null ? null : companyname.trim();
    }

    public String getFileurl() {
        return fileurl;
    }

    public void setFileurl(String fileurl) {
        this.fileurl = fileurl == null ? null : fileurl.trim();
    }

    public Integer getIsadopt() {
        return isadopt;
    }

    public void setIsadopt(Integer isadopt) {
        this.isadopt = isadopt;
    }
}