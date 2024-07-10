package com.codtech.model;

import java.time.LocalDateTime;

public class Report {
    private int id;
    private String title;
    private String content;
    private LocalDateTime generated_at; // Adjusted property name

    public Report() {
        // Default constructor needed for JavaFX PropertyValueFactory
    }

    // Constructor for creating a report (without ID and generated_at)
    public Report(String title, String content) {
        this.title = title;
        this.content = content;
        this.generated_at = LocalDateTime.now(); // Automatically set current timestamp
    }

    // Constructor for creating a report with ID, title, content, and generated_at
    public Report(int id, String title, String content, LocalDateTime generated_at) {
        this.id = id;
        this.title = title;
        this.content = content;
        this.generated_at = generated_at;
    }

    // Getters and setters (required for PropertyValueFactory to work properly)

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public LocalDateTime getGenerated_at() {
        return generated_at;
    }

    public void setGenerated_at(LocalDateTime generated_at) {
        this.generated_at = generated_at;
    }

    @Override
    public String toString() {
        return "Report{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", content='" + content + '\'' +
                ", generated_at=" + generated_at +
                '}';
    }
}
