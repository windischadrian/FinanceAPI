package com.windischadrian.financeAPI.controller;

import com.windischadrian.financeAPI.model.Entities.UserSavedTickers;
import com.windischadrian.financeAPI.model.TickersBody;
import com.windischadrian.financeAPI.service.UserTickerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/user")
public class UserTickerController {

    @Autowired
    UserTickerService userTickerService;

    @GetMapping(path = "/getTickers/{userId}")
    public ResponseEntity<UserSavedTickers> getTickers(@PathVariable String userId) {
        UserSavedTickers savedTicks = userTickerService.getTickers(userId);

        return new ResponseEntity<>(savedTicks, HttpStatus.OK);
    }

    @PostMapping(path = "/addTickers/{userId}")
    public ResponseEntity<UserSavedTickers> addTickers(@PathVariable String userId, @RequestBody TickersBody tickersBody) {
        UserSavedTickers ust = userTickerService.addTickers(userId, tickersBody);

        return new ResponseEntity<>(ust, HttpStatus.OK);
    }

    @PostMapping(path = "/deleteTickers/{userId}")
    public ResponseEntity<UserSavedTickers> deleteTickers(@PathVariable String userId, @RequestBody TickersBody tickersBody) {
        UserSavedTickers ust = userTickerService.deleteTickers(userId, tickersBody);

        return new ResponseEntity<>(ust, HttpStatus.OK);
    }
}
