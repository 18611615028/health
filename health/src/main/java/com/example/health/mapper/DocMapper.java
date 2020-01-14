package com.example.health.mapper;

import com.example.health.domin.*;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface DocMapper {
    int login(@Param("userName")String userName, @Param("passWord")String passWord);
    int loginAdmin(@Param("userName")String userName, @Param("passWord")String passWord);
    void logon(@Param("doc") Doc doc);
    List<User> getAppointmentListByQueryCondition(@Param("queryCondition") QueryCondition queryCondition);
    void createHealth(@Param("health") Health health);
    void updateNHealth(@Param("health") Health health);
    void updateWHealth(@Param("health") Health health);
    void updateEHealth(@Param("health") Health health);
    void updateAppointment(@Param("queryCondition") QueryCondition queryCondition);
    Health getHealth(@Param("health") Health health);
    int selectUserName(@Param("userName")String userName);
    Doc getDoc(@Param("docId") int docId);
    void updateDoc(@Param("doc") Doc doc);
    Doc getDocQua(@Param("docId") int docId);
    void updateDocQua(@Param("doc") Doc doc);
    List<Knowledge> getKnowledgeList();
    void createKnowledge(@Param("knowledge") Knowledge knowledge);
    void insertIdInDocQua(@Param("docId") int docId);
    Knowledge checkKnowledge(@Param("Id") int Id);
    void updateKnowledge(@Param("Id") int Id,@Param("status") int status);
    List<Doc> getDocQuaList();
    int loginUser(@Param("user") User user);
    int beforeLogonUser(@Param("userName") String userName);
    void logonUser(@Param("user") User user);
    List<QueryCondition> getAppointment(@Param("userId") int userId);
    User getUser(@Param("userId") int userId);
    void userAppointment(@Param("user") User user);
    void updateAppointmentUser(@Param("user") User user);
    void deleteAppointment(@Param("user") User user);
    List<Health> getAllReport(@Param("userId") int userId);
    List<Doc> getDocList(@Param("docList") List<Integer> docList);
    List<Health> getHealthUserList(@Param("userId") int userId);
    Health getHealthUser(@Param("health") Health health);
    void createHealthUser(@Param("health") Health health);
    void deleteHealthUser(@Param("health") Health health);
    void updateUser(@Param("user") User user);
    List<Knowledge> getUserKnowledgeList();
    List<Knowledge> getUserKnowledgeList2(@Param("userId") int userId);
    void collect(@Param("knowledge") Knowledge knowledge);
    int selectCollect(@Param("userId") int userId,@Param("Id") int Id);
    void deleteCollect(@Param("userId") int userId,@Param("Id") int Id);
    Doc selectOffice(@Param("docId") int docId);
}
