package com.codtech.view;

import com.codtech.service.ReportService;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class DeleteReportController {

    @FXML
    private TextField idField;

    private ReportService reportService = new ReportService();

    @FXML
    private void handleDeleteReport() {
        if (validateInput()) {
            int reportId = Integer.parseInt(idField.getText());
            reportService.deleteReport(reportId);
            showAlert("Report deleted successfully!");
        }
    }

    private boolean validateInput() {
        if (idField.getText() == null || idField.getText().isEmpty()) {
            showAlert("Report ID is required.");
            return false;
        }
        try {
            Integer.parseInt(idField.getText());
        } catch (NumberFormatException e) {
            showAlert("Report ID must be a valid number.");
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
