package com.windischadrian.financeAPI.controller;

import com.windischadrian.financeAPI.model.Entities.PopularTickerEntity;
import com.windischadrian.financeAPI.service.PopularTickerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("${financeapi.endpoint.base}/popular")
public class PopularTickersController {

    @Autowired
    private PopularTickerService popularTickerService;

    @GetMapping("/fromDate/{date}")
    public ResponseEntity<PopularTickerEntity> getPopularTickersFromDate(@PathVariable String date) {

        PopularTickerEntity pte = popularTickerService.getPopularTickersFromDate(date);

        return new ResponseEntity<>(pte, HttpStatus.OK);
    }
}
