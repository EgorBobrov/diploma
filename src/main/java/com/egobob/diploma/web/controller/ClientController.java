package com.egobob.diploma.web.controller;

import com.egobob.diploma.domain.client.Client;
import com.egobob.diploma.service.client.ClientService;
import com.egobob.diploma.web.validator.ClientValidator;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
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
public class ClientController {

    private final ClientService clientService;
    private final ClientValidator clientValidator;

    @RequestMapping("client/new")
    public String newEntity(Model model){
        model.addAttribute("client", new Client());
        return CLIENT_FORM_VIEW;
    }

    @PostMapping("client")
    public String saveEntity(Client client,
                             BindingResult bindingResult) {
        clientValidator.validate(client, bindingResult);

        if (bindingResult.hasErrors()) {
            return CLIENT_FORM_VIEW;
        }

        clientService.saveOrUpdate(client);
        return "redirect:/client/" + client.getId();
    }

    @RequestMapping("client/{id}")
    public String showEntity(@PathVariable Long id, Model model){
        model.addAttribute("client", clientService.getById(id));
        return CLIENT_SHOW_VIEW;
    }

    @GetMapping(value = "/clients")
    public String list(Model model){
        model.addAttribute("clients", clientService.listAll());
        return CLIENTS_VIEW;
    }

    @RequestMapping("client/edit/{id}")
    public String edit(@PathVariable Long id, Model model){
        model.addAttribute("client", clientService.getById(id));
        return CLIENT_FORM_VIEW;
    }

    @RequestMapping("client/delete/{id}")
    public String delete(@PathVariable Long id){
        clientService.delete(id);
        return "redirect:/clients";
    }

}
