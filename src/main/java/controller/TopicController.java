package controller;

import dao.impl.TopicEntityDaoImpl;
import entities.TopicEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;

@Controller
public class TopicController {

    @RequestMapping(value = "/topic",method = RequestMethod.GET)
    public String topicPage(){
        return "topic";
    }

    @RequestMapping(value = "/topic/sort", method = RequestMethod.GET)
    @ResponseBody
    public List<TopicEntity> decTopic() {

        return TopicEntityDaoImpl.sortTopic();

    }

    @RequestMapping(value = "/topic/add", method = RequestMethod.POST)
    @ResponseBody
    public Map<String, Object> decTopic(String name) {
        System.out.println(name);
        Map<String, Object> result = new HashMap<String, Object>();
        TopicEntityDaoImpl topicEntityDao = new TopicEntityDaoImpl();
        boolean flag = topicEntityDao.addNewTopic(name);
        if(flag){
            result.put("result","ok");
        }else {
            result.put("result","fail");
        }
        return result;
    }



}
