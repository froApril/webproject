package controller;

import dao.impl.UserEntityDaoImpl;
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


	/**
	 * Simply selects the home view to render by returning its name.
	 */
//
//    @RequestMapping(value="/test",method = RequestMethod.GET)
//    public String loginsuccess(){
//        return "homepage";
//    }
    @RequestMapping(value = "/HomePage",method = RequestMethod.GET)
    public String staffHome(){
        return "Homepage";
    }

    @RequestMapping(value = "/login",method = RequestMethod.GET)
    public String staffPage(){
        return "login";
    }

    @RequestMapping(value= "/login",method = RequestMethod.POST)
    @ResponseBody
    public Map<String,Object> login(String username, String password){
        UserEntityDaoImpl userEntityDao = new UserEntityDaoImpl();
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





}




