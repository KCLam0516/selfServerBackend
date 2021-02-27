package com.example.keanchin.domain.payment;

import com.example.keanchin.dataModel.Booking;
import com.example.keanchin.dataModel.Payment;
import com.example.keanchin.dataModel.User;
import com.example.keanchin.dataModel.repository.BookingRepo;
import com.example.keanchin.dataModel.repository.PaymentRepo;
import com.example.keanchin.dataModel.repository.UserRepo;
import com.example.keanchin.domain.payment.object.PaymentDto;
import com.example.keanchin.domain.payment.object.req.MakePaymentReq;
import com.example.keanchin.domain.payment.object.resp.PaymentReqResp;
import com.example.keanchin.exception.CarRentalErrorCode;
import com.example.keanchin.exception.CarRentalException;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class PaymentService {
    private final PaymentRepo paymentRepo;
    private final BookingRepo bookingRepo;
    private final UserRepo userRepo;

    public PaymentService(PaymentRepo paymentRepo, BookingRepo bookingRepo, UserRepo userRepo) {
        this.paymentRepo = paymentRepo;
        this.bookingRepo = bookingRepo;
        this.userRepo = userRepo;
    }

    public PaymentReqResp makePayment(MakePaymentReq payReq)throws Exception{
        Booking booking = bookingRepo.findById(payReq.getBookingId());
        if(booking == null){
            throw new CarRentalException(CarRentalErrorCode.INVALID_ID);
        }
        User user = userRepo.findById(booking.getUser().getId());
        if(user == null){
            throw new CarRentalException(CarRentalErrorCode.UNEXPECTED_ERROR);
        }
        Double payAmount = booking.getBookingDay()*booking.getCar().getDailyCarRating();
        Payment payment = Payment.builder()
                .billDate(new Date())
                .billTo(user.getProfileName())
                .amount(payAmount)
                .paymentMethodEnum(payReq.getPaymentMethodEnum())
                .booking(booking)
                .user(user)
                .build();

        paymentRepo.save(payment);

        return PaymentReqResp.builder()
                .paymentDto(PaymentDto.mapPaymentDtoFromPayment(payment))
                .build();
    }
}
