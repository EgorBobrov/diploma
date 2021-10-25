package com.egobob.diploma.web.controller;


import com.egobob.diploma.service.document.DocumentService;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import static com.egobob.diploma.web.controller.ControllerUtils.*;

@Controller
@RequiredArgsConstructor
public class SearchController {

    private final DocumentService documentService;

    @RequestMapping(value = "search")
    public String searchPage(Model model) {
        model.addAttribute("documents", documentService.listAll());
        model.addAttribute("query", new SearchQuery());
        return SEARCH_PAGE;
    }

    @PostMapping("search")
    public String findDocumentsByName(SearchQuery searchQuery) {
        return "redirect:/search_result?queryText=" + searchQuery.queryText;
    }

    @RequestMapping("search_result")
    public String searchResult(@RequestParam String queryText, Model model) {
        model.addAttribute("documents", documentService.findByTitle(queryText));
        return SEARCH_RESULT;
    }

    @Getter
    @Setter
    private static class SearchQuery {
        private String queryText;
    }

}
