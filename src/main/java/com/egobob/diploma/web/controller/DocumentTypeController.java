package com.egobob.diploma.web.controller;

import com.egobob.diploma.domain.document.DocumentType;
import com.egobob.diploma.service.document.DocumentTypeService;
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
public class DocumentTypeController implements BaseEntityController<DocumentType> {

    private final DocumentTypeService typeService;

    @Override
    @RequestMapping("doctype/new")
    public String newEntity(Model model) {
        model.addAttribute("doctype", new DocumentType());
        return DOCUMENT_TYPE_FORM_VIEW;
    }

    @Override
    @PostMapping("doctype")
    public String saveEntity(DocumentType toSave) {
        typeService.saveOrUpdate(toSave);
        return "redirect:/doctype/" + toSave.getId();
    }

    @Override
    @RequestMapping("doctype/{id}")
    public String showEntity(@PathVariable Long id, Model model) {
        model.addAttribute("doctype", typeService.getById(id));
        return DOCUMENT_TYPE_SHOW_VIEW;
    }

    @Override
    @GetMapping(value = "/doctypes")
    public String list(Model model) {
        model.addAttribute("doctypes", typeService.listAll());
        return DOCUMENT_TYPES_VIEW;
    }

    @Override
    @RequestMapping("doctype/edit/{id}")
    public String edit(@PathVariable Long id, Model model) {
        model.addAttribute("doctype", typeService.getById(id));
        return DOCUMENT_TYPE_FORM_VIEW;
    }

    @Override
    @RequestMapping("doctype/delete/{id}")
    public String delete(@PathVariable Long id) {
        typeService.delete(id);
        return "redirect:/doctypes";
    }
}
