package com.windischadrian.financeAPI.model.Entities;

import jakarta.persistence.*;
import lombok.Data;

import java.util.HashMap;
import java.util.Map;

@Data
@Entity
public class PopularTickerEntity {

    @Id
    private String date;

    @ElementCollection
    @MapKeyColumn(name="ticker_count_key")
    private Map<String, Integer> tickerCount;

    public PopularTickerEntity(){}

    public PopularTickerEntity(String date)  {
        this.date = date;
        tickerCount = new HashMap<>();
    }
}

