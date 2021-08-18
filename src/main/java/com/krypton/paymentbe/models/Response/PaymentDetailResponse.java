package com.krypton.paymentbe.models.Response;

import com.fasterxml.jackson.annotation.JsonProperty;

public class PaymentDetailResponse extends Payment{
    private long paidAmount;

    @JsonProperty("Paid Amount")
    public long getPaidAmount() { return paidAmount; }
    @JsonProperty("Paid Amount")
    public void setPaidAmount(long value) { this.paidAmount = value; }
}
