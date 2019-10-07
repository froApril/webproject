package controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller // @Controller 代表本Java类是controller控制层
public class llg {


    @RequestMapping("/llg") // @RequestMapping 注解可以用指定的URL路径访问本控制层
    public String login(@RequestParam("username") String username, @RequestParam("password") String password
                        ) {

        if (username.equals("admin") && password.equals("admin")) {

            return "ok";
        } else {

            return "no";
        }
    }

}
