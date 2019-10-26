package controller;

import Service.ServiceFactory;
import dao.*;
import dao.TopicEntityDao;
import dao.impl.CommentEntityImpl;
import dao.impl.TopicEntityDaoImpl;
import dao.impl.UserEntityDaoImpl;
import entities.TopicsEntity;
import entities.UserEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

//BingKun Miao
@Controller
public class adminController {

    ServiceFactory serviceFactory = new ServiceFactory();

    @RequestMapping(value = "/addTopic",method = RequestMethod.GET)
    public String getStaffPage(){
        return "addTopic";
    }

    @RequestMapping(value= "/admin/addTopic", method = RequestMethod.POST)
    @ResponseBody
    public Map<String,Object> addNewTopic(String topicName, String topicDescription) {
        Map<String, Object> result = new HashMap<String, Object>();
        TopicsEntity topicEntity = new TopicsEntity();
        TopicEntityDao topicEntityDao = (TopicEntityDao) serviceFactory.serviceFactory("TopicEntityDao");
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

    @RequestMapping(value="/admin/getTopic",method=RequestMethod.GET)
    @ResponseBody
    public List<TopicsEntity> getAllTopic() {
        TopicEntityDao topicEntityDao = (TopicEntityDao) serviceFactory.serviceFactory("TopicEntityDao");
        return topicEntityDao.getAllTopics();

    }

    @RequestMapping(value="/admin/deleteTopic",method=RequestMethod.POST)
    @ResponseBody
    public List<TopicsEntity> delSpecialTopic(@RequestBody List<String> ll) {
        TopicEntityDao topicEntityDao = (TopicEntityDao) serviceFactory.serviceFactory("TopicEntityDao");
        CommentEntityDao comment = (CommentEntityDao) serviceFactory.serviceFactory("CommentEntityDao");
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
        UserEntityDao user = (UserEntityDao) serviceFactory.serviceFactory("UserEntityDao");
        return user.getAllUsers();

    }

    @RequestMapping(value="/admin/deleteUser",method=RequestMethod.POST)
    @ResponseBody
    public List<UserEntity> delSpecialUser(@RequestBody List<String> ll) {
        UserEntityDao userEntityDao = (UserEntityDao) serviceFactory.serviceFactory("UserEntityDao");
        CommentEntityDao comment = (CommentEntityDao) serviceFactory.serviceFactory("CommentEntityDao");
        for (int i=0;i<ll.size();i++) {
            String name = ll.get(i).substring(0,ll.get(i).length()-1);
            comment.deleteComment(userEntityDao.getUserByName(name).getUsername());
            userEntityDao.deleteUser(name);
        }
        return userEntityDao.getAllUsers();

    }

}