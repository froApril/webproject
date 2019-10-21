package controller;

import dao.Topic2EntityDao;
//import dao.TopicEntityDao;
import dao.UserEntityDao;
import dao.impl.Topic2EntityDaoImpl;
//import dao.impl.TopicEntityDaoImpl;
import dao.impl.UserEntityDaoImpl;
import entities.Topic2Entity;
//import entities.TopicsEntity;
import entities.UserEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.Writer;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class adminController {

    @RequestMapping(value= "/addNewTopic", method = RequestMethod.POST)
    @ResponseBody
    public String addNewTopic(HttpServletRequest req) {

        Topic2Entity topicEntity = new Topic2Entity();
        Topic2EntityDaoImpl topicEntityDao = new Topic2EntityDaoImpl();
        if(topicEntityDao.existTopic(req.getParameter("name"))) {
            return "fail";
        }

        else {
            topicEntity.setMajor(req.getParameter("major"));
            topicEntity.setCourseId(req.getParameter("id"));
            topicEntity.setName(req.getParameter("name"));
            topicEntityDao.addNewTopic(topicEntity);
            return "success";
        }
    }


    @RequestMapping(value="/tpl",method=RequestMethod.GET)
    @ResponseBody
    public List<Topic2Entity> getAllTopics() {
        Topic2EntityDao topicEntityDao = new Topic2EntityDaoImpl();
        return topicEntityDao.getAllTopics();

    }

    @RequestMapping(value="/det",method=RequestMethod.POST)
    @ResponseBody
    public List<Topic2Entity> delSpecial(@RequestBody List<String> ll) {
        Topic2EntityDaoImpl topicEntityDao = new Topic2EntityDaoImpl();
        for (int i=0;i<ll.size();i++) {
            String name = ll.get(i).substring(0,ll.get(i).length()-1);
            topicEntityDao.deleteTopic(name);
        }
        return topicEntityDao.getAllTopics();

    }

    @RequestMapping(value="/admin/getUser",method=RequestMethod.GET)
    @ResponseBody
    public List<UserEntity> getAllUsers() {
        UserEntityDao user = new UserEntityDaoImpl();
        return user.getAllUsers();

    }

    @RequestMapping(value="/admin/deleteUser",method=RequestMethod.POST)
    @ResponseBody
    public List<UserEntity> delSpecialUser(@RequestBody List<String> ll) {
        UserEntityDaoImpl userEntityDao = new UserEntityDaoImpl();
        for (int i=0;i<ll.size();i++) {
            String name = ll.get(i).substring(0,ll.get(i).length()-1);
            userEntityDao.deleteUser(name);
        }
        return userEntityDao.getAllUsers();

    }

}