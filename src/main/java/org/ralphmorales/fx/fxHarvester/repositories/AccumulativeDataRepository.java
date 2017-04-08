package org.ralphmorales.fx.fxHarvester.repositories;

import org.ralphmorales.fx.fxHarvester.entities.AccumulativeData;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface AccumulativeDataRepository extends CrudRepository<AccumulativeData, Long>{

	@Query("SELECT a FROM AccumulativeData a WHERE LOWER(a.orderingCurrency) = LOWER(:orderingCurrency)")
    public AccumulativeData findByOrderingCurrency(@Param("orderingCurrency") String orderingCurrency);
	
}


