package com.example.keanchin.dataModel.constant;

public enum PaymentMethodEnum {
    CREDIT("CREDIT"),
    DEBIT("DEBIT"),
    CASH("CASH");

    private String value;

    PaymentMethodEnum(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}

