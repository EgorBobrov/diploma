package com.egobob.diploma.web.controller;

import com.egobob.diploma.domain.project.Project;
import com.egobob.diploma.service.user.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import static com.egobob.diploma.web.controller.ControllerUtils.*;

@Controller
@RequiredArgsConstructor
public class ReportsController {

    private final UserService userService;

    @RequestMapping(value = "reports")
    public String listReports() {
        return REPORTS_VIEW;
    }

    @RequestMapping("users_report_show")
    public String usersReport(Model model) {
        model.addAttribute("users", userService.listAll());
        return USERS_REPORT_SHOW_VIEW;
    }


}
