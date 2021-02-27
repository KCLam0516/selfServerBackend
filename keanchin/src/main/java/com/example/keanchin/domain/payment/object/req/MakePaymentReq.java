package com.example.keanchin.domain.payment.object.req;

import com.example.keanchin.dataModel.constant.PaymentMethodEnum;
import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class MakePaymentReq {
    private Long bookingId;
    private PaymentMethodEnum paymentMethodEnum;
}
