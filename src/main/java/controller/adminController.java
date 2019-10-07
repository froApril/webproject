package controller;

import dao.impl.UserEntityDaoImpl;
import entities.UserEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.Map;

@Controller
public class adminController {

    @RequestMapping(value = "/HomePage",method = RequestMethod.GET)
    public String Home() {
        return "Homepage";
    }


}
