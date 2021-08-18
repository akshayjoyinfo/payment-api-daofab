package com.krypton.paymentbe.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public class HealthStatus {
    @JsonProperty("status")
    private String status;

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public HealthStatus(String status) {
        this.status = status;
    }
}
