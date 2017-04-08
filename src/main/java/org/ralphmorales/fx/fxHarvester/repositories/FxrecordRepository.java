package org.ralphmorales.fx.fxHarvester.repositories;

import org.ralphmorales.fx.fxHarvester.entities.Fxrecord;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FxrecordRepository extends CrudRepository<Fxrecord, Long>{

}
