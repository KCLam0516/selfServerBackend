package com.example.keanchin.domain.payment.object.resp;

import com.example.keanchin.domain.payment.object.PaymentDto;
import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class PaymentReqResp {
    private PaymentDto paymentDto;
}
