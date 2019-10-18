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
public class ProfileController {


	/**
	 * Simply selects the home view to render by returning its name.
	 */
//
//    @RequestMapping(value="/test",method = RequestMethod.GET)
//    public String loginsuccess(){
//        return "homepage";
//    }
    @RequestMapping(value = "/profile",method = RequestMethod.GET)
    public String profile(){
        return "profile";
    }

    @RequestMapping(value= "/getProfile",method = RequestMethod.POST)
    @ResponseBody
    public Map<String,Object> getPro(String username){

        UserEntityDaoImpl userEntityDao = new UserEntityDaoImpl();
        UserEntity userEntity = userEntityDao.getUserByName(username);
        Map<String, Object> result = new HashMap<String, Object>();

        result.put("username",userEntity.getUsername());
        result.put("userN",userEntity.getNickname());
        result.put("userImg",userEntity.getPhotoPro());
        result.put("userGen",userEntity.getGender());
        result.put("userCon",userEntity.getContactIno());
        result.put("userPre",userEntity.getPerDes());
        result.put("userPs",userEntity.getPassword());
        result.put("result","SUCCESS");

        return result;
    }







}




