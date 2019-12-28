package com.example.health.controller;

import com.example.health.domin.*;
import com.example.health.service.DocService;
import com.example.health.service.DocServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.constraints.Email;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/doc")
public class DocController {
    @Autowired
    DocService docService;

    @RequestMapping(value = "/login",method = RequestMethod.POST)
    public int login(@RequestBody Doc doc){
        return docService.login(doc.getUserName(),doc.getPassWord());
    }

    @RequestMapping(value = "/logon",method = RequestMethod.POST)
    public void logon(@RequestBody Doc doc) throws Exception {
        docService.logon(doc);
    }

    @RequestMapping(value = "/getAppointmentList",method = RequestMethod.POST)
    public List<User> getAppointmentList(@RequestBody QueryCondition queryCondition){
        return docService.getAppointmentList(queryCondition);
    }

    @RequestMapping(value = "/updateHealth",method = RequestMethod.POST)
    public void updateHealth(@RequestBody Health health){
        docService.createHealth(health);
    }

    @RequestMapping(value = "/getHealth",method = RequestMethod.POST)
    public Health getHealth(@RequestBody Health health){
        return docService.getHealth(health);
    }

    @RequestMapping(value = "/getDoc",method = RequestMethod.GET)
    public Doc getDoc(int docId){
        return docService.getDoc(docId);
    }

    @RequestMapping(value = "/updateDoc",method = RequestMethod.POST)
    public void updateDoc(@RequestBody Doc doc){
        docService.updateDoc(doc);
    }

    @RequestMapping(value = "/getDocQua",method = RequestMethod.GET)
    public Doc getDocQua(int docId){
        Doc docQua = docService.getDocQua(docId);
        return docQua;
    }

    @RequestMapping(value = "/updateDocQua",method = RequestMethod.POST)
    public void updateDocQua(@RequestBody Doc doc){
        docService.updateDocQua(doc);
    }

    @RequestMapping(value = "/getKnowledgeList",method = RequestMethod.POST)
    public List<Knowledge> getKnowledgeList(){
         return docService.getKnowledgeList();
    }

    @RequestMapping(value = "/createKnowledge",method = RequestMethod.POST)
    public void createKnowledgeList(@RequestBody Knowledge knowledge){
        docService.createKnowledge(knowledge);
    }

    @RequestMapping(value = "/checkKnowledge",method = RequestMethod.GET)
    public Knowledge checkKnowledge(int id){
       return docService.checkKnowledge(id);
    }

    @RequestMapping(value = "/loginAdmin",method = RequestMethod.POST)
    public int loginAdmin(@RequestBody Admin admin){
        return docService.loginAdmin(admin.getUserName(),admin.getPassWord());
    }

    @RequestMapping(value = "/updateKnowledge",method = RequestMethod.GET)
    public void updateKnowledge(int id, int status){
        docService.updateKnowledge(id,status);
    }

    @RequestMapping(value = "/getDocQuaList",method = RequestMethod.GET)
    public List<Doc> getDocQuaList(){
        return docService.getDocQuaList();
    }

    @RequestMapping(value = "/loginUser",method = RequestMethod.POST)
    public int loginUser(@RequestBody User user){
        return docService.loginUser(user);
    }

    @RequestMapping(value = "/logonUser",method = RequestMethod.POST)
    public void logonUser(@RequestBody User user )throws Exception {
        docService.logonUser(user);
    }

    @RequestMapping(value = "/getAppointment",method = RequestMethod.GET)
    public List<QueryCondition> getAppointment(int userId){
         return docService.getAppointment(userId);
    }

    @RequestMapping(value = "/getUser",method = RequestMethod.GET)
    public User getUser(int userId){
        return docService.getUser(userId);
    }

    @RequestMapping(value = "/userAppointment",method = RequestMethod.POST)
    public void userAppointment(@RequestBody User user){
        docService.userAppointment(user);
    }

    @RequestMapping(value = "/updateAppointment",method = RequestMethod.POST)
    public void updateAppointment(@RequestBody User user){
        docService.updateAppointment(user);
    }

    @RequestMapping(value = "/deleteAppointment",method = RequestMethod.POST)
    public void deleteAppointment(@RequestBody User user){
        docService.deleteAppointment(user);
    }

    @RequestMapping(value = "/getAllReport",method = RequestMethod.GET)
    public List<Health> getAllReport(int userId){
        return docService.getAllReport(userId);
    }

    @RequestMapping(value = "/getDocList",method = RequestMethod.POST)
    public List<Doc> getDocList(@RequestBody  List<Integer> docList){
        return docService.getDocList(docList);
    }

    @RequestMapping(value = "/getHealthUserList",method = RequestMethod.GET)
    public List<Health> getHealthUserList(int userId){
        return docService.getHealthUserList(userId);
    }

    @RequestMapping(value = "/getHealthUser",method = RequestMethod.POST)
    public Health getHealthUser(@RequestBody  Health health){
        return docService.getHealthUser(health);
    }

    @RequestMapping(value = "/createHealthUser",method = RequestMethod.POST)
    public void createHealthUser(@RequestBody  Health health){
        docService.createHealthUser(health);
    }

    @RequestMapping(value = "/deleteHealthUser",method = RequestMethod.POST)
    public void deleteHealthUser(@RequestBody  Health health){
        docService.deleteHealthUser(health);
    }

    @RequestMapping(value = "/updateUser",method = RequestMethod.POST)
    public void updateUser(@RequestBody  User user){
        docService.updateUser(user);
    }

    @RequestMapping(value = "/getUserKnowledgeList",method = RequestMethod.GET)
    public List<Knowledge> getUserKnowledgeList(){
        return docService.getUserKnowledgeList();
    }

    @RequestMapping(value = "/getUserKnowledgeList2",method = RequestMethod.GET)
    public List<Knowledge> getUserKnowledgeList2(int userId){
        return docService.getUserKnowledgeList2(userId);
    }

    @RequestMapping(value = "/collect",method = RequestMethod.POST)
    public int collect(@RequestBody Knowledge knowledge){
        docService.collect(knowledge);
        return 1;
    }

    @RequestMapping(value = "/selectCollect",method = RequestMethod.GET)
    public int selectCollect(int userId,int Id){
        return docService.selectCollect(userId,Id);
    }

    @RequestMapping(value = "/deleteCollect",method = RequestMethod.GET)
    public int deleteCollect(int userId,int Id){
        docService.deleteCollect(userId,Id);
        return 0;
    }
}
