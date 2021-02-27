package com.example.keanchin.domain.car.object;

import com.example.keanchin.dataModel.Car;
import com.example.keanchin.domain.user.object.UserDto;
import lombok.Builder;
import lombok.Data;

import java.util.Optional;

@Builder
@Data
public class CarDto {
    private Long id;
    private String carName;
    private String description;
    private Double dailyCarRating;
    private UserDto userDto;
    private boolean isDeleted;
    private boolean isBooked;

    public static CarDto mapCarDtoFromCar(Car car) {
        return Optional.ofNullable(car)
                .map(carMap -> CarDto.builder()
                        .id(carMap.getId())
                        .carName(carMap.getCarName())
                        .description(carMap.getDescription())
                        .dailyCarRating(carMap.getDailyCarRating())
                        .userDto(UserDto.mapUserDtoFromUser(carMap.getUser()))
                        .isDeleted(carMap.isDeleted())
                        .isBooked(carMap.isBooked())
                        .build())
                .orElse(null);
    }
}
