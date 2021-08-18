package com.krypton.paymentbe.controllers;

import com.krypton.paymentbe.dto.HealthStatus;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/health")
public class HealthCheckController {
    @GetMapping
    @Operation(description = "HealthCheck Endpoint for Payment Backend API", summary = "HealthCheck Endpoint",
    tags = { "HealthCheck"})
    public ResponseEntity<HealthStatus> getHealthCheck(){
        return new ResponseEntity<HealthStatus>(
                new HealthStatus("Healthy"), HttpStatus.OK
        );
    }
}
