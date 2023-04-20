package com.windischadrian.financeAPI.service;

import com.windischadrian.financeAPI.enums.TickerResponseType;
import com.windischadrian.financeAPI.model.TickerInfo;
import com.windischadrian.financeAPI.model.TickerResponse;
import org.springframework.stereotype.Service;
import yahoofinance.Stock;
import yahoofinance.YahooFinance;

import java.util.Objects;

@Service
public class FinanceService {

    public TickerResponse getTickerInfo(String ticker) {
        TickerResponse tickerResponse = new TickerResponse();
        tickerResponse.setTicker(ticker);

        Stock stock = validateStock(ticker, tickerResponse);

        if(tickerResponse.getResponseType().equals(TickerResponseType.RESPONSE_OK)) {
            mapTickerResponse(stock, tickerResponse);
        }

        return tickerResponse;
    }

    private Stock validateStock(String ticker, TickerResponse tickerResponse) {
        Stock stock = null;

        try {
            stock = YahooFinance.get(ticker);
            tickerResponse.setResponseType(TickerResponseType.RESPONSE_OK);
        } catch (Exception ex) {
            tickerResponse.setResponseType(TickerResponseType.RESPONSE_ERROR);
        }

        if(Objects.isNull(stock) || !stock.isValid()) {
            tickerResponse.setResponseType(TickerResponseType.RESPONSE_INVALID_TICKER);
        }

        return stock;
    }

    private void mapTickerResponse(Stock stock, TickerResponse tickerResponse) {
        TickerInfo tickerInfo = new TickerInfo();
        tickerInfo.setStockName(stock.getName());
        tickerInfo.setTicker(stock.getSymbol());
        tickerInfo.setStockCurrency(stock.getCurrency());
        tickerInfo.setStockExchange(stock.getStockExchange());
        tickerInfo.setStockPrice(stock.getQuote().getPrice());

        tickerResponse.setTickerInfo(tickerInfo);
    }

}
