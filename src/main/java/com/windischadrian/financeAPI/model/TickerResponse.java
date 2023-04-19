package com.windischadrian.financeAPI.model;

import com.windischadrian.financeAPI.enums.TickerResponseType;
import lombok.Data;

@Data
public class TickerResponse {

    //Generic
    private String responseMessage;
    private TickerResponseType responseType;

    //Stock Info
    private TickerInfo tickerInfo;

}
