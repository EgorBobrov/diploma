package com.egobob.diploma.web.controller;

import com.egobob.diploma.domain.document.Document;
import com.egobob.diploma.service.document.DocumentService;
import com.egobob.diploma.service.document.DocumentTypeService;
import com.egobob.diploma.service.project.ProjectService;
import com.egobob.diploma.web.validator.DocumentValidator;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import static com.egobob.diploma.web.controller.ControllerUtils.*;

@Controller
@RequiredArgsConstructor
public class DocumentController {

    private final DocumentService documentService;
    private final ProjectService projectService;
    private final DocumentTypeService typeService;
    private final DocumentValidator documentValidator;

    @RequestMapping("document/new")
    public String newEntity(Model model) {
        model.addAttribute("document", new Document());
        model.addAttribute("projects", projectService.listAll());
        model.addAttribute("types", typeService.listAll());
        return DOCUMENT_FORM_VIEW;
    }

    @PostMapping("document")
    public String saveEntity(Model model, Document toSave,
                             BindingResult bindingResult) {
        documentValidator.validate(toSave, bindingResult);

        if (bindingResult.hasErrors()) {
            model.addAttribute("projects", projectService.listAll());
            model.addAttribute("types", typeService.listAll());
            return DOCUMENT_FORM_VIEW;
        }

        documentService.saveOrUpdate(toSave);
        return "redirect:/document/" + toSave.getId();
    }

    @RequestMapping("document/{id}")
    public String showEntity(@PathVariable Long id, Model model) {
        model.addAttribute("document", documentService.getById(id));
        return DOCUMENT_SHOW_VIEW;
    }

    @GetMapping(value = "/documents")
    public String list(Model model) {
        model.addAttribute("documents", documentService.listAll());
        return DOCUMENTS_VIEW;
    }

    @GetMapping(value = "/documents/{doctypeId}")
    public String listProjectsByClientId(@PathVariable Long doctypeId, Model model) {
        model.addAttribute("documents", documentService.listAllByDoctypeId(doctypeId));
        return DOCUMENTS_VIEW;
    }

    @RequestMapping("document/edit/{id}")
    public String edit(@PathVariable Long id, Model model) {
        model.addAttribute("document", documentService.getById(id));
        model.addAttribute("projects", projectService.listAll());
        model.addAttribute("types", typeService.listAll());
        return DOCUMENT_FORM_VIEW;
    }

    @RequestMapping("document/delete/{id}")
    public String delete(@PathVariable Long id) {
        documentService.delete(id);
        return "redirect:/documents";
    }
}
