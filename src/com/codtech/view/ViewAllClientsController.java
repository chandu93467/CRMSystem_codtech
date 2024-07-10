package com.codtech.view;

import com.codtech.model.Client;
import com.codtech.service.ClientService;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

import java.util.List;

public class ViewAllClientsController {

    @FXML
    private TableView<Client> clientsTable;

    @FXML
    private TableColumn<Client, Integer> idColumn;

    @FXML
    private TableColumn<Client, String> firstNameColumn;

    @FXML
    private TableColumn<Client, String> lastNameColumn;

    @FXML
    private TableColumn<Client, String> emailColumn;

    @FXML
    private TableColumn<Client, String> phoneColumn;

    @FXML
    private TableColumn<Client, String> addressColumn;

    private ClientService clientService = new ClientService();

    @FXML
    public void initialize() {
        // Initialize TableView columns with PropertyValueFactory
        idColumn.setCellValueFactory(new PropertyValueFactory<>("id"));
        firstNameColumn.setCellValueFactory(new PropertyValueFactory<>("firstName"));
        lastNameColumn.setCellValueFactory(new PropertyValueFactory<>("lastName"));
        emailColumn.setCellValueFactory(new PropertyValueFactory<>("email"));
        phoneColumn.setCellValueFactory(new PropertyValueFactory<>("phone"));
        addressColumn.setCellValueFactory(new PropertyValueFactory<>("address"));

        // Load clients into the TableView
        loadClients();
    }

    private void loadClients() {
        List<Client> clients = clientService.getAllClients();
        if (clients != null) {
            ObservableList<Client> clientData = FXCollections.observableArrayList(clients);
            clientsTable.setItems(clientData);
        } else {
            System.err.println("Client list returned by ClientService is null.");
            // Optionally, show an alert or handle the null case appropriately
        }
    }

    @FXML
    private void handleBack() {
        Stage stage = (Stage) clientsTable.getScene().getWindow();
        stage.close();
    }
}
