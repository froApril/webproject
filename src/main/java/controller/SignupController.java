package controller;

import Service.ServiceFactory;
import dao.UserEntityDao;
import dao.impl.UserEntityDaoImpl;
import entities.UserEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

//import dao.impl.TopicEntityDaoImpl;
//import entities.TopicEntity;

/**
 * Handles requests for the application home page.
 */
@Controller
public class SignupController {

    ServiceFactory serviceFactory = new ServiceFactory();

	/**
	 * Simply selects the home view to render by returning its name.
	 */

    @RequestMapping(value = "/login",method = RequestMethod.GET)
    public String Page(){
        return "login";
    }

    @RequestMapping(value= "/signup",method = RequestMethod.POST)
    @ResponseBody
    public Map<String,Object> signup(String username, String password, String email, String gen){
        UserEntityDao userEntityDao = (UserEntityDao)serviceFactory.serviceFactory("UserEntityDao");
        UserEntity userEntity = new UserEntity();
        Map<String, Object> result = new HashMap<String, Object>();

         if (username.isEmpty()){
            result.put("result","fail, no name");
        }

        else if(userEntityDao.isUsernameExist(username)){
            result.put("result","fail");
        }

        else if (password.isEmpty()){
            result.put("result","fail, no password exist");
        }
        else if (email.isEmpty()){
            result.put("result","fail, no email exist");
        }
        else{

             Random random = new Random(System.currentTimeMillis());
             int img = random.nextInt(5) + 1;
             String str="abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";

             StringBuffer sb = new StringBuffer();
             for(int i=0;i<5;i++){
                 int number=random.nextInt(62);
                 sb.append(str.charAt(number));
             }
             String nick = "UseR" + sb.toString();

            userEntity.setUsername(username);
            userEntity.setPassword(password);
            userEntity.setEmail(email);
            userEntity.setiSstaff(0);
            if(gen.equals("1"))
                userEntity.setGender("Male");
            if(gen.equals("2"))
                userEntity.setGender("Female");
            if(gen.equals("0"))
                userEntity.setGender("Secret");
            userEntity.setPhotoPro(Integer.toString(img));
            userEntity.setNickname(nick);
            userEntity.setContactIno(email);
            userEntity.setPerDes("Here for personal Description");
            userEntityDao.addUser(userEntity);
            result.put("result","SUCCESS");
        }

        result.put("id",userEntityDao.getUserByName(username).getId());
        return result;
    }





}




