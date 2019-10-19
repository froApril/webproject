package controller;

import java.util.HashMap;
import java.util.Locale;
import java.util.Map;


import dao.TopicEntityDao;
import dao.impl.TopicEntityDaoImpl;
import entities.TopicsEntity;
import entities.TopicsEntity;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;

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
        return "login";
	}

    @RequestMapping(value = "/", method = RequestMethod.POST)
    public String home1(Locale locale, Model model) {

        return "login";
    }

}




