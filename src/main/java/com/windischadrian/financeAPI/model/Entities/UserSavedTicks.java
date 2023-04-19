package com.windischadrian.financeAPI.model.Entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.Data;

import java.util.List;

@Data
@Entity
public class UserSavedTicks {

    @Id
    @GeneratedValue
    private Long id;

    private String userID;

    @OneToMany
    private List<Tick> ticks;
}
