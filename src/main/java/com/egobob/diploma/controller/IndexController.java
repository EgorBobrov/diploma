package com.egobob.diploma.controller;

import com.egobob.diploma.domain.Client;
import com.egobob.diploma.service.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class IndexController {

    @Autowired
    private ClientService clientService;

    @RequestMapping("/")
    String index() {
        return "index";
    }

    @RequestMapping("client/new")
    public String newClient(Model model){
        model.addAttribute("client", new Client());
        return "client_form";
    }

    @PostMapping("client")
    public String saveClient(Client client){
        clientService.saveClient(client);
        return "redirect:/client/" + client.getId();
    }

    @RequestMapping("client/{id}")
    public String showClient(@PathVariable Long id, Model model){
        model.addAttribute("client", clientService.getClientById(id));
        return "client_show";
    }

    @GetMapping(value = "/clients")
    public String list(Model model){
        model.addAttribute("clients", clientService.listAllClients());
        return "clients";
    }

    @RequestMapping("client/edit/{id}")
    public String edit(@PathVariable Long id, Model model){
        model.addAttribute("client", clientService.getClientById(id));
        return "client_form";
    }

    @RequestMapping("client/delete/{id}")
    public String delete(@PathVariable Long id){
        clientService.deleteClient(id);
        return "redirect:/products";
    }

}
