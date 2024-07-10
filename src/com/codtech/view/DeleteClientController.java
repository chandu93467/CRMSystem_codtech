package com.codtech.view;

import com.codtech.service.ClientService;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class DeleteClientController {

    @FXML
    private TextField idField;

    private ClientService clientService = new ClientService();

    @FXML
    private void handleDeleteClient() {
        if (idField.getText() != null && !idField.getText().isEmpty()) {
            int clientId = Integer.parseInt(idField.getText());
            clientService.deleteClient(clientId);
            showAlert("Client deleted successfully!");
        } else {
            showAlert("Client ID is required.");
        }
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
