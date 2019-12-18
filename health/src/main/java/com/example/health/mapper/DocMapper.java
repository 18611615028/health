package com.example.health.mapper;

import com.example.health.domin.Doc;
import com.example.health.domin.Health;
import com.example.health.domin.QueryCondition;
import com.example.health.domin.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface DocMapper {
    int login(@Param("userName")String userName, @Param("passWord")String passWord);
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
}
