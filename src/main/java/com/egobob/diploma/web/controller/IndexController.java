package com.egobob.diploma.web.controller;

import com.egobob.diploma.domain.Client;
import com.egobob.diploma.domain.User;
import com.egobob.diploma.service.client.ClientService;
import com.egobob.diploma.service.security.SecurityService;
import com.egobob.diploma.service.security.UserService;
import com.egobob.diploma.web.UserValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

@Controller
public class IndexController {

    @Autowired
    private UserService userService;

    @Autowired
    private SecurityService securityService;

    @Autowired
    private UserValidator userValidator;

    @RequestMapping({"/", "/welcome"})
    String index(Model model) {
        return "index";
    }

    @RequestMapping("/login")
    public String login(Model model, String error, String logout){
        if (securityService.isAuthenticated()) {
            return "redirect:/";
        }

        if (error != null)
            model.addAttribute("error", "Your username and password is invalid.");

        if (logout != null)
            model.addAttribute("message", "You have been logged out successfully.");

        return "login";
    }

    @GetMapping("/registration")
    public String registration(Model model) {
        if (securityService.isAuthenticated()) {
            return "redirect:/";
        }

        model.addAttribute("userForm", new User());

        return "registration";
    }

    @PostMapping("/registration")
    public String registration(@ModelAttribute("userForm") User userForm,
                               BindingResult bindingResult) {
        userValidator.validate(userForm, bindingResult);

        if (bindingResult.hasErrors()) {
            return "registration";
        }

        userService.save(userForm);

        securityService.autoLogin(userForm.getUsername(), userForm.getConfirmedPassword());

        return "redirect:/welcome";
    }

}
