package com.egobob.diploma.web.controller;

import com.egobob.diploma.domain.user.User;
import com.egobob.diploma.service.security.SecurityService;
import com.egobob.diploma.service.user.UserService;
import com.egobob.diploma.web.validator.UserValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import static com.egobob.diploma.web.controller.ControllerUtils.*;

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
        return USERS_VIEW;
    }

    @RequestMapping("user/new")
    public String newUser(Model model){
        model.addAttribute("user", new User());
        return USER_FORM_VIEW;
    }

    @PostMapping("user")
    public String saveUser(User user,
                           BindingResult bindingResult){

        userValidator.validate(user, bindingResult);

        if (bindingResult.hasErrors()) {
            return USER_FORM_VIEW;
        }

        userService.save(user);

        return "redirect:/user/" + userService.findByUsername(user.getUsername()).getId();
    }

    @RequestMapping("user/{id}")
    public String showUser(@PathVariable Long id, Model model){
        model.addAttribute("user", userService.getById(id));
        return USER_SHOW_VIEW;
    }

    @RequestMapping("user/delete/{id}")
    public String delete(@PathVariable Long id){
        userService.delete(id);
        return "redirect:/users";
    }


}
