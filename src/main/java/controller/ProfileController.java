package controller;

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






}




