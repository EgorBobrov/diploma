package com.egobob.diploma.web.controller;

import com.egobob.diploma.service.document.DocumentService;
import com.egobob.diploma.service.project.ProjectService;
import com.egobob.diploma.service.user.UserService;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
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
    private final ProjectService projectService;
    private final DocumentService documentService;

    @RequestMapping(value = "reports")
    public String listReports() {
        return REPORTS_VIEW;
    }

    @RequestMapping("users_report_show")
    public String usersReport(Model model) {
        model.addAttribute("users", userService.listAll());
        return USERS_REPORT_SHOW_VIEW;
    }

    @RequestMapping("project_docs_report_form")
    public String projectDocsReport(Model model) {
        model.addAttribute("projects", projectService.listAll());
        model.addAttribute("input", new ProjectDocsReportInput());
        return PROJECT_DOCS_REPORT_FORM_VIEW;
    }

    @PostMapping("project_docs_report_form")
    public String projectDocsReportCreate(ProjectDocsReportInput report) {
        return "redirect:/project_docs_report_show/" + report.projectId;
    }

    @RequestMapping("project_docs_report_show/{projectId}")
    public String projectDocsReport(@PathVariable Long projectId, Model model) {
        model.addAttribute("project", projectService.getById(projectId));
        model.addAttribute("documents", documentService.listAllByProjectId(projectId));
        return PROJECT_DOCS_REPORT_SHOW_VIEW;
    }

    @Getter
    @Setter
    private static class ProjectDocsReportInput {
        private Long projectId;
    }

}
