package com.codtech.view;

import com.codtech.model.Report;
import com.codtech.service.ReportService;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class AddReportController {

    @FXML
    private TextField titleField;

    @FXML
    private TextArea descriptionArea;

    private ReportService reportService = new ReportService();

    @FXML
    private void initialize() {
        // Optional: Initialize anything needed when the controller is loaded.
    }

    @FXML
    private void handleAddReport() {
        if (validateInput()) {
            // Create a new Report object from UI input
            Report report = new Report(titleField.getText(), descriptionArea.getText());

            // Call service to add the report to the database
            reportService.addReport(report);

            // Show success message
            showAlert("Report added successfully!");

            // Close the current stage (window)
            closeStage();
        }
    }

    private boolean validateInput() {
        if (titleField.getText().isEmpty()) {
            showAlert("Report title is required.");
            return false;
        }
        if (descriptionArea.getText().isEmpty()) {
            showAlert("Report description is required.");
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
        // Close the current stage (window)
        closeStage();
    }

    private void closeStage() {
        Stage stage = (Stage) titleField.getScene().getWindow();
        stage.close();
    }
}
