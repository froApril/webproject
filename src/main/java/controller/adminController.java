package controller;

import dao.*;
import dao.TopicEntityDao;
import dao.impl.CommentEntityImpl;
import dao.impl.Topic2EntityDaoImpl;
import dao.impl.TopicEntityDaoImpl;
import dao.impl.UserEntityDaoImpl;
import entities.Topic2Entity;
import entities.TopicsEntity;
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

    @RequestMapping(value = "/addTopic",method = RequestMethod.GET)
    public String getStaffPage(){
        return "addTopic";
    }

    @RequestMapping(value= "/addNewTopic", method = RequestMethod.POST)
    //@ResponseBody
    public String addNewTopic(HttpServletRequest req) {
    //public Map<String,Object> addNewTopic(String topicName, String topicDescription) {


        TopicsEntity topicEntity = new TopicsEntity();
        TopicEntityDaoImpl topicEntityDao = new TopicEntityDaoImpl();
        if(topicEntityDao.existTopic(req.getParameter("topicName"))) {
            return "fail";
        }

        else {
            topicEntity.setTopicName(req.getParameter("topicName"));
            topicEntity.setCommentNum(0);
            topicEntity.setTopicDescription(req.getParameter("topicDescription"));
            topicEntityDao.addNewTopic(topicEntity);
            return "success";
        }
        /*Map<String, Object> result = new HashMap<String, Object>();
        TopicsEntity topicEntity = new TopicsEntity();
        TopicEntityDaoImpl topicEntityDao = new TopicEntityDaoImpl();
        if (topicEntityDao.existTopic(topicName)) {
            result.put("result","success");
        }
        else {
            topicEntity.setTopicName(topicName);
            topicEntity.setCommentNum(0);
            topicEntity.setTopicDescription(topicDescription);
            topicEntityDao.addNewTopic(topicEntity);
            result.put("result","fail");
        }
        return result;*/

    }

    @RequestMapping(value= "/admin/addTopic", method = RequestMethod.POST)
    @ResponseBody
    public Map<String,Object> addNewTopic(String topicName, String topicDescription) {
        Map<String, Object> result = new HashMap<String, Object>();
        TopicsEntity topicEntity = new TopicsEntity();
        TopicEntityDaoImpl topicEntityDao = new TopicEntityDaoImpl();
        if (topicEntityDao.existTopic(topicName)) {
            result.put("result","fail");
        }
        else {
            topicEntity.setTopicName(topicName);
            topicEntity.setCommentNum(0);
            topicEntity.setTopicDescription(topicDescription);
            topicEntityDao.addNewTopic(topicEntity);
            result.put("result","success");
        }
        return result;
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

    @RequestMapping(value="/admin/getTopic",method=RequestMethod.GET)
    @ResponseBody
    public List<TopicsEntity> getAllTopic() {
        TopicEntityDao topicEntityDao = new TopicEntityDaoImpl();
        return topicEntityDao.getAllTopics();

    }

    @RequestMapping(value="/admin/deleteTopic",method=RequestMethod.POST)
    @ResponseBody
    public List<TopicsEntity> delSpecialTopic(@RequestBody List<String> ll) {
        TopicEntityDaoImpl topicEntityDao = new TopicEntityDaoImpl();
        CommentEntityDao comment = new CommentEntityImpl();
        for (int i=0;i<ll.size();i++) {
            String name = ll.get(i).substring(0,ll.get(i).length()-1);
            comment.deleteComment(topicEntityDao.getTopicByName(name).getId());
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
        CommentEntityDao comment = new CommentEntityImpl();
        for (int i=0;i<ll.size();i++) {
            String name = ll.get(i).substring(0,ll.get(i).length()-1);
            comment.deleteComment(userEntityDao.getUserByName(name).getUsername());
            userEntityDao.deleteUser(name);
        }
        return userEntityDao.getAllUsers();

    }

}