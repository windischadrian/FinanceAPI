package com.windischadrian.financeAPI.controller;

import com.windischadrian.financeAPI.model.Entities.UserSavedTicks;
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

    @PostMapping(path = "/add/{userId}")
    public ResponseEntity addTicker(@PathVariable String userId, @RequestBody String ticker) {
        userTickerService.addTicker(userId, ticker);

        return new ResponseEntity(HttpStatus.OK);
    }

    @GetMapping(path = "/getTicker/{userId}")
    public ResponseEntity<UserSavedTicks> getTickers(@PathVariable String userId) {
        UserSavedTicks savedTicks = userTickerService.getTickers(userId);

        return new ResponseEntity<>(savedTicks, HttpStatus.OK);
    }
}
