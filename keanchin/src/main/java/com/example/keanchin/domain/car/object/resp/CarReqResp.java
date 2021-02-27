package com.example.keanchin.domain.car.object.resp;

import com.example.keanchin.domain.car.object.CarDto;
import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class CarReqResp {
    private CarDto carDetails;
}
