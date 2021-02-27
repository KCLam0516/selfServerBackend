package com.example.keanchin.domain.booking;

import com.example.keanchin.dataModel.Booking;
import com.example.keanchin.dataModel.Car;
import com.example.keanchin.dataModel.User;
import com.example.keanchin.dataModel.repository.BookingRepo;
import com.example.keanchin.dataModel.repository.CarRepo;
import com.example.keanchin.dataModel.repository.UserRepo;
import com.example.keanchin.domain.booking.object.BookingDto;
import com.example.keanchin.domain.booking.object.req.NewBookingReq;
import com.example.keanchin.domain.booking.object.resp.BookingReqResp;
import com.example.keanchin.exception.CarRentalErrorCode;
import com.example.keanchin.exception.CarRentalException;
import org.apache.commons.lang3.time.DateUtils;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class BookingService {
    private final BookingRepo bookingRepo;
    private final CarRepo carRepo;
    private final UserRepo userRepo;

    public BookingService(BookingRepo bookingRepo, CarRepo carRepo, UserRepo userRepo) {
        this.bookingRepo = bookingRepo;
        this.carRepo = carRepo;
        this.userRepo = userRepo;
    }

    public BookingReqResp bookCar(NewBookingReq bookingReq)throws Exception{
        Car car=carRepo.findById(bookingReq.getCarId());
        if(car == null) {
            throw new CarRentalException(CarRentalErrorCode.INVALID_CAR_ID);
        }
        User user=userRepo.findById(bookingReq.getUserId());
        if(user == null) {
            throw new CarRentalException(CarRentalErrorCode.INVALID_ID);
        }

        Date returnDate = DateUtils.addDays(bookingReq.getBookingDate(),bookingReq.getBookingDay());

        Booking booking = Booking.builder()
                .bookingDate(bookingReq.getBookingDate())
                .bookingDay(bookingReq.getBookingDay())
                .returnDate(returnDate)
                .car(car)
                .user(user)
                .isPaid(false)
                .build();

        Car updatedCar = car.toBuilder()
                .isBooked(true)
                .build();

        bookingRepo.save(booking);
        carRepo.save(updatedCar);

        return BookingReqResp.builder()
                .bookingDetails(BookingDto.mapBookingDtoFromBooking(booking))
                .build();
    }

    public BookingReqResp takeCar(Long carId)throws Exception{
        Car car=carRepo.findById(carId);
        if(car == null) {
            throw new CarRentalException(CarRentalErrorCode.INVALID_CAR_ID);
        }
        Booking booking=bookingRepo.findByCarId(car.getId());
        Car updatedCar= car.toBuilder()
                .isBooked(false)
                .build();

        carRepo.save(updatedCar);

        return BookingReqResp.builder()
                .bookingDetails(BookingDto.mapBookingDtoFromBooking(booking))
                .build();
    }
}
