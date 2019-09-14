package controller;

import java.util.Locale;

//import dao.impl.TopicEntityDaoImpl;
import dao.impl.UserEntityDaoImpl;
//import entities.TopicEntity;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {

	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);

	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {
        UserEntityDaoImpl user = new UserEntityDaoImpl();
//        user.setNewnickname("1278007","qqq");
//        user.setNewphoto("1278007","photo");
//        user.setGender("1278007","0");
//        user.setContactInfo("1278007","@");
//        user.setDes("1278007","this");
//        user.deleteUser("ssqq1");

//
//        userEntity.setPassword("1111111111");
//        if(userEntity==null){
//            model.addAttribute("user", "null");
//        }
//        else{
//            model.addAttribute("user", userEntity.getUsername());
//        }

//        UserEntity test = new UserEntity();
//        test.setUsername("ssqq1");
//        test.setEmail("1");
//        test.setPassword("asd");
//        test.setNickname("asd");
//        test.setGender("asd");
//        test.setiSstaff(1);
//        test.setPerDes("sad");
//        test.setPhotoPro("asd");
//        test.setContactIno("asd");
//        user.addUser(test);



        return "login";
	}

    @RequestMapping(value = "/", method = RequestMethod.POST)
    public String home1(Locale locale, Model model) {

        return "login";
    }


//    @RequestMapping(value="/test", method = RequestMethod.GET)
//    @ResponseBody
//    public TopicEntity test(String topic){
//        TopicEntityDao topicEntityDao = new TopicEntityDaoImpl();
//        if(topicEntityDao.updateTopic("12334","newname1")){
//            System.out.println("ok");
//        }
//
//        return topicEntityDao.getTopicByName("newname1");
//    }

    @RequestMapping(value = "/test1",method = RequestMethod.GET)
    public String test1(){
	    return "test";
    }








}




