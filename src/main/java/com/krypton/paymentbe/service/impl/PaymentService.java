package com.krypton.paymentbe.service.impl;

import com.krypton.paymentbe.dto.PaymentChildData;
import com.krypton.paymentbe.dto.PaymentParentData;
import com.krypton.paymentbe.exceptions.ResourceNotFoundException;
import com.krypton.paymentbe.models.Response.PaymentDetailResponse;
import com.krypton.paymentbe.models.Response.PaymentMasterResponse;
import com.krypton.paymentbe.service.IPaymentService;
import com.krypton.paymentbe.utils.PaymentDataSourceService;
import io.swagger.v3.oas.annotations.servers.Server;
import org.apache.catalina.User;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

@Service
public class PaymentService implements IPaymentService {

    @Override
    public List<PaymentMasterResponse> getPaymentMasterInfo(int page, int limit) throws IOException {

        List<PaymentMasterResponse> response = new ArrayList<>();

        var parentData =  PaymentDataSourceService.GetPaymentParentData();
        var childData  = PaymentDataSourceService.GetPaymentChildData();

        parentData.forEach(parent -> {
            var childPayments = childData.stream().filter(f ->
                    f.getParentID()==parent.getID()).collect(Collectors.toList());

            // best approach is to write a AutoMapper
            var re = new PaymentMasterResponse();
            re.setID(parent.getID());
            re.setSender(parent.getSender());
            re.setReceiver(parent.getReceiver());
            re.setTotalAmount(parent.getTotalAmount());
            re.setTotalPaidAmount(childPayments.stream().mapToLong(i -> i.getPaidAmount()).sum());
            response.add(re);
        });

        return response.stream().sorted(Comparator.comparingLong(PaymentMasterResponse::getID))
                .skip(2*(page-1)).limit(limit).collect(Collectors.toList());
    }

    @Override
    public List<PaymentDetailResponse> getPaymentDetailInfo(long paymentId) throws IOException {
        List<PaymentDetailResponse> response = new ArrayList<>();

        var parentData =  PaymentDataSourceService.GetPaymentParentData();
        var childData  = PaymentDataSourceService.GetPaymentChildData();

        var parentPayment = parentData.stream().filter(p ->
                p.getID()==paymentId).findFirst();

        if(!parentPayment.isPresent())
            throw new ResourceNotFoundException("Not found PaymentId : "+ paymentId);

        var childPayments = childData.stream().filter(f ->
                f.getParentID()==parentPayment.get().getID()).collect(Collectors.toList());

        childPayments.forEach(parent ->{
            var re = new PaymentDetailResponse();
            re.setID(parent.getID());
            re.setSender(parentPayment.get().getSender());
            re.setReceiver(parentPayment.get().getReceiver());
            re.setTotalAmount(parentPayment.get().getTotalAmount());
            re.setPaidAmount(parent.getPaidAmount());
            response.add(re);
        });

        return response;
    }
}
