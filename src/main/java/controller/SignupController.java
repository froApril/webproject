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
public class SignupController {


	/**
	 * Simply selects the home view to render by returning its name.
	 */


    @RequestMapping(value= "/signup",method = RequestMethod.POST)
    @ResponseBody
    public Map<String,Object> signup(String username, String password, String email){
        UserEntityDaoImpl userEntityDao = new UserEntityDaoImpl();
        UserEntity userEntity = new UserEntity();
        Map<String, Object> result = new HashMap<String, Object>();

         if (username == null){
            result.put("result","fail, no name");
        }

        else if(userEntityDao.isUsernameExist(username)){
            result.put("result","fail, name exist");
        }

        else if (password == null){
            result.put("result","fail, no password exist");
        }
        else if (email ==null){
            result.put("result","fail, no email exist");
        }
        else{
            userEntity.setUsername(username);
            userEntity.setPassword(password);
            userEntity.setEmail(email);
            userEntityDao.addUser(userEntity);
            result.put("result","SUCCESS");
        }


        return result;
    }





}




