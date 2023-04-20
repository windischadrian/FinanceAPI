package com.windischadrian.financeAPI.controller;

import com.windischadrian.financeAPI.model.TickerResponse;
import com.windischadrian.financeAPI.service.FinanceService;
import com.windischadrian.financeAPI.service.UserTickerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.List;


@Controller
@RequestMapping("/api")
public class FinanceController {

    @Autowired
    private FinanceService financeService;

    @Autowired
    private UserTickerService userTickerService;

    @GetMapping("/getTickerInfo/{ticker}")
    public ResponseEntity<TickerResponse> getInfoByTicker(@PathVariable String ticker) {

        TickerResponse tickerResponse = financeService.getTickerInfo(ticker);

        return new ResponseEntity<>(tickerResponse, HttpStatus.OK);
    }

    @GetMapping("/getTickerInfoFromUser/{userId}")
    public ResponseEntity<TickerResponse> getTickerInfoFromUser(@PathVariable String userId) {
        List<String> userTickers = userTickerService.getTickers(userId).getTickers();

        TickerResponse tickerInfo = financeService.getTickerInfo(userTickers);

        return new ResponseEntity<>(tickerInfo, HttpStatus.OK);
    }
}
