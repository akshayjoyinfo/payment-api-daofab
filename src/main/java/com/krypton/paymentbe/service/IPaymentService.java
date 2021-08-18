package com.krypton.paymentbe.service;

import com.krypton.paymentbe.dto.PaymentParentData;
import com.krypton.paymentbe.models.Response.PaymentDetailResponse;
import com.krypton.paymentbe.models.Response.PaymentMasterResponse;

import java.io.IOException;
import java.util.List;

public interface IPaymentService {
    List<PaymentMasterResponse> getPaymentMasterInfo(int page, int limit) throws IOException;
    List<PaymentDetailResponse> getPaymentDetailInfo(long paymentId) throws IOException;
}
