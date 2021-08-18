package com.krypton.paymentbe.controllers;

import com.krypton.paymentbe.dto.HealthStatus;
import com.krypton.paymentbe.dto.PaymentParentData;
import com.krypton.paymentbe.models.Response.PaymentDetailResponse;
import com.krypton.paymentbe.models.Response.PaymentMasterResponse;
import com.krypton.paymentbe.service.IPaymentService;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/api/v1/payment")
public class PaymentController {

    private final IPaymentService paymentService;

    public PaymentController(IPaymentService paymentService) {
        this.paymentService = paymentService;
    }

    @GetMapping
    @Operation(description = "Get Master Payment Aggregate Information", tags = {"Payment"},
            summary = "Get Master Payment Aggregate Information")
    public ResponseEntity<List<PaymentMasterResponse>> getMasterPaymentInfo(
            @RequestParam(value = "page", defaultValue = "1") @Valid @Max(2000) @Min(1) int page,
            @RequestParam(value = "limit", defaultValue = "2") @Valid @Max(10) @Min(1) int limit
            ) throws IOException {

        List<PaymentMasterResponse> result = paymentService.getPaymentMasterInfo(page, limit);

        return new ResponseEntity<List<PaymentMasterResponse>>(
               result, HttpStatus.OK
        );
    }

    @GetMapping("/{paymentId}/detail")
    @Operation(description = "Get Payment Detail for each Parent Payment", tags = {"Payment Detail"},
            summary = "Get Payment Detail for each Parent Payment")
    public ResponseEntity<List<PaymentDetailResponse>> getPaymentDetailInfo(
            @PathVariable @Valid @Min(1) int paymentId
    ) throws IOException {

        List<PaymentDetailResponse> result = paymentService.getPaymentDetailInfo(paymentId);

        return new ResponseEntity<List<PaymentDetailResponse>>(
                result, HttpStatus.OK
        );
    }

}
