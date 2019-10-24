package controller;

import Service.ServiceFactory;
import dao.UserEntityDao;
import dao.impl.UserEntityDaoImpl;
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
public class staffLoginController {
    ServiceFactory serviceFactory = new ServiceFactory();

    /**
     * Simply selects the home view to render by returning its name.
     *
     */



    @RequestMapping(value = "/staffLogin",method = RequestMethod.GET)
    public String staffPage(){
        return "staffLogin";
    }


    @RequestMapping(value= "/staffLogin",method = RequestMethod.POST)
    @ResponseBody
    public Map<String,Object> staffLogin(String username, String password){
        UserEntityDao userEntityDao = (UserEntityDao)serviceFactory.serviceFactory("UserEntityDao");
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
        else if(!userEntityDao.isStaff(username)){
            result.put("result","fail not staff");
        }
        else{
            if(userEntityDao.isUsercanlogin(username, password))
                result.put("result","SUCCESS");
            else
                result.put("result","Fail");

        }


        return result;
    }





}