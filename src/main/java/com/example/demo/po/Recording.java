package com.example.demo.po;

public class Recording {
    private Integer rid;

    private Integer cid;

    private Integer sid;

    private Integer did;

    private Integer thumbup;

    private Integer visits;

    private String recordingtime;

    private String fileurl;

    private Integer isadopt;

    public Integer getRid() {
        return rid;
    }

    public void setRid(Integer rid) {
        this.rid = rid;
    }

    public Integer getCid() {
        return cid;
    }

    public void setCid(Integer cid) {
        this.cid = cid;
    }

    public Integer getSid() {
        return sid;
    }

    public void setSid(Integer sid) {
        this.sid = sid;
    }

    public Integer getDid() {
        return did;
    }

    public void setDid(Integer did) {
        this.did = did;
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

    public String getRecordingtime() {
        return recordingtime;
    }

    public void setRecordingtime(String recordingtime) {
        this.recordingtime = recordingtime == null ? null : recordingtime.trim();
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