package com.windischadrian.financeAPI.controller;

import com.windischadrian.financeAPI.model.TickerResponse;
import com.windischadrian.financeAPI.service.FinanceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;


@Controller(value="/finance")
public class FinanceController {

    @Autowired
    private FinanceService financeService;

    public ResponseEntity<TickerResponse> getInfoByTicker(@PathVariable String ticker) {

        TickerResponse tickerResponse = financeService.getTickerInfo(ticker);

        return new ResponseEntity<TickerResponse>(tickerResponse, HttpStatus.OK);
    }
}
