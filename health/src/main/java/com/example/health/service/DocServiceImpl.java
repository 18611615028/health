package com.example.health.service;

import com.example.health.domin.Doc;
import com.example.health.domin.Health;
import com.example.health.domin.QueryCondition;
import com.example.health.domin.User;
import com.example.health.mapper.DocMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class DocServiceImpl implements DocService{

    @Autowired
    DocMapper docMapper;

    @Override
    public int login(String userName, String passWord){
        return docMapper.login(userName,passWord);
    }

    @Override
    public void logon(Doc doc) throws Exception {
        if(docMapper.selectUserName(doc.getUserName())>0){
            throw new Exception();
        }
        docMapper.logon(doc);
    }

    @Override
    public List<User> getAppointmentList(QueryCondition queryCondition){
        return docMapper.getAppointmentListByQueryCondition(queryCondition);
    }

    @Override
    public void createHealth(Health health) {
        if(health.getStatus()==1) {
            docMapper.createHealth(health);
        }
        QueryCondition queryCondition = new QueryCondition();
        queryCondition.setTime(health.getTime());
        queryCondition.setUserId(health.getUserId());
        int i = health.getStatus();
        i++;
        queryCondition.setFinish(i);
        docMapper.updateAppointment(queryCondition);
        if(health.getwDocId() != 0){
            docMapper.updateWHealth(health);
        } else if (health.getnDocId() != 0){
            docMapper.updateNHealth(health);
        } else if(health.geteDocId() !=0){
            docMapper.updateEHealth(health);
        }
    }

    @Override
    public Health getHealth(Health health){
        return docMapper.getHealth(health);
    }

    @Override
    public Doc getDoc(int docId){
        return docMapper.getDoc(docId);
    }

    @Override
    public void updateDoc(Doc doc){
        docMapper.updateDoc(doc);
    }

    @Override
    public Doc getDocQua(int docId){
        return docMapper.getDocQua(docId);
    }
}
