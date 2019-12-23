package com.example.health.service;

import com.example.health.domin.*;

import java.util.Date;
import java.util.List;

public interface DocService {
    int login(String userName, String passWord);
    int loginAdmin(String userName, String passWord);
    void logon(Doc doc) throws Exception;
    List<User> getAppointmentList(QueryCondition queryCondition);
    void createHealth(Health health);
    Health getHealth(Health health);
    Doc getDoc(int docId);
    void updateDoc(Doc doc);
    Doc getDocQua(int docId);
    void updateDocQua(Doc doc);
    List<Knowledge> getKnowledgeList();
    void createKnowledge(Knowledge knowledge);
    Knowledge checkKnowledge(int id);
    void updateKnowledge(int id,int status);
    List<Doc> getDocQuaList();
}
