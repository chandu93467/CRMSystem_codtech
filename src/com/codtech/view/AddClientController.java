package com.codtech.view;

import com.codtech.model.Client;
import com.codtech.service.ClientService;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class AddClientController {

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
    private void handleAddClient() {
        if (validateInput()) {
            try {
                int id = Integer.parseInt(idField.getText().trim()); // Assuming id is entered manually
                String firstName = firstNameField.getText().trim();
                String lastName = lastNameField.getText().trim();
                String email = emailField.getText().trim();
                String phone = phoneField.getText().trim();
                String address = addressField.getText().trim();

                Client client = new Client(id, firstName, lastName, email, phone, address);
                clientService.addClient(client);
                showAlert("Client added successfully!");
                closeStage();
            } catch (NumberFormatException e) {
                showAlert("ID must be a valid number.");
            }
        }
    }

    @FXML
    private void handleBack() {
        closeStage();
    }

    private boolean validateInput() {
        if (idField.getText().trim().isEmpty()
                || firstNameField.getText().trim().isEmpty()
                || lastNameField.getText().trim().isEmpty()
                || emailField.getText().trim().isEmpty()
                || phoneField.getText().trim().isEmpty()
                || addressField.getText().trim().isEmpty()) {
            showAlert("All fields are required.");
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

    private void closeStage() {
        Stage stage = (Stage) idField.getScene().getWindow();
        stage.close();
    }
}
