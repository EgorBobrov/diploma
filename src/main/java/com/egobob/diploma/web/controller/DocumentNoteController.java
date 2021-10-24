package com.egobob.diploma.web.controller;

import com.egobob.diploma.domain.document.DocumentNote;
import com.egobob.diploma.service.document.DocumentNoteService;
import com.egobob.diploma.service.document.DocumentService;
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
public class DocumentNoteController {

    private final DocumentNoteService noteService;
    private final DocumentService documentService;

    @RequestMapping("note/new/{documentId}")
    public String newEntity(@PathVariable Long documentId, Model model) {
        model.addAttribute("note", new DocumentNote());
        model.addAttribute("documentId", documentId);
        return NOTE_FORM_VIEW;
    }


    @PostMapping("note/{documentId}")
    public String saveEntity(@PathVariable Long documentId, DocumentNote toSave) {
        toSave.setDocument(documentService.getById(documentId));
        noteService.saveOrUpdate(toSave);
        return "redirect:/note/" + toSave.getId();
    }

    @RequestMapping("note/{id}")
    public String showEntity(@PathVariable Long id, Model model) {
        model.addAttribute("note", noteService.getById(id));
        return NOTE_SHOW_VIEW;
    }

    @GetMapping(value = "/notes/{documentId}")
    public String listNotesByDocumentId(@PathVariable Long documentId, Model model) {
        model.addAttribute("notes", noteService.listAllByDocumentId(documentId));
        return NOTES_VIEW;
    }

    @RequestMapping("note/edit/{id}")
    public String edit(@PathVariable Long id, Model model) {
        model.addAttribute("note", noteService.getById(id));
        return NOTE_FORM_VIEW;
    }

    @RequestMapping("note/delete/{id}")
    public String delete(@PathVariable Long id) {
        noteService.delete(id);
        return "redirect:/notes";
    }
}
