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
    int loginUser(User user);
    void logonUser(User user) throws Exception;
    List<QueryCondition> getAppointment(int userId);
    User getUser(int userId);
    void userAppointment(User user);
    void updateAppointment(User user);
    void deleteAppointment(User user);
    List<Health> getAllReport(int userId);
    List<Doc> getDocList(List<Integer> docList);
    List<Health> getHealthUserList(int userId);
    Health getHealthUser(Health health);
    void createHealthUser(Health health);
    void deleteHealthUser(Health health);
    void updateUser(User user);
    List<Knowledge> getUserKnowledgeList();
    List<Knowledge> getUserKnowledgeList2(int userId);
    void collect(Knowledge knowledge);
    int selectCollect(int userId,int Id);
    void deleteCollect(int userId,int Id);
    Doc selectOffice(int docId);
}
