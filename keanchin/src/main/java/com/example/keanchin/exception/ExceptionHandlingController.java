package com.example.keanchin.exception;

import com.example.keanchin.BaseResp;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.exception.ExceptionUtils;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import javax.servlet.http.HttpServletRequest;

@Slf4j
@ControllerAdvice
public class ExceptionHandlingController {

    @ExceptionHandler(value = CarRentalException.class)
    public ResponseEntity<BaseResp> carRentalErrorHandler(HttpServletRequest req, CarRentalException e) {
        BaseResp baseResp = BaseResp.builder()
                .error(new ApiError(e.getCode(), e.getCustomMessage()))
                .build();
        log.error(ExceptionUtils.getStackTrace(e));
        return ResponseEntity.status(e.getCode().getHttpStatus()).body(baseResp);
    }
}