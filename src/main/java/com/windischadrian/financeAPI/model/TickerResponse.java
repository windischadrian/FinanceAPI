package com.windischadrian.financeAPI.model;

import com.windischadrian.financeAPI.enums.TickerResponseType;
import lombok.Data;
import yahoofinance.Stock;

import java.util.List;

@Data
public class TickerResponse {

    //Info
    private String responseMessage;
    private TickerResponseType responseType;

    //Stock Info
    private List<TickerInfo> tickerInfo;

    public void setResponseType(TickerResponseType responseType) {
        this.responseType = responseType;
        this.responseMessage = responseType.getValue();
    }
}
