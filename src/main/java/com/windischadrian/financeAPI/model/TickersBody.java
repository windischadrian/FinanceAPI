package com.windischadrian.financeAPI.model;

import lombok.Data;

import java.util.List;

@Data
public class TickersBody {
    private List<String> tickers;
}
