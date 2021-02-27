package com.example.keanchin.domain.car.object.req;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class UpdateCarReq {
    private Long Id;
    private String carName;
    private String description;
    private Double dailyCarRating;
}
