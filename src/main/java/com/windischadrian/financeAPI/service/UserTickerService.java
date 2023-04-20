package com.windischadrian.financeAPI.service;

import com.windischadrian.financeAPI.enums.UserSavedTickerMethods;
import com.windischadrian.financeAPI.model.Entities.UserSavedTickers;
import com.windischadrian.financeAPI.model.TickersBody;
import com.windischadrian.financeAPI.repositories.FinanceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class UserTickerService {

    @Autowired
    FinanceRepository financeRepository;

    public UserSavedTickers getTickers(String userId) {
        return financeRepository.findById(userId).get();
    }

    public UserSavedTickers addTickers(String userId, TickersBody tickersBody) {
        UserSavedTickers ust = getUserSavedTicks(userId);

        return setTickers(ust, tickersBody);
    }

    public UserSavedTickers deleteTickers(String userId, TickersBody tickersBody) {
        UserSavedTickers ust = getUserSavedTicks(userId);

        return deleteTickersFromUserSaved(ust, tickersBody);

    }

    private UserSavedTickers getUserSavedTicks(String userId) {
        Optional<UserSavedTickers> ustOpt = financeRepository.findById(userId);
        return ustOpt.orElseGet(() -> new UserSavedTickers(userId));
    }

    private UserSavedTickers setTickers(UserSavedTickers ust, TickersBody tickersBody) {
        List<String> tickers = Optional.ofNullable(ust.getTickers()).orElseGet(ArrayList::new);

        tickers.addAll(tickersBody.getTickers());
        ust.setTickers(tickers);

        return financeRepository.save(ust);

    }

    private UserSavedTickers deleteTickersFromUserSaved(UserSavedTickers ust, TickersBody tickersBody) {
        List<String> tickers = ust.getTickers();
        tickers.removeAll(tickersBody.getTickers());

        ust.setTickers(tickers);

        return financeRepository.save(ust);
    }

}
