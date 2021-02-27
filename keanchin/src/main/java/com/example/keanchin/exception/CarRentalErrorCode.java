package com.example.keanchin.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
public enum CarRentalErrorCode implements ReturnableError {

    EMPTY_USERNAME("Username Field Cannot be Blank", "Empty username found",400),
    EMPTY_PASSWORD("Password Field Cannot be Blank", "Empty password found",400),
    EMPTY_FIELD("Field Cannot be Blank", "Field Cannot be Blank",400),
    DUPLICATE_USERNAME("Email Enter Has been used", "Duplicate Email Found",400),
    INVALID_NEW_PASSWORD("Invalid new password", "Invalid new password",400),
    INVALID_OLD_PASSWORD("Invalid old password", "Invalid old password",400),
    INVALID_VALUE_INPUT("Negative or 0 Value input", "Negative or 0 Value input",400),
    INVALID_USERNAME("Invalid email format", "Invalid email format",400),
    INVALID_AGE("Invalid age format", "Invalid age format",400),
    INVALID_PHONE("Invalid phone number format", "Invalid phone number format",400),
    INVALID_LOGIN("Wrong Username or Password", "Wrong Username or Password",400),
    INVALID_ID("Wrong ID", "No Id Found",400),
    INVALID_CAR_ID("Wrong Car ID", "No Car Id Found",400),
    UNEXPECTED_ERROR("Unexpected Error Occur", "Unexpected Error Occur",400);

    @Getter
    private String description;

    @Getter
    private String friendlyMessage;

    @Getter
    private int httpStatus;
}
