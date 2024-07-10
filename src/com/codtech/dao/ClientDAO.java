package com.codtech.dao;

import com.codtech.model.Client;

import java.util.List;

public interface ClientDAO {

    void addClient(Client client);

    boolean updateClient(Client client);

    void deleteClient(int clientId);

    Client getClientById(int clientId);

    List<Client> getAllClients();
}
