package com.windischadrian.financeAPI.controller;

import com.windischadrian.financeAPI.model.Entities.UserSavedTickersEntity;
import com.windischadrian.financeAPI.model.TickersBody;
import com.windischadrian.financeAPI.service.UserTickerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("${financeapi.endpoint.base}/user")
public class UserTickerController {

    @Autowired
    UserTickerService userTickerService;

    @GetMapping(path = "/getTickers/{userId}")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<UserSavedTickersEntity> getTickers(@PathVariable String userId) {
        UserSavedTickersEntity savedTicks = userTickerService.getTickers(userId);

        return new ResponseEntity<>(savedTicks, HttpStatus.OK);
    }

    @PostMapping(path = "/addTickers/{userId}")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<UserSavedTickersEntity> addTickers(@PathVariable String userId, @RequestBody TickersBody tickersBody) {
        UserSavedTickersEntity ust = userTickerService.addTickers(userId, tickersBody);

        return new ResponseEntity<>(ust, HttpStatus.OK);
    }

    @PostMapping(path = "/deleteTickers/{userId}")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<UserSavedTickersEntity> deleteTickers(@PathVariable String userId, @RequestBody TickersBody tickersBody) {
        UserSavedTickersEntity ust = userTickerService.deleteTickers(userId, tickersBody);

        return new ResponseEntity<>(ust, HttpStatus.OK);
    }
}
