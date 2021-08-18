package com.krypton.paymentbe.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public class PaymentParentData {

        private long id;
        private String sender;
        private String receiver;
        private long totalAmount;

        @JsonProperty("id")
        public long getID() { return id; }
        @JsonProperty("id")
        public void setID(long value) { this.id = value; }

        @JsonProperty("sender")
        public String getSender() { return sender; }
        @JsonProperty("sender")
        public void setSender(String value) { this.sender = value; }

        @JsonProperty("receiver")
        public String getReceiver() { return receiver; }
        @JsonProperty("receiver")
        public void setReceiver(String value) { this.receiver = value; }

        @JsonProperty("totalAmount")
        public long getTotalAmount() { return totalAmount; }
        @JsonProperty("totalAmount")
        public void setTotalAmount(long value) { this.totalAmount = value; }

}
