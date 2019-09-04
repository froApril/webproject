package controller;

import java.util.Locale;

import dao.impl.UserEntityDaoImpl;
import entities.UserEntity;
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

//        UserEntity test = new UserEntity();
//	    test.setUsername("1278007");
//	    test.setEmail("1");
//	    test.setPassword("asd");
//	    test.setNickname("asd");
//	    test.setGender("asd");
//	    test.setiSstaff(1);
//	    test.setPerDes("sad");
//	    test.setPhotoPro("asd");
//	    test.setContactIno("asd");
//	    user.addUser(test);
//        user.setNewnickname(test,"rrrrrrrrrrrrrrrrr");

//        UserEntity test1 = new UserEntity();
//	    test.setUsername("111");
//	    test.setEmail("123");
//	    test.setPassword("1231");
//	    test.setNickname("aaaaa");
//	    test.setGender("ddddd");
//	    test.setiSstaff(0);
//	    test.setPerDes("sssss");
//	    test.setPhotoPro("ssss");
//	    test.setContactIno("asaad");
//
//	    user.addUser(test1);



        UserEntity userEntity = user.getUserByName("xyf");
        if(userEntity==null){
            model.addAttribute("user", "null");
        }
        else{
            model.addAttribute("user", userEntity.getUsername());
        }

		return "home";
	}
	
}
