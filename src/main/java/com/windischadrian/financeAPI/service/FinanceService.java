package com.windischadrian.financeAPI.service;

import com.windischadrian.financeAPI.enums.TickerResponseType;
import com.windischadrian.financeAPI.model.TickerInfo;
import com.windischadrian.financeAPI.model.TickerResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import yahoofinance.Stock;
import yahoofinance.YahooFinance;

import java.util.*;

@Slf4j
@Service
public class FinanceService {

    @Autowired
    PopularTickerService popularTickerService;

    public TickerResponse getTickerInfo(String ticker) {
        List<String> tickerList = Collections.singletonList(ticker);
        TickerResponse tickerResponse = new TickerResponse();

        validateStocks(tickerList, tickerResponse);

        log.info("Ticker info for {}: {}", ticker, tickerResponse);
        return tickerResponse;
    }

    public TickerResponse getTickerInfo(List<String> tickerList) {
        TickerResponse tickerResponse = new TickerResponse();

        validateStocks(tickerList, tickerResponse);

        return tickerResponse;
    }

    private void validateStocks(List<String> tickerList, TickerResponse tickerResponse) {
        Map<String, Stock> stockResponseMap = null;
        try {
            stockResponseMap = YahooFinance.get(tickerList.toArray(new String[0]));
            tickerResponse.setResponseType(TickerResponseType.RESPONSE_OK);
        } catch (Exception ex) {
            tickerResponse.setResponseType(TickerResponseType.RESPONSE_ERROR);
        }

        if(Objects.isNull(stockResponseMap)) {
            tickerResponse.setResponseType(TickerResponseType.RESPONSE_INVALID_TICKER);
        } else if (tickerResponse.getResponseType().equals(TickerResponseType.RESPONSE_OK)){
            addTickersPopularity(tickerList);
            mapTickerResponse(stockResponseMap, tickerResponse);
        }
    }

    private void mapTickerResponse(Map<String,Stock> stockMap, TickerResponse tickerResponse) {
        List<TickerInfo> tickerInfoList = new ArrayList<>();
        stockMap.forEach((ticker, stock) -> {
            TickerInfo tickerInfo = new TickerInfo();
            tickerInfo.setStockName(stock.getName());
            tickerInfo.setTicker(stock.getSymbol());
            tickerInfo.setStockCurrency(stock.getCurrency());
            tickerInfo.setStockExchange(stock.getStockExchange());
            tickerInfo.setStockPrice(stock.getQuote().getPrice());

            tickerInfoList.add(tickerInfo);
        });
        
        tickerResponse.setTickerInfo(tickerInfoList);
    }

    @Async
    void addTickersPopularity(List<String> tickerList) {
        for (String s : tickerList) {
            popularTickerService.addTickerToday(s);
        }
    }

}
