package com.windischadrian.financeAPI.repositories;

import com.windischadrian.financeAPI.model.Entities.PopularTickerEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PopularTickerRepository extends CrudRepository<PopularTickerEntity, String> {

}
