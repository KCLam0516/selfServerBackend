package com.example.keanchin.dataModel.constant;

public enum GenderEnum {
    UNDEFINED("UNDEFINED"),
    MALE("MALE"),
    FEMALE("FEMALE");

    private String value;

    GenderEnum(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}

