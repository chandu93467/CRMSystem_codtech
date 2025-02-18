package com.codtech.model;

public class SupportTicket {
    private int id;
    private int clientId;
    private String title;
    private String description;
    private String status;

    public SupportTicket(int id, int clientId, String title, String description, String status) {
        this.id = id;
        this.clientId = clientId;
        this.title = title;
        this.description = description;
        this.status = status;
    }

    // Getters and Setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getClientId() {
        return clientId;
    }

    public void setClientId(int clientId) {
        this.clientId = clientId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
