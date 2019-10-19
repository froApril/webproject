package controller;


import dao.TopicEntityDao;
import dao.impl.TopicEntityDaoImpl;
import entities.TopicsEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class MainController {

    @RequestMapping(value = "/main",method = RequestMethod.GET)
    public String getMainPage(){
        return "main";
    }

    @RequestMapping(value="/main/allTopics",method=RequestMethod.GET)
    @ResponseBody
    public List<TopicsEntity> getAllTopics(){
        TopicEntityDao topicEntityDao = new TopicEntityDaoImpl();
        return topicEntityDao.getAllTopics();
    }

}
