package com.bais.ppqs.model.enums.telco;

public enum RuntimeEnv {

    LIVE("live"), DEV("dev");

    private String code;

    RuntimeEnv(String code) {
        this.code = code;
    }

    public String getCode() {
        return code;
    }
}

