package com.krypton.paymentbe.models.Response;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Payment {
    private long id;
    private String sender;
    private String receiver;
    private long totalAmount;


    @JsonProperty("ID")
    public long getID() { return id; }
    @JsonProperty("ID")
    public void setID(long value) { this.id = value; }

    @JsonProperty("Sender")
    public String getSender() { return sender; }
    @JsonProperty("Sender")
    public void setSender(String value) { this.sender = value; }

    @JsonProperty("Receiver")
    public String getReceiver() { return receiver; }
    @JsonProperty("Receiver")
    public void setReceiver(String value) { this.receiver = value; }

    @JsonProperty("Total Amount")
    public long getTotalAmount() { return totalAmount; }
    @JsonProperty("Total Amount")
    public void setTotalAmount(long value) { this.totalAmount = value; }
}
