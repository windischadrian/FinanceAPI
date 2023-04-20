package com.windischadrian.financeAPI.model.Entities;

import jakarta.persistence.CollectionTable;
import jakarta.persistence.ElementCollection;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
@Entity
public class UserSavedTicks {

    @Id
    private String userID;

    @ElementCollection
    private List<String> tickers = new ArrayList<>();

    public UserSavedTicks(String userId) {
        this.userID = userId;
    }

    public UserSavedTicks() {}
}
