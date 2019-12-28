package com.example.health.service;

import com.example.health.domin.*;
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
    public int loginAdmin(String userName, String passWord){
        return docMapper.loginAdmin(userName,passWord);
    }

    @Override
    public void logon(Doc doc) throws Exception {
        if(docMapper.selectUserName(doc.getUserName())>0){
            throw new Exception();
        }
        docMapper.logon(doc);
        int d = docMapper.login(doc.getUserName(),doc.getPassWord());
        docMapper.insertIdInDocQua(d);
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

    @Override
    public void updateDocQua(Doc doc){
        docMapper.updateDocQua(doc);
    }

    @Override
    public List<Knowledge> getKnowledgeList(){
        return docMapper.getKnowledgeList();
    }

    @Override
    public void createKnowledge(Knowledge knowledge){
        docMapper.createKnowledge(knowledge);
    }

    @Override
    public Knowledge checkKnowledge(int id){
        return docMapper.checkKnowledge(id);
    }

    @Override
    public void updateKnowledge(int id,int status){
        docMapper.updateKnowledge(id,status);
    }

    @Override
    public List<Doc> getDocQuaList(){
        return docMapper.getDocQuaList();
    }

    @Override
    public int loginUser(User user){
        return docMapper.loginUser(user);
    }

    @Override
    public void logonUser(User user) throws Exception {
        if(docMapper.beforeLogonUser(user.getUserName())>0){
            throw new Exception();
        }
        docMapper.logonUser(user);
    }

    @Override
    public List<QueryCondition> getAppointment(int userId) {
       return docMapper.getAppointment(userId);
    }

    @Override
    public User getUser(int userId) {
        return docMapper.getUser(userId);
    }

    @Override
    public void userAppointment(User user) {
        docMapper.userAppointment(user);
    }

    @Override
    public void updateAppointment(User user) {
        docMapper.updateAppointmentUser(user);
    }

    @Override
    public void deleteAppointment(User user) {
        docMapper.deleteAppointment(user);
    }

    @Override
    public List<Health> getAllReport(int userId) {
        return docMapper.getAllReport(userId);
    }

    @Override
    public List<Doc> getDocList(List<Integer> docList) {
        return docMapper.getDocList(docList);
    }

    @Override
    public List<Health> getHealthUserList(int userId) {
        return docMapper.getHealthUserList(userId);
    }

    @Override
    public Health getHealthUser(Health health) {
        return docMapper.getHealthUser(health);
    }

    @Override
    public void createHealthUser(Health health) {
        docMapper.createHealthUser(health);
    }

    @Override
    public void deleteHealthUser(Health health) {
        docMapper.deleteHealthUser(health);
    }

    @Override
    public void updateUser(User user) {
        docMapper.updateUser(user);
    }

    @Override
    public List<Knowledge> getUserKnowledgeList() {
        return docMapper.getUserKnowledgeList();
    }

    @Override
    public List<Knowledge> getUserKnowledgeList2(int userId) {
        return docMapper.getUserKnowledgeList2(userId);
    }

    @Override
    public void collect(Knowledge knowledge) {
        docMapper.collect(knowledge);
    }

    @Override
    public int selectCollect(int userId,int Id) {
        return docMapper.selectCollect(userId,Id);
    }

    @Override
    public void deleteCollect(int userId,int Id) {
        docMapper.deleteCollect(userId,Id);
    }
}
