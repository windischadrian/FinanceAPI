package com.windischadrian.financeAPI.service;

import com.windischadrian.financeAPI.model.Entities.UserSavedTickersEntity;
import com.windischadrian.financeAPI.model.TickersBody;
import com.windischadrian.financeAPI.repositories.FinanceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class UserTickerService {

    @Autowired
    FinanceRepository financeRepository;

    public UserSavedTickersEntity getTickers(String userId) {

        return financeRepository.findById(userId).orElseThrow(NoSuchElementException::new);
    }

    public UserSavedTickersEntity addTickers(String userId, TickersBody tickersBody) {
        UserSavedTickersEntity ust = getUserSavedTicks(userId);

        return setTickers(ust, tickersBody);
    }

    public UserSavedTickersEntity deleteTickers(String userId, TickersBody tickersBody) {
        if(financeRepository.findById(userId).isEmpty()){
            throw new NoSuchElementException("No such user.");
        }
        UserSavedTickersEntity ust = getUserSavedTicks(userId);

        return deleteTickersFromUserSaved(ust, tickersBody);
    }

    private UserSavedTickersEntity getUserSavedTicks(String userId) {
        Optional<UserSavedTickersEntity> ustOpt = financeRepository.findById(userId);

        return ustOpt.orElseGet(() -> new UserSavedTickersEntity(userId));
    }

    private UserSavedTickersEntity setTickers(UserSavedTickersEntity ust, TickersBody tickersBody) {
        List<String> tickers = Optional.ofNullable(ust.getTickers()).orElseGet(ArrayList::new);

        LinkedHashSet<String> noDuplicatesList = new LinkedHashSet<>(tickers);
        noDuplicatesList.addAll(tickersBody.getTickers());

        ust.setTickers(new ArrayList<>(noDuplicatesList));

        return financeRepository.save(ust);
    }

    private UserSavedTickersEntity deleteTickersFromUserSaved(UserSavedTickersEntity ust, TickersBody tickersBody) {
        List<String> tickers = ust.getTickers();
        tickers.removeAll(tickersBody.getTickers());

        ust.setTickers(tickers);

        return financeRepository.save(ust);
    }

}
