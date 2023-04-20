package com.windischadrian.financeAPI.model;

import com.windischadrian.financeAPI.enums.TickerResponseType;
import lombok.Data;
import yahoofinance.Stock;

@Data
public class TickerResponse {

    private String ticker;
    //Info
    private String responseMessage;
    private TickerResponseType responseType;

    //Stock Info
    private TickerInfo tickerInfo;

    public void setResponseType(TickerResponseType responseType) {
        this.responseType = responseType;
        this.responseMessage = responseType.getValue();
    }
}
