package com.windischadrian.financeAPI.model.Entities;

import jakarta.persistence.ElementCollection;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;

import java.util.HashMap;

@Data
@Entity
public class PopularTickerEntity {

    @Id
    private String date;

    @ElementCollection
    private HashMap<String, Integer> tickerCount;

    public PopularTickerEntity(){}

    public PopularTickerEntity(String date)  {
        this.date = date;
        tickerCount = new HashMap<>();
    }
}

