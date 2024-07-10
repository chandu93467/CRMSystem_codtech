package com.codtech.service;

import com.codtech.dao.ClientDAO;
import com.codtech.dao.ClientDAOImpl;
import com.codtech.model.Client;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.List;

public class ClientService {

    private ClientDAO clientDAO;
    private Connection connection;

    public ClientService() {
        try {
            // Establish database connection
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/codtech_crm", "root", "chandu@93467");
            clientDAO = new ClientDAOImpl(connection);
        } catch (SQLException e) {
            e.printStackTrace();
            // Optionally, throw a runtime exception or handle the exception as appropriate
        }
    }

    // Method to close the database connection
    public void closeConnection() {
        try {
            if (connection != null && !connection.isClosed()) {
                connection.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void addClient(Client client) {
        clientDAO.addClient(client);
    }

    public boolean updateClient(Client client) {
        return clientDAO.updateClient(client);
    }

    public void deleteClient(int clientId) {
        clientDAO.deleteClient(clientId);
    }

    public Client getClientById(int clientId) {
        return clientDAO.getClientById(clientId);
    }

    public List<Client> getAllClients() {
        return clientDAO.getAllClients();
    }
}
