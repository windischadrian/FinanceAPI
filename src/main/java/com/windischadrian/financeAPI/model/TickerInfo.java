package com.windischadrian.financeAPI.model;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class TickerInfo {

    //Stock information
    private String stockName;
    private String ticker;
    private String stockCurrency;
    private String stockExchange;
    private BigDecimal stockPrice;
}
