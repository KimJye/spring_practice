package net.skhu.security_mvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
//아직 로그인 하지 않은 사용자를 위한 페이지를 구현한다.
public class GuestController {
    //로그인 하지 않은 사용자를 위한 첫 페이지 URL
    @RequestMapping({"/", "guest/index"})
    public String index() {
        return "guest/index";
    }

    // 로그인 페이지 URL
    @RequestMapping("guest/login")
    public String login() {
        return "guest/login";
    }

}
