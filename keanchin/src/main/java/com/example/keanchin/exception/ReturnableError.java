package com.example.keanchin.exception;

public interface ReturnableError {
    String getDescription();
    int getHttpStatus();
}
