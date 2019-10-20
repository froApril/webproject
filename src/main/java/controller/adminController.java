package controller;

import dao.Topic2EntityDao;
//import dao.TopicEntityDao;
import dao.impl.Topic2EntityDaoImpl;
//import dao.impl.TopicEntityDaoImpl;
import entities.Topic2Entity;
//import entities.TopicsEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

//import javax.annotation.Resource;
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
    //@Resource//(name="topicEntityDao")
    //private Topic2EntityDaoImpl topicEntityDao;
    /*@RequestMapping(value= "/addTopic",method = RequestMethod.POST)
    @ResponseBody
    public Map<String,Object> addNewTopic(String major, String id, String name){
        Topic2EntityDaoImpl topicEntityDao = new Topic2EntityDaoImpl();
        Topic2Entity topicEntity = new Topic2Entity();
        Map<String, Object> result = new HashMap<String, Object>();
        if(topicEntityDao.existTopic(name)){
            result.put("result","fail, course exist");
        }
        else{
            topicEntity.setMajor(major);
            topicEntity.setCourseId(id);
            topicEntity.setName(name);
            topicEntityDao.addNewTopic(topicEntity);
            result.put("result","SUCCESS");
        }
        return result;
    }*/

    /*@RequestMapping(value= "/adminController",method = RequestMethod.POST)
    @ResponseBody
    public String addNewTopic(@RequestParam("major") String major, @RequestParam("id")String id, @RequestParam("name")String name){
        Topic2EntityDaoImpl topicEntityDao = new Topic2EntityDaoImpl();
        Topic2Entity topicEntity = new Topic2Entity();
        if(topicEntityDao.existTopic(name)){
            return "fail";
        }
        else{
            topicEntity.setId(3);
            topicEntity.setMajor(major);
            topicEntity.setCourseId(id);
            topicEntity.setName(name);
            topicEntityDao.addNewTopic(topicEntity);
            return "success";
        }
    }*/

    @RequestMapping(value= "/addNewTopic", method = RequestMethod.POST)
    @ResponseBody
    public String addNewTopic(HttpServletRequest req){

        Topic2Entity topicEntity = new Topic2Entity();
        Topic2EntityDaoImpl topicEntityDao = new Topic2EntityDaoImpl();
        if(topicEntityDao.existTopic(req.getParameter("name"))){
            return "fail";
        }

        else{
            //topicEntity.setId(3);
            topicEntity.setMajor(req.getParameter("major"));
            topicEntity.setCourseId(req.getParameter("id"));
            topicEntity.setName(req.getParameter("name"));
            topicEntityDao.addNewTopic(topicEntity);
            return "success";
        }
    }


    @RequestMapping(value="/tpl",method=RequestMethod.GET)
    @ResponseBody
    public List<Topic2Entity> getAllTopics(){
        Topic2EntityDao topicEntityDao = new Topic2EntityDaoImpl();
        return topicEntityDao.getAllTopics();
    }




}