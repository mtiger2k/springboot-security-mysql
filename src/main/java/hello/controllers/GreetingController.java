package hello.controllers;

import hello.domain.SUser;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
public class GreetingController {


    @RequestMapping("/home")
    public String home() {
        return "home";
    }

    @RequestMapping("/hello")
    public String hello() {
        SecurityContext ctx   =   SecurityContextHolder.getContext();
        Authentication auth   =   ctx.getAuthentication();
        if(auth.getPrincipal()   instanceof UserDetails)
        {
            SUser user   =   (SUser)auth.getPrincipal();
            System.out.println(user.getEmail());
        }
        //本段代码演示如何获取登录的用户资料

        return "hello";
    }

    @RequestMapping("/")
    public String root() {
        //如不进行此项配置，从login登录成功后，会提示找不网页
        return "index";
    }



}
