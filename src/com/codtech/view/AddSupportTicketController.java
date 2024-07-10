package com.codtech.view;

import com.codtech.model.SupportTicket;
import com.codtech.service.SupportTicketService;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class AddSupportTicketController {

    @FXML
    private TextField idField;

    @FXML
    private TextField clientIdField;

    @FXML
    private TextField titleField;

    @FXML
    private TextArea descriptionArea;

    @FXML
    private TextField statusField;

    private SupportTicketService supportTicketService = new SupportTicketService();

    @FXML
    private void handleAddSupportTicket() {
        if (validateInput()) {
            try {
                int id = Integer.parseInt(idField.getText().trim());
                int clientId = Integer.parseInt(clientIdField.getText().trim());
                String title = titleField.getText().trim();
                String description = descriptionArea.getText().trim();
                String status = statusField.getText().trim();

                SupportTicket supportTicket = new SupportTicket(id, clientId, title, description, status);
                supportTicketService.addSupportTicket(supportTicket);
                showAlert("Support Ticket added successfully!");
            } catch (NumberFormatException e) {
                showAlert("ID and Client ID should be valid numbers.");
            }
        }
    }

    private boolean validateInput() {
        if (idField.getText().trim().isEmpty()) {
            showAlert("ID is required.");
            return false;
        }
        if (clientIdField.getText().trim().isEmpty()) {
            showAlert("Client ID is required.");
            return false;
        }
        if (titleField.getText().trim().isEmpty()) {
            showAlert("Ticket title is required.");
            return false;
        }
        if (descriptionArea.getText().trim().isEmpty()) {
            showAlert("Ticket description is required.");
            return false;
        }
        if (statusField.getText().trim().isEmpty()) {
            showAlert("Ticket status is required.");
            return false;
        }
        return true;
    }

    private void showAlert(String message) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Information");
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }

    @FXML
    private void handleBack() {
        Stage stage = (Stage) clientIdField.getScene().getWindow();
        stage.close();
    }
}
