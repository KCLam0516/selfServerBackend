package com.example.keanchin;

import com.example.keanchin.exception.ApiError;
import com.example.keanchin.exception.CarRentalUtil;
import com.fasterxml.jackson.annotation.JsonInclude;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.experimental.SuperBuilder;

@SuperBuilder(toBuilder = true)
@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class BaseResp {
    private String requestId = CarRentalUtil.generateRandomAlphaNumeric(8);
    @ApiModelProperty(notes = "An object with information about the error status of the api. If there is no error, all values will be null.")
    private ApiError error;
}
