package com.codtech.view;

import com.codtech.model.SupportTicket;
import com.codtech.service.SupportTicketService;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class UpdateSupportTicketController {

    @FXML
    private TextField idField;

    @FXML
    private TextField titleField;

    @FXML
    private TextArea descriptionArea;

    @FXML
    private TextField statusField;

    private SupportTicketService supportTicketService = new SupportTicketService();

    @FXML
    private void handleUpdateSupportTicket() {
        if (validateInput()) {
            try {
                int ticketId = Integer.parseInt(idField.getText().trim());
                SupportTicket supportTicket = supportTicketService.getSupportTicketById(ticketId);
                if (supportTicket != null) {
                    supportTicket.setTitle(titleField.getText().trim());
                    supportTicket.setDescription(descriptionArea.getText().trim());
                    supportTicket.setStatus(statusField.getText().trim());

                    supportTicketService.updateSupportTicket(supportTicket);
                    showAlert("Support Ticket updated successfully!");
                } else {
                    showAlert("Support Ticket not found.");
                }
            } catch (NumberFormatException e) {
                showAlert("Ticket ID should be a valid number.");
            }
        }
    }

    private boolean validateInput() {
        if (idField.getText() == null || idField.getText().trim().isEmpty()) {
            showAlert("Ticket ID is required.");
            return false;
        }
        if (titleField.getText() == null || titleField.getText().trim().isEmpty()) {
            showAlert("New ticket title is required.");
            return false;
        }
        if (descriptionArea.getText() == null || descriptionArea.getText().trim().isEmpty()) {
            showAlert("New ticket description is required.");
            return false;
        }
        if (statusField.getText() == null || statusField.getText().trim().isEmpty()) {
            showAlert("New ticket status is required.");
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
        Stage stage = (Stage) idField.getScene().getWindow();
        stage.close();
    }
}
