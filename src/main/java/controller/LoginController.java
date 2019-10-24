package controller;

import Service.ServiceFactory;
import dao.TopicEntityDao;
import dao.UserEntityDao;
import dao.impl.TopicEntityDaoImpl;
import dao.impl.UserEntityDaoImpl;
import entities.TopicsEntity;
import entities.UserEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.Map;

//import dao.impl.TopicEntityDaoImpl;
//import entities.TopicEntity;

/**
 * Handles requests for the application home page.
 */
@Controller
public class LoginController {

    ServiceFactory serviceFactory = new ServiceFactory();

	/**
	 * Simply selects the home view to render by returning its name.
	 */

    @RequestMapping(value = "/HomePage",method = RequestMethod.GET)
    public String Home(){
        return "Homepage";
    }

    @RequestMapping(value = "/signup",method = RequestMethod.GET)
    public String Page(){
        return "signup";
    }

    @RequestMapping(value = "/logout",method = RequestMethod.GET)
    public String logout(){
        return "login";
    }

    @RequestMapping(value= "/login",method = RequestMethod.POST)
    @ResponseBody
    public Map<String,Object> login(String username, String password){
        UserEntityDao userEntityDao = (UserEntityDao) serviceFactory.serviceFactory("UserEntityDao");
        Map<String, Object> result = new HashMap<String, Object>();
        if (username == null){
            result.put("result","fail, no name");
        }
        else if(!userEntityDao.isUsernameExist(username)){
            result.put("result","fail no stored name");
        }
        else if (password == null){
            result.put("result","fail, no password exist");
        }
        else{
           if(userEntityDao.isUsercanlogin(username, password))
               result.put("result","SUCCESS");
           else
               result.put("result","Fail");


        }

       
        return result;
    }


    @RequestMapping(value= "/getT",method = RequestMethod.GET)
    @ResponseBody
    public Map<String,Object> getTopic(String topic){
        TopicEntityDao topicEntityDao = (TopicEntityDao) serviceFactory.serviceFactory("TopicEntityDao");
        Map<String, Object> result = new HashMap<String, Object>();
        String st = topic.replaceAll(" ","");
        st.toUpperCase();

        TopicsEntity topicsEntity = topicEntityDao.getTopicByName(st);

       if(topicsEntity == null)
           result.put("result","fail");
       else{
           result.put("link","/comments?topic=" + topicsEntity.getTopicName());
           result.put("result","SUCCESS");
       }

        return result;
    }



}




