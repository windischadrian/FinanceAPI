package com.windischadrian.financeAPI.model.Entities;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Data
@Entity
public class UserSavedTicks {

    @Id
    private String userID;

    @ElementCollection
    private List<String> tickers;
}
