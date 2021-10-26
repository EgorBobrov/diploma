package com.egobob.diploma.web.controller;

import com.egobob.diploma.domain.project.Project;
import com.egobob.diploma.service.client.ClientService;
import com.egobob.diploma.service.project.ProjectService;
import com.egobob.diploma.web.validator.ProjectValidator;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

import static com.egobob.diploma.web.controller.ControllerUtils.*;

@Controller
@RequiredArgsConstructor
public class ProjectController {

    private final ProjectService projectService;
    private final ClientService clientService;
    private final ProjectValidator projectValidator;

    @RequestMapping("project/new")
    public String newEntity(Model model) {
        model.addAttribute("project", new Project());
        model.addAttribute("clients", clientService.listAll());
        return PROJECT_FORM_VIEW;
    }

    @PostMapping("project")
    public String saveEntity(Model model, Project project,
                             BindingResult bindingResult) {
        projectValidator.validate(project, bindingResult);

        if (bindingResult.hasErrors()) {
            model.addAttribute("clients", clientService.listAll());
            return PROJECT_FORM_VIEW;
        }

        projectService.saveOrUpdate(project);
        return "redirect:/project/" + project.getId();
    }

    @RequestMapping("project/{id}")
    public String showEntity(@PathVariable Long id, Model model) {
        model.addAttribute("project", projectService.getById(id));
        return PROJECT_SHOW_VIEW;
    }

    @GetMapping(value = "/projects")
    public String list(Model model) {
        model.addAttribute("clients", clientService.listAll());
        model.addAttribute("projects", projectService.listAll());
        return PROJECTS_VIEW;
    }

    @GetMapping(value = "/projects/{clientId}")
    public String listProjectsByClientId(@PathVariable Long clientId, Model model) {
        model.addAttribute("clients", List.of(clientService.getById(clientId)));
        model.addAttribute("projects", projectService.listAllByClientId(clientId));
        return PROJECTS_VIEW;
    }

    @RequestMapping("project/edit/{id}")
    public String edit(@PathVariable Long id, Model model) {
        model.addAttribute("clients", clientService.listAll());
        model.addAttribute("project", projectService.getById(id));
        return PROJECT_FORM_VIEW;
    }

    @RequestMapping("project/delete/{id}")
    public String delete(@PathVariable Long id) {
        projectService.delete(id);
        return "redirect:/projects";
    }
}
