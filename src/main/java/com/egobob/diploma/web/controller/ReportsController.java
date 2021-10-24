package com.egobob.diploma.web.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import static com.egobob.diploma.web.controller.ControllerUtils.*;

@Controller
@RequiredArgsConstructor
public class ReportsController {

    @RequestMapping(value = "reports")
    public String listReports() {
        return REPORTS_VIEW;
    }
}
