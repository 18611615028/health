package com.example.health.service;

import com.example.health.domin.Doc;
import com.example.health.domin.Health;
import com.example.health.domin.QueryCondition;
import com.example.health.domin.User;

import java.util.Date;
import java.util.List;

public interface DocService {
    int login(String userName, String passWord);
    void logon(Doc doc) throws Exception;
    List<User> getAppointmentList(QueryCondition queryCondition);
    void createHealth(Health health);
    Health getHealth(Health health);
    Doc getDoc(int docId);
    void updateDoc(Doc doc);
    Doc getDocQua(int docId);
}
