package com.krypton.paymentbe.controllers;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class PaymentControllerShould {
    @Autowired
    private MockMvc mockMvc;

    @Test
    public void ReturnMasterPaymentInfoWithGivenParameters() throws Exception {
        mockMvc.perform(get("/api/v1/payment?page=1&limit=2")
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.length()").value(2));
    }

    @Test
    public void ReturnMasterPaymentInfoWihtoutAnyParameters() throws Exception {
        mockMvc.perform(get("/api/v1/payment")
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.length()").value(2))
                .andExpect(jsonPath("$.[0].ID").value(1))
                .andExpect(jsonPath("$.[1].ID").value(2));;
    }

    @Test
    public void ReturnEmptyMasterPaymentInfoWithInvalidPageAndSize() throws Exception {
        mockMvc.perform(get("/api/v1/payment?page=100&limi=100")
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.length()").value(0));
    }

    @Test
    public void ReturnPaymentDetaiInfoForValidData() throws Exception {
        mockMvc.perform(get("/api/v1/payment/1/detail")
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.length()").value(3));
    }

    @Test
    public void Return404ForInvalidPaymentParentId() throws Exception {
        mockMvc.perform(get("/api/v1/payment/100/detail")
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isNotFound());

    }

}
