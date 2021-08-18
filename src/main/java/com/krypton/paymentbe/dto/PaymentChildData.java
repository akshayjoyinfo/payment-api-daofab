package com.krypton.paymentbe.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public class PaymentChildData {
    private long id;
    private long parentID;
    private long paidAmount;

    @JsonProperty("id")
    public long getID() { return id; }
    @JsonProperty("id")
    public void setID(long value) { this.id = value; }

    @JsonProperty("parentId")
    public long getParentID() { return parentID; }
    @JsonProperty("parentId")
    public void setParentID(long value) { this.parentID = value; }

    @JsonProperty("paidAmount")
    public long getPaidAmount() { return paidAmount; }
    @JsonProperty("paidAmount")
    public void setPaidAmount(long value) { this.paidAmount = value; }
}
