package com.windischadrian.financeAPI.service;

import com.windischadrian.financeAPI.model.Entities.UserSavedTicks;
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

    public UserSavedTicks getTickers(String userId) {
        return financeRepository.findById(userId).get();
    }

    public UserSavedTicks addTickers(String userId, TickersBody tickersBody) {
        UserSavedTicks ust = getUserSavedTicks(userId);

        return setTickers(ust, tickersBody);
    }

    public UserSavedTicks deleteTickers(String userId, TickersBody tickersBody) {
        UserSavedTicks ust = getUserSavedTicks(userId);

        return deleteTickersFromUserSaved(ust, tickersBody);

    }

    private UserSavedTicks getUserSavedTicks(String userId) {
        Optional<UserSavedTicks> ustOpt = financeRepository.findById(userId);
        return ustOpt.orElseGet(() -> new UserSavedTicks(userId));
    }

    private UserSavedTicks setTickers(UserSavedTicks ust, TickersBody tickersBody) {
        List<String> tickers = Optional.ofNullable(ust.getTickers()).orElseGet(ArrayList::new);

        tickers.addAll(tickersBody.getTickers());
        ust.setTickers(tickers);

        return financeRepository.save(ust);

    }

    private UserSavedTicks deleteTickersFromUserSaved(UserSavedTicks ust, TickersBody tickersBody) {
        List<String> tickers = ust.getTickers();
        tickers.removeAll(tickersBody.getTickers());

        ust.setTickers(tickers);

        return financeRepository.save(ust);
    }

}
