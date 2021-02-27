package com.example.keanchin.domain.booking;

import com.example.keanchin.domain.booking.object.req.NewBookingReq;
import com.example.keanchin.domain.booking.object.resp.BookingReqResp;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/booking")
public class BookingController {
    private final BookingService bookingService;

    public BookingController(BookingService bookingService) {
        this.bookingService = bookingService;
    }

    @ApiOperation(value = "Book car")
    @PostMapping("/bookCar")
    public BookingReqResp bookCar(
            @RequestBody NewBookingReq bookReq
    )throws Exception{
        return bookingService.bookCar(bookReq);
    }

    @ApiOperation(value = "Take car")
    @PutMapping("/takeCar")
    public BookingReqResp takeCar(
            @RequestParam Long carId
    )throws Exception{
        return bookingService.takeCar(carId);
    }
}
