package com.codtech.view;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

import java.util.List;

import com.codtech.model.SupportTicket;
import com.codtech.service.SupportTicketService;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class ViewAllSupportTicketsController {

    @FXML
    private TableView<SupportTicket> supportTicketTableView;

    @FXML
    private TableColumn<SupportTicket, Integer> idColumn;

    @FXML
    private TableColumn<SupportTicket, Integer> clientIdColumn;

    @FXML
    private TableColumn<SupportTicket, String> titleColumn;

    @FXML
    private TableColumn<SupportTicket, String> descriptionColumn;

    @FXML
    private TableColumn<SupportTicket, String> statusColumn;

    @FXML
    private Button backButton;

    private SupportTicketService supportTicketService = new SupportTicketService();

    @FXML
    public void initialize() {
        // Initialize TableView columns
        idColumn.setCellValueFactory(new PropertyValueFactory<>("id"));
        clientIdColumn.setCellValueFactory(new PropertyValueFactory<>("clientId"));
        titleColumn.setCellValueFactory(new PropertyValueFactory<>("title"));
        descriptionColumn.setCellValueFactory(new PropertyValueFactory<>("description"));
        statusColumn.setCellValueFactory(new PropertyValueFactory<>("status"));

        // Populate TableView with data
        loadSupportTickets();
    }

    private void loadSupportTickets() {
        List<SupportTicket> ticketList = supportTicketService.getAllSupportTickets();
        ObservableList<SupportTicket> ticketData = FXCollections.observableArrayList(ticketList);
        supportTicketTableView.setItems(ticketData);
    }

    @FXML
    private void handleBackButtonAction() {
        Stage stage = (Stage) backButton.getScene().getWindow();
        stage.close();
    }
}
