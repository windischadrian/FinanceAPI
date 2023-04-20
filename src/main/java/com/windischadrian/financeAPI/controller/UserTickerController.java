package com.windischadrian.financeAPI.controller;

import com.windischadrian.financeAPI.model.Entities.UserSavedTicks;
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
    public ResponseEntity<UserSavedTicks> getTickers(@PathVariable String userId) {
        UserSavedTicks savedTicks = userTickerService.getTickers(userId);

        return new ResponseEntity<>(savedTicks, HttpStatus.OK);
    }

    @PostMapping(path = "/addTickers/{userId}")
    public ResponseEntity<UserSavedTicks> addTickers(@PathVariable String userId, @RequestBody TickersBody tickersBody) {
        UserSavedTicks ust = userTickerService.addTickers(userId, tickersBody);

        return new ResponseEntity<>(ust, HttpStatus.OK);
    }

    @PostMapping(path = "/deleteTickers/{userId}")
    public ResponseEntity<UserSavedTicks> deleteTickers(@PathVariable String userId, @RequestBody TickersBody tickersBody) {
        UserSavedTicks ust = userTickerService.deleteTickers(userId, tickersBody);

        return new ResponseEntity<>(ust, HttpStatus.OK);
    }
}
