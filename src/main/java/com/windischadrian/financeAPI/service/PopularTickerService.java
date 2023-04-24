package com.windischadrian.financeAPI.service;

import com.windischadrian.financeAPI.model.Entities.PopularTickerEntity;
import com.windischadrian.financeAPI.repositories.PopularTickerRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.Map;
import java.util.NoSuchElementException;

@Service
@Slf4j
public class PopularTickerService {

    @Autowired
    private PopularTickerRepository popularTickerRepository;

    public PopularTickerEntity getPopularTickersFromDate(String date) {

        PopularTickerEntity pte = getTickerFromDate(date);
        if(!pte.getTickerCount().isEmpty())
            return pte;
        else throw new NoSuchElementException("No tickers for specified date.");
    }
    
    public void addTickerToday(String ticker) {
        String localDate = LocalDate.now().toString();

        PopularTickerEntity pte = getTickerFromDate(localDate);
        Map<String, Integer> tickerCount = pte.getTickerCount();
        tickerCount.merge(ticker, 1, Integer::sum); //set 1 if does not exist, otherwise increment
        pte.setTickerCount(tickerCount);
        log.info("PopularTickerEntity: {}", pte);
        popularTickerRepository.save(pte);
        log.info("Incremented ticker popularity count: {} - date: {}", ticker, localDate);
    }

    private PopularTickerEntity getTickerFromDate(String date) {
        return popularTickerRepository.findById(date).orElseGet(() -> new PopularTickerEntity(date));
    }
}
