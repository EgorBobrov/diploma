package com.egobob.diploma.web.controller;

import com.egobob.diploma.service.security.SecurityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class IndexController {

    @Autowired
    private SecurityService securityService;

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
            model.addAttribute("error", "Неверное имя пользователя или пароль.");

        if (logout != null)
            model.addAttribute("message", "Вы успешно вышли из своего аккаунта.");

        return "login";
    }


}
