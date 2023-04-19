package com.windischadrian.financeAPI.service;

import com.windischadrian.financeAPI.enums.TickerResponseType;
import com.windischadrian.financeAPI.model.TickerResponse;
import org.springframework.stereotype.Service;
import yahoofinance.Stock;
import yahoofinance.YahooFinance;

import java.io.IOException;

@Service
public class FinanceService {

    public TickerResponse getTickerInfo(String ticker) {
        TickerResponse tickerResponse = new TickerResponse();
        Stock stock = null;
        try {
            stock = YahooFinance.get(ticker);
        } catch (IOException ioex) {
            tickerResponse.setTickerResponseType(TickerResponseType.RESPONSE_ERROR);
            tickerResponse.setMessage("Error fetching data. Please verify your parameters.");

            return tickerResponse;
        }

        if(!stock.isValid()) {
            tickerResponse.setTickerResponseType(TickerResponseType.RESPONSE_ERROR);
            tickerResponse.setMessage("Invalid stock. Please check ticker.");

            return tickerResponse;
        }

        return tickerResponse;
    }



}
