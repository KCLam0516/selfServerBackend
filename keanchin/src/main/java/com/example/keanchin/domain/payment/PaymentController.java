package com.example.keanchin.domain.payment;

import com.example.keanchin.domain.payment.object.req.MakePaymentReq;
import com.example.keanchin.domain.payment.object.resp.PaymentReqResp;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/payment")
public class PaymentController {
    private final PaymentService paymentService;

    public PaymentController(PaymentService paymentService) {
        this.paymentService = paymentService;
    }

    @ApiOperation(value = "Pay Booking")
    @PostMapping("/payBooking")
    public PaymentReqResp makePayment(
            @RequestBody MakePaymentReq payReq
    )throws Exception{
        return paymentService.makePayment(payReq);
    }
}
