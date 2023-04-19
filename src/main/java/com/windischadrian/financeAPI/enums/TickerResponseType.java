package com.windischadrian.financeAPI.enums;

public enum TickerResponseType {
    RESPONSE_OK("Success getting ticker info."),
    RESPONSE_ERROR("Error getting ticker info. Please check input data."),
    RESPONSE_INVALID_TICKER("Error getting ticker info. Invalid ticker.");

    private final String value;

    TickerResponseType(String value) {
        this.value = value;
    }

    public String getValue() {
        return this.value;
    }
}
