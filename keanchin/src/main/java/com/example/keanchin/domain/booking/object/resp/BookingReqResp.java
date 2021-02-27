package com.example.keanchin.domain.booking.object.resp;

import com.example.keanchin.domain.booking.object.BookingDto;
import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class BookingReqResp {
    private BookingDto bookingDetails;
}
