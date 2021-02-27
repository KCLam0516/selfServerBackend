package com.example.keanchin.domain.payment.object;

import com.example.keanchin.dataModel.Payment;
import com.example.keanchin.dataModel.constant.PaymentMethodEnum;
import com.example.keanchin.domain.booking.object.BookingDto;
import com.example.keanchin.domain.user.object.UserDto;
import lombok.Builder;
import lombok.Data;

import java.util.Date;
import java.util.Optional;

@Builder
@Data
public class PaymentDto {
    private Long id;
    private Date billDate;
    private String billTo;
    private Double amount;
    private PaymentMethodEnum paymentMethodEnum;
    private BookingDto bookingDto;
    private UserDto userDto;

    public static PaymentDto mapPaymentDtoFromPayment(Payment payment) {
        return Optional.ofNullable(payment)
                .map(paymentMap->PaymentDto.builder()
                        .id(paymentMap.getId())
                        .billDate(paymentMap.getBillDate())
                        .billTo(paymentMap.getBillTo())
                        .amount(paymentMap.getAmount())
                        .paymentMethodEnum(paymentMap.getPaymentMethodEnum())
                        .bookingDto(BookingDto.mapBookingDtoFromBooking(paymentMap.getBooking()))
                        .userDto(UserDto.mapUserDtoFromUser(paymentMap.getUser()))
                        .build())
                .orElse(null);
    }
}
