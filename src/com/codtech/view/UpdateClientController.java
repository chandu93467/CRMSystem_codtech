package com.codtech.view;

import com.codtech.model.Client;
import com.codtech.service.ClientService;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class UpdateClientController {

    @FXML
    private TextField idField;

    @FXML
    private TextField firstNameField;

    @FXML
    private TextField lastNameField;

    @FXML
    private TextField emailField;

    @FXML
    private TextField phoneField;

    @FXML
    private TextField addressField;

    private ClientService clientService = new ClientService();

    @FXML
    private void handleUpdateClient() {
        if (validateInput()) {
            try {
                int clientId = Integer.parseInt(idField.getText().trim());
                Client client = clientService.getClientById(clientId);
                if (client != null) {
                    client.setFirstName(firstNameField.getText().trim());
                    client.setLastName(lastNameField.getText().trim());
                    client.setEmail(emailField.getText().trim());
                    client.setPhone(phoneField.getText().trim());
                    client.setAddress(addressField.getText().trim());

                    boolean success = clientService.updateClient(client);
                    if (success) {
                        showAlert("Information", "Client updated successfully!");
                    } else {
                        showAlert("Error", "Failed to update client.");
                    }
                } else {
                    showAlert("Error", "Client not found.");
                }
            } catch (NumberFormatException e) {
                showAlert("Error", "Client ID should be a valid number.");
            }
        }
    }

    private boolean validateInput() {
        if (idField.getText().trim().isEmpty()) {
            showAlert("Error", "Client ID is required.");
            return false;
        }
        if (firstNameField.getText().trim().isEmpty()) {
            showAlert("Error", "First Name is required.");
            return false;
        }
        if (lastNameField.getText().trim().isEmpty()) {
            showAlert("Error", "Last Name is required.");
            return false;
        }
        if (emailField.getText().trim().isEmpty()) {
            showAlert("Error", "Email is required.");
            return false;
        }
        if (phoneField.getText().trim().isEmpty()) {
            showAlert("Error", "Phone is required.");
            return false;
        }
        if (addressField.getText().trim().isEmpty()) {
            showAlert("Error", "Address is required.");
            return false;
        }
        return true;
    }

    private void showAlert(String title, String message) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle(title);
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
