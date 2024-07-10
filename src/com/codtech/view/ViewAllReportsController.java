package com.codtech.view;

import com.codtech.model.Report;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;

public class ViewAllReportsController {

    @FXML
    private TableView<Report> reportTableView;

    @FXML
    private TableColumn<Report, Integer> idColumn;

    @FXML
    private TableColumn<Report, String> titleColumn;

    @FXML
    private TableColumn<Report, String> contentColumn;

    @FXML
    private TableColumn<Report, LocalDateTime> generatedAtColumn;

    @FXML
    private Button backButton;

    private ObservableList<Report> reportsData = FXCollections.observableArrayList();

    public void initialize() {
        // Initialize columns
        idColumn.setCellValueFactory(new PropertyValueFactory<>("id"));
        titleColumn.setCellValueFactory(new PropertyValueFactory<>("title"));
        contentColumn.setCellValueFactory(new PropertyValueFactory<>("content"));
        generatedAtColumn.setCellValueFactory(new PropertyValueFactory<>("generated_at"));

        // Load data from database
        loadReportsFromDatabase();
    }

    private void loadReportsFromDatabase() {
        // Clear existing data
        reportsData.clear();

        // Database connection parameters
        String url = "jdbc:mysql://localhost:3306/codtech_crm";
        String username = "root";
        String password = "chandu@93467";

        // SQL query to retrieve reports data
        String sql = "SELECT id, title, content, generated_at FROM reports";

        try (Connection conn = DriverManager.getConnection(url, username, password);
                PreparedStatement statement = conn.prepareStatement(sql);
                ResultSet resultSet = statement.executeQuery()) {

            // Process each row in the result set
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String title = resultSet.getString("title");
                String content = resultSet.getString("content");
                LocalDateTime generatedAt = resultSet.getTimestamp("generated_at").toLocalDateTime();

                // Create Report object
                Report report = new Report(id, title, content, generatedAt);
                reportsData.add(report);
            }

            // Set data to TableView
            reportTableView.setItems(reportsData);

        } catch (SQLException e) {
            e.printStackTrace();
            // Handle exceptions appropriately (logging, error dialogs, etc.)
        }
    }

    @FXML
    private void handleBackButtonAction() {
        // Handle back button action
        Stage stage = (Stage) backButton.getScene().getWindow();

        // Close the current stage (window)
        stage.close();
    }
}
