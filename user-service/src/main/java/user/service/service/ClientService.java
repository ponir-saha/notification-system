package user.service.service;

import user.service.entity.Client;

import java.util.List;

public interface ClientService {
    Client createClient(Client client);

    List<Client> getAllClients();

    Client getClientById(Long id);
}
