package com.egobob.diploma.web.controller;

import com.egobob.diploma.domain.User;
import com.egobob.diploma.service.security.SecurityService;
import com.egobob.diploma.service.security.UserService;
import com.egobob.diploma.web.validator.UserValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

@Controller
public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    private SecurityService securityService;

    @Autowired
    private UserValidator userValidator;


    @GetMapping(value = "/users")
    public String listUsers(Model model){
        model.addAttribute("users", userService.listAll());
        return "users";
    }

    @RequestMapping("user/new")
    public String newUser(Model model){
        model.addAttribute("user", new User());
        return "user_form";
    }

    @PostMapping("user")
    public String saveUser(User user,
                           BindingResult bindingResult){

        userValidator.validate(user, bindingResult);

        if (bindingResult.hasErrors()) {
            return "user_form";
        }

        userService.save(user);

        return "redirect:/user/" + userService.findByUsername(user.getUsername()).getId();
    }

    @RequestMapping("user/{id}")
    public String showUser(@PathVariable Long id, Model model){
        model.addAttribute("user", userService.getById(id));
        return "user_show";
    }

    @RequestMapping("user/delete/{id}")
    public String delete(@PathVariable Long id){
        userService.delete(id);
        return "redirect:/users";
    }


}
