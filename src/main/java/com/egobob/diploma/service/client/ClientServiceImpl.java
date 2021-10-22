package com.egobob.diploma.service.client;

import com.egobob.diploma.domain.Client;
import com.egobob.diploma.repository.ClientRepository;
import org.springframework.stereotype.Service;

@Service
public class ClientServiceImpl implements ClientService {

    private ClientRepository clientRepository;

    public ClientServiceImpl(ClientRepository clientRepository) {
        this.clientRepository = clientRepository;
    }

    @Override
    public Client saveClient(Client client) {
        return clientRepository.save(client);
    }

    @Override
    public Client getClientById(Long id) {
        return clientRepository.findById(id).orElseThrow();
    }

    @Override
    public Iterable<Client> listAllClients() {
        return clientRepository.findAll();
    }

    @Override
    public void deleteClient(Long id) {
        clientRepository.deleteById(id);
    }
}
