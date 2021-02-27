package com.example.keanchin.exception;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
public class CarRentalException extends Exception {
    private CarRentalErrorCode code;
    private String customMessage;
    private Exception cause;

    public CarRentalException(CarRentalErrorCode code, String customMessage) {
        super(customMessage);
        this.code = code;
        this.customMessage = customMessage;
    }

    public CarRentalException(CarRentalErrorCode code) {
        super(code.toString());
        this.code = code;
    }

    public CarRentalException(CarRentalErrorCode code, Exception cause) {
        this(code);
        this.cause = cause;
    }
}
