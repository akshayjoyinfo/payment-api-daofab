package com.krypton.paymentbe.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public class PaymentParent {
    private PaymentParentData[] data;

    @JsonProperty("data")
    public PaymentParentData[] getData() { return data; }
    @JsonProperty("data")
    public void setData(PaymentParentData[] value) { this.data = value; }
}

