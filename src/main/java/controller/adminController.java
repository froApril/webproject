package controller;

import dao.impl.Topic2EntityDaoImpl;
import entities.Topic2Entity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.Map;

@Controller
public class adminController {

    @RequestMapping(value = "/addTopic",method = RequestMethod.GET)
    public String addTopicPage() {
        return "addTopic";
    }

    @RequestMapping(value = "/success",method = RequestMethod.GET)
    public String success() {
        return "success";
    }

    @RequestMapping(value = "/fail",method = RequestMethod.GET)
    public String fail() {
        return "fail";
    }

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

    @RequestMapping(value= "/addTopic",method = RequestMethod.POST)
    @ResponseBody
    public String addNewTopic(String major, String id, String name){
        Topic2EntityDaoImpl topicEntityDao = new Topic2EntityDaoImpl();
        Topic2Entity topicEntity = new Topic2Entity();


        if(topicEntityDao.existTopic(name)){
            return "fail";
        }

        else{
            topicEntity.setMajor(major);
            topicEntity.setCourseId(id);
            topicEntity.setName(name);
            topicEntityDao.addNewTopic(topicEntity);
            return "success";
        }


    }




}
