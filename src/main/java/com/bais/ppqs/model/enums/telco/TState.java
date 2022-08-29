package com.bais.ppqs.model.enums.telco;

public enum TState {
    ACTIVE("active"), INACTIVE("inactive");

    private String code;

    TState(String code) {
        this.code = code;
    }

    public String getCode() {
        return code;
    }
}

