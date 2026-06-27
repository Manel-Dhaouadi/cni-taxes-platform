package com.taxes.dto;

public class ValidationResponse {
    private Boolean success;
    private String message;

    // Constructeur par défaut
    public ValidationResponse() {}

    // Constructeur avec paramètres
    public ValidationResponse(Boolean success, String message) {
        this.success = success;
        this.message = message;
    }

    // ===== GETTERS =====
    public Boolean getSuccess() { return success; }
    public String getMessage() { return message; }

    // ===== SETTERS =====
    public void setSuccess(Boolean success) { this.success = success; }
    public void setMessage(String message) { this.message = message; }
}
