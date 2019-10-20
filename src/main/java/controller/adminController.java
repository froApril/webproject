package controller;

import dao.impl.Topic2EntityDaoImpl;
import entities.Topic2Entity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
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

    @RequestMapping(value = "/aha", method = RequestMethod.GET)
    @ResponseBody
    public String ahaha(HttpServletRequest req) {
        return "success";
    }

    @RequestMapping(value="/ji1")
    public void Ajax(HttpServletResponse resp) throws IOException {
        resp.getWriter().write("hello  ajax");
    }

    //方式二  通过流的形式
    @RequestMapping(value="/ji2")
    public void Ajax1(Writer out) throws IOException{
        out.write("hello ajax1");
    }

    //方三  通过注解的形式
    @RequestMapping(value="/ji3")
    @ResponseBody  //返回值就是响应的内容
    public String Ajax2() throws IOException{
        return "fail";
    }


    /*public List<Topic2Entity> getTopics() {
        List<Topic2Entity> topicList = new ArrayList<Topic2Entity>();
        Topic2Entity t1 = new Topic2Entity();
        Topic2Entity t2 = new Topic2Entity();
        Topic2Entity t3 = new Topic2Entity();
        t1.setId(11);
        t2.setId(12);
        t3.setId(13);
        t1.setName("t1");
        t2.setName("t2");
        t3.setName("t3");
        t1.setCourseId("t1");
        t2.setCourseId("t2");
        t3.setCourseId("t3");
        t1.setMajor("t1");
        t2.setMajor("t2");
        t3.setMajor("t3");
        topicList.add(t1);
        topicList.add(t2);
        topicList.add(t3);
        return topicList;
    }*/





}
