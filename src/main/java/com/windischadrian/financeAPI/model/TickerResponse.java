package com.windischadrian.financeAPI.model;

import com.windischadrian.financeAPI.enums.TickerResponseType;
import lombok.Data;

@Data
public class TickerResponse {

    private String Message;

    private TickerResponseType tickerResponseType;
}
