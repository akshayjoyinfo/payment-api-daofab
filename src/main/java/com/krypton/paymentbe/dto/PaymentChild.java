package com.krypton.paymentbe.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public class PaymentChild {
    private PaymentChildData[] data;

    @JsonProperty("data")
    public PaymentChildData[] getData() { return data; }
    @JsonProperty("data")
    public void setData(PaymentChildData[] value) { this.data = value; }
}
