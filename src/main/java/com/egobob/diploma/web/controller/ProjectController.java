package com.egobob.diploma.web.controller;

import com.egobob.diploma.domain.project.Project;
import com.egobob.diploma.service.client.ClientService;
import com.egobob.diploma.service.project.ProjectService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import static com.egobob.diploma.web.controller.ControllerUtils.*;

@Controller
@RequiredArgsConstructor
public class ProjectController implements BaseEntityController<Project> {

    private final ProjectService projectService;
    private final ClientService clientService;

    @Override
    @RequestMapping("project/new")
    public String newEntity(Model model) {
        model.addAttribute("project", new Project());
        model.addAttribute("clients", clientService.listAll());
        return PROJECT_FORM_VIEW;
    }

    @Override
    @PostMapping("project")
    public String saveEntity(Project project) {
        projectService.saveOrUpdate(project);
        return "redirect:/project/" + project.getId();
    }

    @Override
    @RequestMapping("project/{id}")
    public String showEntity(@PathVariable Long id, Model model) {
        model.addAttribute("project", projectService.getById(id));
        return PROJECT_SHOW_VIEW;
    }

    @Override
    @GetMapping(value = "/projects")
    public String list(Model model) {
        model.addAttribute("clients", clientService.listAll());
        model.addAttribute("projects", projectService.listAll());
        return PROJECTS_VIEW;
    }

    @Override
    @RequestMapping("project/edit/{id}")
    public String edit(@PathVariable Long id, Model model) {
        model.addAttribute("clients", clientService.listAll());
        model.addAttribute("project", projectService.getById(id));
        return PROJECT_FORM_VIEW;
    }

    @Override
    @RequestMapping("project/delete/{id}")
    public String delete(@PathVariable Long id) {
        projectService.delete(id);
        return "redirect:/projects";
    }
}
