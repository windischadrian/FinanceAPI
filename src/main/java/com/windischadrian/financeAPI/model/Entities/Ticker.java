package com.windischadrian.financeAPI.model.Entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.Data;

@Entity
@Data
public class Ticker {

    @Id
    @GeneratedValue
    private Long id;

    private String tick;
}
