package com.windischadrian.financeAPI.repositories;

import com.windischadrian.financeAPI.model.Entities.UserSavedTickers;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FinanceRepository extends CrudRepository<UserSavedTickers, String> {
}
