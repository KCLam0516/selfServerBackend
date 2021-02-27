package com.example.keanchin.domain.booking.object;

import com.example.keanchin.dataModel.Booking;
import com.example.keanchin.domain.car.object.CarDto;
import com.example.keanchin.domain.user.object.UserDto;
import lombok.Builder;
import lombok.Data;

import java.util.Date;
import java.util.Optional;

@Builder
@Data
public class BookingDto {
    private Long id;
    private Date bookingDate;
    private Integer bookingDay;
    private Date returnDate;
    private boolean isPaid;
    private CarDto carDto;
    private UserDto userDto;

    public static BookingDto mapBookingDtoFromBooking(Booking booking){
        return Optional.ofNullable(booking)
                .map(bookingMap -> BookingDto.builder()
                        .id(bookingMap.getId())
                        .bookingDate(bookingMap.getBookingDate())
                        .bookingDay(bookingMap.getBookingDay())
                        .returnDate(bookingMap.getReturnDate())
                        .isPaid(bookingMap.isPaid())
                        .carDto(CarDto.mapCarDtoFromCar(bookingMap.getCar()))
                        .userDto(UserDto.mapUserDtoFromUser(bookingMap.getUser()))
                        .build())
                .orElse(null);
    }
}
