package usyd.elec5619.controller;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import java.util.logging.Logger;

public class MainController implements Controller {
    private static Log logger = LogFactory.getLog(MainController.class);

    @Override
    public ModelAndView handleRequest(javax.servlet.http.HttpServletRequest httpServletRequest, javax.servlet.http.HttpServletResponse httpServletResponse) throws Exception {
        logger.info("1231");
        ModelAndView mv  = new ModelAndView();
        mv.addObject("message","hello");
        mv.setViewName("/WEB-INF/content/welcome.jsp");
        return mv;
    }
}
