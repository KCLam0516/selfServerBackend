package com.example.keanchin.domain.booking.object.req;

import lombok.Builder;
import lombok.Data;

import java.util.Date;

@Builder
@Data
public class NewBookingReq {
    private Long carId;
    private Long userId;
    private Date bookingDate;
    private Integer bookingDay;
    private Date returnDate;
}
