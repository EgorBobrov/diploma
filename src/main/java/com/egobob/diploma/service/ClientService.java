package com.egobob.diploma.service;

import com.egobob.diploma.domain.Client;

public interface ClientService { // TODO: refactor to extend base CRUD service
    Client saveClient(Client client);

    Client getClientById(Long id);

    Iterable<Client> listAllClients();

    void deleteClient(Long id);
}
