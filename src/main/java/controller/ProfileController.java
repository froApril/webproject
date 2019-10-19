package controller;

import dao.UserEntityDao;
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

    @RequestMapping(value= "/changePh",method = RequestMethod.POST)
    @ResponseBody
    public Map<String,Object> changePh(String username, String pCode){

        UserEntityDaoImpl userEntityDao = new UserEntityDaoImpl();

        Map<String, Object> result = new HashMap<String, Object>();

       if(userEntityDao.setNewphoto(username,pCode))
       {
           UserEntity userEntity = userEntityDao.getUserByName(username);
           result.put("userImg",userEntity.getPhotoPro());
           result.put("result","SUCCESS");
       }
       else
           result.put("result","Fail");


        return result;
    }

    @RequestMapping(value= "/changeN",method = RequestMethod.POST)
    @ResponseBody
    public Map<String,Object> changeN(String username, String nick){

        UserEntityDaoImpl userEntityDao = new UserEntityDaoImpl();

        Map<String, Object> result = new HashMap<String, Object>();

        if(userEntityDao.setNewnickname(username,nick))
        {
            UserEntity userEntity = userEntityDao.getUserByName(username);
            result.put("userN",userEntity.getNickname());
            result.put("result","SUCCESS");
        }


        return result;
    }

    @RequestMapping(value= "/oldPas",method = RequestMethod.POST)
    @ResponseBody
    public Map<String,Object> oldPas(String username, String ps){

        UserEntityDaoImpl userEntityDao = new UserEntityDaoImpl();
        UserEntity userEntity = userEntityDao.getUserByName(username);
        Map<String, Object> result = new HashMap<String, Object>();

        if(userEntity.getPassword().equals(ps))
        {
            result.put("result","SUCCESS");
        }


        return result;
    }
    @RequestMapping(value= "/newPas",method = RequestMethod.POST)
    @ResponseBody
    public Map<String,Object> newPas(String username, String ps){

        UserEntityDaoImpl userEntityDao = new UserEntityDaoImpl();
        Map<String, Object> result = new HashMap<String, Object>();

        if(userEntityDao.setNewpassword(username,ps))
        {
            result.put("result","SUCCESS");
        }


        return result;
    }




    @RequestMapping(value= "/changeC",method = RequestMethod.GET)
    @ResponseBody
    public Map<String,Object> newC(String username, String contactI){

        UserEntityDaoImpl userEntityDao = new UserEntityDaoImpl();
        UserEntity userEntity = userEntityDao.getUserByName(username);
        Map<String, Object> result = new HashMap<String, Object>();

        if(userEntityDao.setContactInfo(username,contactI))
        {
            result.put("userCon",userEntity.getContactIno());
            result.put("result","SUCCESS");
        }


        return result;
    }


    @RequestMapping(value= "/changePre",method = RequestMethod.GET)
    @ResponseBody
    public Map<String,Object> newPre(String username, String pre){

        UserEntityDaoImpl userEntityDao = new UserEntityDaoImpl();
        UserEntity userEntity = userEntityDao.getUserByName(username);
        Map<String, Object> result = new HashMap<String, Object>();

        if(userEntityDao.setDes(username,pre))
        {
            result.put("userPre",userEntity.getPerDes());
            result.put("result","SUCCESS");
        }


        return result;
    }

    @RequestMapping(value="/getNickname",method = RequestMethod.GET)
    @ResponseBody
    public UserEntity getNickname(String username){
        UserEntityDao userEntityDao = new UserEntityDaoImpl();
        return userEntityDao.getUserByName(username);

    }


}




