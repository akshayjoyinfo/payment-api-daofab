package com.krypton.paymentbe.models.Response;

import com.fasterxml.jackson.annotation.JsonProperty;

public class PaymentMasterResponse extends Payment {
    private long totalPaidAmount;

    @JsonProperty("Total Paid Amount")
    public long getTotalPaidAmount() { return totalPaidAmount; }
    @JsonProperty("Total Amount")
    public void setTotalPaidAmount(long value) { this.totalPaidAmount = value; }
}
