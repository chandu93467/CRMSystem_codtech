package com.codtech.view;

import com.codtech.service.SupportTicketService;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class DeleteSupportTicketController {

    @FXML
    private TextField idField;

    private SupportTicketService supportTicketService = new SupportTicketService();

    @FXML
    private void handleDeleteSupportTicket() {
        if (validateInput()) {
            int ticketId = Integer.parseInt(idField.getText());
            supportTicketService.deleteSupportTicket(ticketId);
            showAlert("Support Ticket deleted successfully!");
        }
    }

    private boolean validateInput() {
        if (idField.getText() == null || idField.getText().isEmpty()) {
            showAlert("Ticket ID is required.");
            return false;
        }
        try {
            Integer.parseInt(idField.getText());
        } catch (NumberFormatException e) {
            showAlert("Ticket ID must be a valid number.");
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
