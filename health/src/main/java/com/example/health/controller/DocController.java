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
}
