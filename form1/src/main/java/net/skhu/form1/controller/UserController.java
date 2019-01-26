package net.skhu.form1.controller;

import net.skhu.form1.model.UserRegistrationModel;
import net.skhu.form1.service.DepartmentService;
import net.skhu.form1.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;

@Controller
@RequestMapping("user")
public class UserController {

    @Autowired
    DepartmentService departmentService;
    @Autowired
    UserService userService;


    @GetMapping(value="register")
    public String register(Model model, UserRegistrationModel userModel){
        model.addAttribute("departments", departmentService.findAll());
        return "user/register";
    }

    @PostMapping(value="register")
    public String register(@Valid UserRegistrationModel userModel, BindingResult bindingResult, Model model){
        if(userService.hashErrors(userModel, bindingResult))
        {
            model.addAttribute("departments", departmentService.findAll());
            return "user/register";
        }
        userService.save(userModel);
        return "redirect:registerSuccess";
    }

    @GetMapping(value="registerSuccess")
    public String registerSuccess(){
        return "user/registerSuccess";
    }
}
