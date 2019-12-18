package com.example.health.domin;

import java.util.Date;

public class User {
    int userId;
    Date time;
    String name;
    String sex;
    String note;
    int finish;

    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public int getFinish() {
        return finish;
    }

    public void setFinish(int finish) {
        this.finish = finish;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public Date getAppTime() {
        return time;
    }

    public void setAppTime(Date appTime) {
        this.time = appTime;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getAppNote() {
        return note;
    }

    public void setAppNote(String appNote) {
        this.note = appNote;
    }
}
