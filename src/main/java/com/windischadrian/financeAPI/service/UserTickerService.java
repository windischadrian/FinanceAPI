package com.windischadrian.financeAPI.service;

import com.windischadrian.financeAPI.model.Entities.UserSavedTicks;
import com.windischadrian.financeAPI.repositories.FinanceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class UserTickerService {

    @Autowired
    FinanceRepository financeRepository;

    public void addTicker(String userId, String ticker) {
        UserSavedTicks ust;
        Optional<UserSavedTicks> ustOpt = financeRepository.findById(userId);
        if(ustOpt.isPresent()) {
            ust = ustOpt.get();
        } else {
            ust = new UserSavedTicks();
            ust.setUserID(userId);
            List<String> tickerList = new ArrayList<>();
            ust.setTickers(tickerList);
        }
        ust.getTickers().add(ticker);

        financeRepository.save(ust);

    }

    public UserSavedTicks getTickers(String userId) {
        return financeRepository.findById(userId).get();
    }
}
