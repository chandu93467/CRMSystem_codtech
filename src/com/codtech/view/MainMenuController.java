package com.codtech.view;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.io.IOException;

public class MainMenuController {

    @FXML
    private VBox root; // Assuming root is the top-level VBox in your FXML

    @FXML
    private void handleAddClient() {
        loadScene("AddClient.fxml");
    }

    @FXML
    private void handleUpdateClient() {
        loadScene("UpdateClient.fxml");
    }

    @FXML
    private void handleDeleteClient() {
        loadScene("DeleteClient.fxml");
    }

    @FXML
    private void handleViewAllClients() {
        loadScene("ViewAllClients.fxml");
    }

    @FXML
    private void handleAddSupportTicket() {
        loadScene("AddSupportTicket.fxml");
    }

    @FXML
    private void handleUpdateSupportTicket() {
        loadScene("UpdateSupportTicket.fxml");
    }

    @FXML
    private void handleDeleteSupportTicket() {
        loadScene("DeleteSupportTicket.fxml");
    }

    @FXML
    private void handleViewAllSupportTickets() {
        loadScene("ViewAllSupportTickets.fxml");
    }

    @FXML
    private void handleAddReport() {
        loadScene("AddReport.fxml");
    }

    @FXML
    private void handleDeleteReport() {
        loadScene("DeleteReport.fxml");
    }

    @FXML
    private void handleViewAllReports() {
        loadScene("ViewAllReports.fxml");
    }

    @FXML
    private void handleExit() {
        Stage stage = (Stage) root.getScene().getWindow();
        stage.close();
    }

    private void loadScene(String fxml) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/com/codtech/view/" + fxml));
            Scene scene = new Scene(loader.load());
            Stage stage = new Stage();
            stage.setScene(scene);
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
            showAlert("Error", "Failed to load scene: " + fxml);
        }
    }

    private void showAlert(String title, String message) {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }
}
