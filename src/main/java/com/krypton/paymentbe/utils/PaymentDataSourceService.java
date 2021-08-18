package com.krypton.paymentbe.utils;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.krypton.paymentbe.dto.PaymentChild;
import com.krypton.paymentbe.dto.PaymentChildData;
import com.krypton.paymentbe.dto.PaymentParent;
import com.krypton.paymentbe.dto.PaymentParentData;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.util.FileCopyUtils;

import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class PaymentDataSourceService {

    public static List<PaymentParentData> GetPaymentParentData() throws IOException {

        Resource resource  = new ClassPathResource("static/parent.json");
        InputStream inputStream = resource.getInputStream();

        byte[] bdata = FileCopyUtils.copyToByteArray(inputStream);
        String data = new String(bdata, StandardCharsets.UTF_8);

        ObjectMapper objectMapper = new ObjectMapper();
        PaymentParent parentData = objectMapper.readValue(data, PaymentParent.class);
        return Arrays.stream(parentData.getData()).collect(Collectors.toList());
    }

    public static List<PaymentChildData> GetPaymentChildData() throws IOException {

        Resource resource  = new ClassPathResource("static/child.json");
        InputStream inputStream = resource.getInputStream();

        byte[] bdata = FileCopyUtils.copyToByteArray(inputStream);
        String data = new String(bdata, StandardCharsets.UTF_8);

        ObjectMapper objectMapper = new ObjectMapper();
        PaymentChild childData = objectMapper.readValue(data, PaymentChild.class);
        return Arrays.stream(childData.getData()).collect(Collectors.toList());
    }

}
