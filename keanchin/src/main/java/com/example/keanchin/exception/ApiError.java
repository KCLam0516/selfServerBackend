package com.example.keanchin.exception;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.util.StringUtils;

@Data
@NoArgsConstructor
public class ApiError {
    @ApiModelProperty(value = "Api error code")
    private CarRentalErrorCode code;
    @ApiModelProperty(value = "Api error description")
    private String message;
    @ApiModelProperty(value = "User-friendly error message can be used to display to user.")
    private String friendlyMessage;

    public ApiError(CarRentalErrorCode code) {
        this.code = code;
        this.message = code.getDescription();
        this.friendlyMessage = code.getFriendlyMessage();
    }

    public ApiError(CarRentalErrorCode code, String friendlyMessage) {
        this.code = code;
        this.message = code.getDescription();
        this.friendlyMessage = StringUtils.isEmpty(friendlyMessage) ? code.getFriendlyMessage() : friendlyMessage;
    }
}
